/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partida;

/**
 *
 * @author aguirre
 */
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ServidorNB {

    public static void main(String[] args) {
        try {
            String EECO = "";
            int pto = 9999;
            String rechazado = "RECHAZADO";
            String aceptado = "ACEPTADO";
            ArrayList<SocketChannel> clientes = new ArrayList<>();
            ServerSocketChannel s = ServerSocketChannel.open();
            s.configureBlocking(false);
            s.socket().bind(new InetSocketAddress(pto));
            System.out.println("Esperando clientes...");
            Selector sel = Selector.open();
            s.register(sel, SelectionKey.OP_ACCEPT);
            while (true) {
                sel.select();
                Iterator<SelectionKey> it = sel.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey k = (SelectionKey) it.next();
                    it.remove();
                    if (k.isAcceptable()) {
                        SocketChannel cl = s.accept();
                        System.out.println("Cliente conectado desde " + cl.socket().getInetAddress() + ":" + cl.socket().getPort());
                        cl.configureBlocking(false);
                        cl.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        clientes.add(cl);

                        if (clientes.size() >= 5) {
                            try {
                                ByteBuffer bb = ByteBuffer.wrap(rechazado.getBytes());
                                cl.write(bb);
                            } catch (IOException io) {
                            }
                        } else {
                            if (clientes.size() == 2) {
                                JugarPartida partida = new JugarPartida(clientes.get(0), clientes.get(1));
                                partida.start();
                            } else if (clientes.size() == 4) {
                                System.out.println("Enviar a partida 2");
                                JugarPartida partida = new JugarPartida(clientes.get(2), clientes.get(3));
                                partida.start();
                            }
                        }

                        continue;
                    }//if
                    if (k.isReadable()) {
                        try {
                            SocketChannel ch = (SocketChannel) k.channel();
                            ByteBuffer b = ByteBuffer.allocate(2000);
                            b.clear();
                            int n = 0;
                            String msj = "";
                            n = ch.read(b);
                            b.flip();
                            if (n > 0) {
                                msj = new String(b.array(), 0, n);
                            }
                            System.out.println("Mensaje  de " + n + " bytes recibido: " + msj);
                            System.out.println("Cliente conectado desde " + ch.socket().getInetAddress() + ":" + ch.socket().getPort());
                            if (msj.equalsIgnoreCase("SALIR")) {
                                k.interestOps(SelectionKey.OP_WRITE);
                                ch.close();
                                // k.cancel();
                            } else {
                                EECO = "ECO->" + msj;
                                k.interestOps(SelectionKey.OP_WRITE);
                            }//else
                        } catch (IOException io) {
                        }
                        continue;
                    } else if (k.isWritable()) {
                        try {
                            SocketChannel ch = (SocketChannel) k.channel();
                            ByteBuffer bb = ByteBuffer.wrap(EECO.getBytes());
                            ch.write(bb);
                            System.out.println("Mensaje  de " + EECO.length() + " bytes enviado: " + EECO);
                            EECO = "";
                        } catch (IOException io) {
                        }
                        k.interestOps(SelectionKey.OP_READ);
                        continue;
                    }//if
                }//while
            }//while
        } catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//main
}

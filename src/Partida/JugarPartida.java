/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partida;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguirre
 */
public class JugarPartida extends Thread{
    
    SocketChannel cl1 = null, cl2 = null;
    
    public JugarPartida(SocketChannel cl1, SocketChannel cl2){
        this.cl1 = cl1;
        this.cl2 = cl2;
    }
    
    @Override
    public void run(){
//        try {
            System.out.println("Jugando desde hilo: " + cl1.socket().getPort() + " vs " + cl2.socket().getPort());
//            Selector sel = Selector.open();
//            while (true) {
//                sel.select();
//                Iterator<SelectionKey> it = sel.selectedKeys().iterator();
//                while (it.hasNext()) {
//                    SelectionKey k = (SelectionKey) it.next();
//                    it.remove();
//                }
//            }
//        } catch (IOException ex) {
//            System.out.println("Error selector en hilo");
//        }
        
    }
    
}

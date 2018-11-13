/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author aguirre
 */
public class InterfazCliente {

    private Escenario escenarioPropio;
    private Escenario escenarioTiros;

    public InterfazCliente() {
        escenarioPropio = new Escenario(true);
        escenarioTiros = new Escenario(false);
    }

    public void inicailizarEscenario() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Barco barco;
            String coordenada;
            int[] posicion;
            int tamanio = 0;

            //captura submarino
            System.out.println("Intruduce coordenadas del submarino (y,x)");
            barco = new Barco(true);
            for (int i = 0; i < 3; i++) {
                coordenada = br.readLine();
                posicion = new int[2];
                posicion[0] = Integer.parseInt(coordenada.split(",")[0]);
                posicion[1] = Integer.parseInt(coordenada.split(",")[1]);
                barco.getPosicion().add(posicion);
            }
            escenarioPropio.getBarcos().add(barco);

            //captura de barcos
            for (int i = 0; i < 3; i++) {
                barco = new Barco(false);
                System.out.println("Intruduce el tamaño del NUEVO barco (1 o 2)");
                tamanio = Integer.parseInt(br.readLine());
                for (int a = 0; a < tamanio; a++) {
                    System.out.println("Intruduce coordenadas (y,x)");
                    coordenada = br.readLine();
                    posicion = new int[2];
                    posicion[0] = Integer.parseInt(coordenada.split(",")[0]);
                    posicion[1] = Integer.parseInt(coordenada.split(",")[1]);
                    barco.getPosicion().add(posicion);

                }
                escenarioPropio.getBarcos().add(barco);
            }

            //coloca el numero en el tablero para cada barco 1:submarino, 2:barco
            for (Barco barcoEscenario : escenarioPropio.getBarcos()) {
                for (int[] posicionBarco : barcoEscenario.getPosicion()) {
                    escenarioPropio.getTablero()[posicionBarco[0]][posicionBarco[1]] = barcoEscenario.isSubmarino() ? 1 : 2;
                }
            }

        } catch (IOException ex) {
            System.out.println("error lectura desde teclado");
        }
    }

    public void dibujaEscenarios() {
        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 15; x++) {
                System.out.print(escenarioTiros.getTablero()[y][x] + " ");
            }
            System.out.println("");
        }
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 15; x++) {
                switch (escenarioPropio.getTablero()[y][x]) {
                    case 1:
                        System.out.print("S");
                        break;
                    case 2:
                        System.out.print("B");
                        break;
                    default:
                        System.out.print("-");
                        break;
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}

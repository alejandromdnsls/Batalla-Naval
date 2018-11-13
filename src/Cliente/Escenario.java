/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.util.ArrayList;

/**
 *
 * @author aguirre
 */
public class Escenario {
    
    private int tablero[][];
    private boolean isParaBarcos;
    private ArrayList<int[]> posicionTiros;
    private ArrayList<Barco> barcos;
    
    
    public Escenario(boolean isParaBarcos){
        tablero = new int[15][15];
        for(int y=0; y < 15 ; y ++){
            for(int x = 0; x < 15; x ++){
                tablero[y][x] = 0;
            }
        }
        this.isParaBarcos = isParaBarcos;
        if(isParaBarcos){
            barcos = new ArrayList<Barco>();
        }else{
            posicionTiros = new ArrayList<>();
        }
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public boolean isParaBarcos() {
        return isParaBarcos;
    }

    public void setIsParaBarcos(boolean isParaBarcos) {
        this.isParaBarcos = isParaBarcos;
    }

    public ArrayList<int[]> getPosicionTiros() {
        return posicionTiros;
    }

    public void setPosicionTiros(ArrayList<int[]> posicionTiros) {
        this.posicionTiros = posicionTiros;
    }

    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    public void setBarcos(ArrayList<Barco> barcos) {
        this.barcos = barcos;
    }
    
    
    
    
}

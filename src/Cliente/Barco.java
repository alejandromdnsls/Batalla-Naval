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
public class Barco {
    
    private boolean isSubmarino;
    private int tamanio;
    private ArrayList<int[]> posicion;
    private int disparosRecibidos;
    
    public Barco(boolean isSubmarino){
        this.isSubmarino = isSubmarino;
        disparosRecibidos = 0;
        posicion = new ArrayList<>();  
        tamanio = isSubmarino? 3:0;
    }

    public boolean isSubmarino() {
        return isSubmarino;
    }

    public void setIsSubmarino(boolean isSubmarino) {
        this.isSubmarino = isSubmarino;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public ArrayList<int[]> getPosicion() {
        return posicion;
    }

    public void setPosicion(ArrayList<int[]> posicion) {
        this.posicion = posicion;
    }

    public int getDisparosRecibidos() {
        return disparosRecibidos;
    }

    public void setDisparosRecibidos(int disparosRecibidos) {
        this.disparosRecibidos = disparosRecibidos;
    }
 
    
}

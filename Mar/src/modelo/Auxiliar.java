/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Javier Argente Micó
 */
public class Auxiliar {
    
    private int size;
    private boolean muerto;
    
    public Auxiliar(int size, boolean muere){
        
        this.size = size;
        this.muerto = muere;
        
    }

    public int getSize() {
        return size;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public void setSize(int size) {
        this.size += size;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }
    
}

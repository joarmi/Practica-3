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
public class Pez_grande extends Animal {
    
    private int velocidad;
    
    public Pez_grande(int fech, String esp, int velocidad){
        
        super(fech,esp);
        this.velocidad = velocidad;
        
    }

    public int getVelocidad() {
        return velocidad;
    }
    
}

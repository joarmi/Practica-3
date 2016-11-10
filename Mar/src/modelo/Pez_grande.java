/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Random;

/**
 *
 * @author Javier Argente Micó
 */
public class Pez_grande extends Animal implements java.io.Serializable {
    
    private int velocidad;
    
    public Pez_grande(){}
    
    public Pez_grande(int fech, String esp) throws InterruptedException{
        
        super(fech,esp);
        
        Thread.sleep(1);
        
        Random r = new Random(System.currentTimeMillis());
        
        this.velocidad = r.nextInt(60-40+1) + 40;
        
    } 
    
    public Pez_grande(int fech, String esp, int velocidad){
        
        super(fech,esp);
        this.velocidad = velocidad;
        
    }

    public int getVelocidad() {
        return velocidad;
    }
    
    @Override
    public String toString() {

        String s = "Especie: " + this.getEspecie() + " - Dia de nacimiento: " + this.getFecha_nac() + " - Velocidad: " + this.getVelocidad();

        return s;

    }
    
}

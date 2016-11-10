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
public class Pez_pequeño extends Animal implements java.io.Serializable {
    
    private int velocidad;
    
    public Pez_pequeño(){}
    
    public Pez_pequeño(int fech, String esp) throws InterruptedException{
        
        super(fech,esp);
        
        Thread.sleep(1);
        
        Random r = new Random(System.currentTimeMillis());
        
        this.velocidad = r.nextInt(35-15+1) + 15;
        
    }
    
    public Pez_pequeño(int fech, String esp, int velocidad){
        
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

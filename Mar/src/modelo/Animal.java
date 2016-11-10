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
public abstract class Animal implements java.io.Serializable {

    private int fecha_nac;
    private String especie;

    public Animal() {
    }

    ;
    
    public Animal(int fech, String esp) {

        this.fecha_nac = fech;
        this.especie = esp;

    }

    public void setFecha_nac(int fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getFecha_nac() {
        return fecha_nac;
    }

    public String getEspecie() {
        return especie;
    }

    //Funcion que devuelve la cantidad de ha comer en función de quien realice la llamada
    public int comer() throws InterruptedException {

        Thread.sleep(1);
        
        Random r = new Random(System.currentTimeMillis());
        int valor;

        if (this instanceof Gran_depredador) {
            valor = r.nextInt(3);
        } else if (this instanceof Pez_grande) {
            valor = r.nextInt(2) + 1;
        } else {
            valor = r.nextInt(2000000 - 1000000 + 1) + 1000000;
        }

        return valor;
    }

    //Funcion que devuelve un booleano que indica si quien llama a la funcion se reproduce
    public boolean reproduccion() throws InterruptedException {
        
        Thread.sleep(1);

        boolean nace = false;
        Random r = new Random(System.currentTimeMillis());

        int valor = r.nextInt(1000) + 1;

        if ((this instanceof Gran_depredador) && (valor <= 35)) {
            nace = true;
        } else if ((this instanceof Pez_grande) && (valor <= 198)) {
            nace = true;
        } else if ((this instanceof Pez_pequeño) && (valor <= 250)) {
            nace = true;
        }

        return nace;

    }

    //Funcion que devuelve un booleano que indica si quien llama a la funcion muere por enfermedad o causas naturales
    public boolean morir() throws InterruptedException {
        
        Thread.sleep(1);

        boolean muere = false;
        Random r = new Random(System.currentTimeMillis());

        int valor = r.nextInt(1000) + 1;

        if ((this instanceof Gran_depredador) && (valor <= 28)) {
            muere = true;
        } else if ((this instanceof Pez_grande) && (valor <= 93)) {
            muere = true;
        } else if ((this instanceof Pez_pequeño) && (valor <= 163)) {
            muere = true;
        }

        return muere;

    }
    
    //Funcion que devuelve un booleano que indica si quien llama a la funcion muere por contaminacion
    public boolean morir_contaminacion() throws InterruptedException{
        
        Thread.sleep(1);
        
        boolean muere = false;
        Random r = new Random(System.currentTimeMillis());

        int valor = r.nextInt(1000) + 1;
        
        if (valor <= 100) {
            muere = true;
        }

        return muere;
        
    }
    
    ////Funcion que devuelve un booleano que indica si quien llama a la funcion muere porque ha sido cazado y sacrificado
    public boolean morir_cazado() throws InterruptedException{
        
        Thread.sleep(1);
        
        boolean muere = false;
        Random r = new Random(System.currentTimeMillis());

        int valor = r.nextInt(1000) + 1;
        
        if (valor <= 150) {
            muere = true;
        }

        return muere;
        
    }

}

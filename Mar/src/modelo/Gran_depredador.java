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
public class Gran_depredador extends Animal implements java.io.Serializable {
    
    public Gran_depredador(){}
    
    public Gran_depredador(int fech, String esp){
        
        super(fech, esp);
        
    }
    
    @Override
    public String toString() {

        String s = "Especie: " + this.getEspecie() + " - Dia de nacimiento: " + this.getFecha_nac();

        return s;

    }
    
}

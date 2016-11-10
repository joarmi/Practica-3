/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import modelo.Mar;

/**
 *
 * @author Javier Argente Micó
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Mar mar = new Mar();
        mar.crear_vida();
        
        System.out.print(mar.numero_pez_grande()+ "\n" + mar.numero_especie("Atunes") + "\n" + mar.numero_especie("Dorados") + "\n" + mar.numero_especie("Bacalaos") + "\n"
                        + mar.numero_especie("Besugos") + "\n" + mar.numero_especie("Meros") + "\n" + mar.getFecha() + "\n" + mar.getKrill_plancton() + "\n" + mar.getTemperatura() + "\n\n");
        
        mar.pasar_dia();
        
        System.out.print(mar.numero_pez_grande()+ "\n" + mar.numero_especie("Atunes") + "\n" + mar.numero_especie("Dorados") + "\n" + mar.numero_especie("Bacalaos") + "\n"
                        + mar.numero_especie("Besugos") + "\n" + mar.numero_especie("Meros") + "\n" + mar.getFecha() + "\n" + mar.getKrill_plancton() + "\n" + mar.getTemperatura() + "\n\n");
        
    }
    
}

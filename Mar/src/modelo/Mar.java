/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Javier Argente Micó
 */
public class Mar {
    
    private int  krill_plancton;
    private ArrayList<Animal> fauna = new ArrayList<Animal>();
    private int temperatura;
    private int fecha;
    
    public Mar(){   
        this.temperatura = 18;
        this.fecha = 1;
    }
    
    public void crear_vida(){
        
        Random r = new Random(System.currentTimeMillis());
        int valor = 0;
        
        Gran_depredador gd;
        Pez_grande pg;
        Pez_pequeño pp;
        
        valor = r.nextInt(15-12+1) + 12;
        
        for(int i = 1; i <= valor ; i++){
            
            if(i <= valor/3){
                
                gd = new Gran_depredador(this.fecha, "Voraces tiburones blancos");
                this.fauna.add(gd);
                
            }
            
            if((i > valor/3) && (i <= valor/3 * 2)){
                
                gd = new Gran_depredador(this.fecha, "Tiburones toro");
                this.fauna.add(gd);
                
            }
            
            else{
                
                gd = new Gran_depredador(this.fecha, "Peces espada");
                this.fauna.add(gd);
                
            }
            
        }
        
    }
    
}

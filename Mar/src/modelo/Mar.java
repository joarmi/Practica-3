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
public class Mar implements java.io.Serializable {

    private double krill_plancton;
    private ArrayList<Animal> fauna = new ArrayList<Animal>();
    private float temperatura;
    private int fecha;
    private int caza_furtiva;
    private int contaminacion;

    public Mar() {
        this.temperatura = 18;
        this.fecha = 1;
        this.caza_furtiva = 0;
        this.contaminacion = 0;
    }

    public double getKrill_plancton() {
        return krill_plancton;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public int getFecha() {
        return fecha;
    }

    public int getCaza_furtiva() {
        return caza_furtiva;
    }

    public int getContaminacion() {
        return contaminacion;
    }

    public void setCaza_furtiva(int caza_furtiva) {
        this.caza_furtiva = caza_furtiva;
    }

    public void setContaminacion(int contaminacion) {
        this.contaminacion = contaminacion;
    }

    public void temperatura_brusco(int valor) {

        this.temperatura += valor;

    }

    //Funcion que elimina todos los elementos del Array fauna
    public void reiniciar(){
        
        this.fauna.clear();
        
    }
    
    //Funcion que sirve para crear a todos los animales que formarán el Array fauna
    public void crear_vida() throws InterruptedException {

        System.out.print("Creando mar... \n");
        
        this.crear_peces_pequeños();
        this.crear_peces_grandes();
        this.crear_depredadores();
        this.crear_krill_plancton();
        
        System.out.print("Mar creado \n");

    }

    //Funcion que genera a los animales del grupo de grandes depredadores
    public void crear_depredadores() {

        Random r = new Random(System.currentTimeMillis());
        int valor = r.nextInt(15 - 12 + 1) + 12;

        Gran_depredador gd;

        for (int i = 1; i <= valor; i++) {

            if (i <= valor / 3) {

                gd = new Gran_depredador(this.fecha, "Voraces tiburones blancos");
                this.fauna.add(gd);

            } else if ((i > valor / 3) && (i <= valor / 3 * 2)) {

                gd = new Gran_depredador(this.fecha, "Tiburones toro");
                this.fauna.add(gd);

            } else {

                gd = new Gran_depredador(this.fecha, "Peces espada");
                this.fauna.add(gd);

            }

        }

    }

    //Funcion que genera a los animales del grupo de peces grandes
    public void crear_peces_grandes() throws InterruptedException {

        Random r = new Random(System.currentTimeMillis());
        int valor = r.nextInt(140 - 130 + 1) + 130;

        Pez_grande pg;

        for (int i = 0; i <= valor; i++) {

            if (i <= valor / 5) {

                pg = new Pez_grande(this.fecha, "Atunes");
                this.fauna.add(pg);

            } else if ((i > valor / 5) && (i <= valor / 5 * 2)) {

                pg = new Pez_grande(this.fecha, "Dorados");
                this.fauna.add(pg);

            } else if ((i > valor / 5 * 2) && (i <= valor / 5 * 3)) {

                pg = new Pez_grande(this.fecha, "Bacalaos");
                this.fauna.add(pg);

            } else if ((i > valor / 5 * 3) && (i <= valor / 5 * 4)) {

                pg = new Pez_grande(this.fecha, "Besugos");
                this.fauna.add(pg);

            } else {

                pg = new Pez_grande(this.fecha, "Meros");
                this.fauna.add(pg);

            }

        }

    }

    //Funcion que genera a los animales del grupo de peces pequeños
    public void crear_peces_pequeños() throws InterruptedException {

        Random r = new Random(System.currentTimeMillis());
        int valor = r.nextInt(2100 - 1800 + 1) + 1800;

        Pez_pequeño pp;

        for (int i = 0; i <= valor; i++) {

            if (i <= valor / 5) {

                pp = new Pez_pequeño(this.fecha, "Boquerones");
                this.fauna.add(pp);

            } else if ((i > valor / 5) && (i <= valor / 5 * 2)) {

                pp = new Pez_pequeño(this.fecha, "Sardinas");
                this.fauna.add(pp);

            } else if ((i > valor / 5 * 2) && (i <= valor / 5 * 3)) {

                pp = new Pez_pequeño(this.fecha, "Lenguados");
                this.fauna.add(pp);

            } else if ((i > valor / 5 * 3) && (i <= valor / 5 * 4)) {

                pp = new Pez_pequeño(this.fecha, "Jureles");
                this.fauna.add(pp);

            } else {

                pp = new Pez_pequeño(this.fecha, "Gallos");
                this.fauna.add(pp);

            }

        }

    }

    //Funcion que genera la cantidad de krill_plancton que habrá en el mar
    public void crear_krill_plancton() {

        Random r = new Random(System.currentTimeMillis());

        double randomValue = 50000000000l + (70000000000l - 50000000000l) * r.nextDouble();

        this.krill_plancton = randomValue;

    }

    //Funcion que cambio la temperatura al pasar de dia
    public void cambio_temperatura() {

        Random r = new Random(System.currentTimeMillis());
        int valor = r.nextInt(100 - 1 + 1) + 1;

        if (this.temperatura >= 19 && valor >= 1 && valor <= 30) {
            this.temperatura += 0.5;
        } else if (this.temperatura >= 19 && valor > 30) {
            this.temperatura -= 0.5;
        } else if (this.temperatura < 19 && this.temperatura > 17 && valor >= 1 && valor <= 45) {
            this.temperatura += 0.5;
        } else if (this.temperatura < 19 && this.temperatura > 17 && valor >= 46 && valor <= 90) {
            this.temperatura -= 0.5;
        } else if (this.temperatura < 19 && this.temperatura > 17 && valor > 90) {
            this.temperatura += 0;
        } else if (this.temperatura <= 17 && valor >= 1 && valor <= 70) {
            this.temperatura += 0.5;
        } else {
            this.temperatura -= 0.5;
        }

    }

    //Funcion que devuelve la cantidad de grandes depredadores que hay en el mar
    public int numero_gran_depredador() {

        int cantidad = 0;
        Animal a_aux;

        for (int i = 0; i < this.fauna.size(); i++) {

            a_aux = this.fauna.get(i);

            if (a_aux instanceof Gran_depredador) {
                cantidad++;
            }

        }

        return cantidad;

    }

    //Funcion que devuelve la cantidad de peces grandes que hay en el mar
    public int numero_pez_grande() {

        int cantidad = 0;
        Animal a_aux;

        for (int i = 0; i < this.fauna.size(); i++) {

            a_aux = this.fauna.get(i);

            if (a_aux instanceof Pez_grande) {
                cantidad++;
            }

        }

        return cantidad;

    }

    //Funcion que devuelve la cantidad de peces pequeños que hay en el mar
    public int numero_pez_pequeño() {

        int cantidad = 0;
        Animal a_aux;

        for (int i = 0; i < this.fauna.size(); i++) {

            a_aux = this.fauna.get(i);

            if (a_aux instanceof Pez_pequeño) {
                cantidad++;
            }

        }

        return cantidad;

    }

    //Funcin que devuelve la cantidad de individuos de una subespecie indicada
    public int numero_especie(String especie) {

        int cantidad = 0;
        String especie_aux;

        for (int i = 0; i < this.fauna.size(); i++) {

            especie_aux = this.fauna.get(i).getEspecie();

            if (especie_aux.equals(especie)) {
                cantidad++;
            }

        }

        return cantidad;

    }

    //Funcion que devuelve la posicion en el Array de fauna, del pez grande que va ha ser devorado
    public int pez_grande_comer() {

        int velocidad = 100;
        int indice = -1;
        Animal a_aux;

        for (int i = 0; i < this.fauna.size(); i++) {

            a_aux = this.fauna.get(i);

            if (a_aux instanceof Pez_grande) {

                if (((Pez_grande) a_aux).getVelocidad() < velocidad) {

                    velocidad = ((Pez_grande) a_aux).getVelocidad();
                    indice = i;

                }

            }

        }

        return indice;

    }

    //Funcion que devuelve la posicion en el Array de fauna, del pez pequeño que va ha ser devorado
    public int pez_pequeño_comer() {

        int velocidad = 100;
        int indice = -1;
        Animal a_aux;

        for (int i = 0; i < this.fauna.size(); i++) {

            a_aux = this.fauna.get(i);

            if (a_aux instanceof Pez_pequeño) {

                if (((Pez_pequeño) a_aux).getVelocidad() < velocidad) {

                    velocidad = ((Pez_pequeño) a_aux).getVelocidad();
                    indice = i;

                }

            }

        }

        return indice;

    }

    //Funcion que hace crecer la cantidad de plancton en funcion de la temperatura del mar
    public void crece_krill_plancton() {

        if (this.temperatura > 19 || this.temperatura < 17) {
            this.krill_plancton += 0;
        } else if (this.temperatura == 19 || this.temperatura == 17) {
            this.krill_plancton += 5000000000l;
        } else {
            this.krill_plancton += 12000000000l;
        }

    }

    //Funcion encargada de calcular comer, reproducirse y morir para todos los animales al pasar el dia
    public void pasar_dia() throws InterruptedException {

        System.out.print("Cargando... \n");
        
        Animal a_aux;
        int size = this.fauna.size();
        int i = 0;
        Auxiliar aux;

        while (i < size) {

            a_aux = this.fauna.get(i);

            if (a_aux instanceof Gran_depredador) {
                
                aux = this.pasar_dia_gran_depredador(a_aux, size, i);

                size = aux.getSize();
                
                if(aux.isMuerto())
                    i--;
                
                i += aux.getRetroceder();

            } else if (a_aux instanceof Pez_grande) {
                
                aux = this.pasar_dia_pez_grande(a_aux, size, i);

                size = aux.getSize();
                
                if(aux.isMuerto())
                    i--;
                
                i += aux.getRetroceder();

            } else {
                
                aux = this.pasar_dia_pez_pequeño(a_aux, size);

                size = aux.getSize();
                
                if(aux.isMuerto())
                    i--;

            }

            i++;

        }
        
        if(this.caza_furtiva > 0)
            this.caza_furtiva -= 1;
        
        if(this.contaminacion > 0)
            this.contaminacion -= 1;

        this.crece_krill_plancton();
        this.cambio_temperatura();
        this.fecha++;
        
        System.out.print("Ha pasado el dia \n");

    }

    //Funcion encargada de realizar comer, reproducirse y morir para los grandes depredadores
    public Auxiliar pasar_dia_gran_depredador(Animal a_aux, int size, int i) throws InterruptedException {

        Gran_depredador gd_aux;
        int indice_animal;
        Auxiliar aux = new Auxiliar(size, false);

        for (int indice = 0; indice < a_aux.comer(); indice++) {

            indice_animal = this.pez_grande_comer();
            
            if (indice_animal == -1) {

                this.fauna.remove(a_aux);
                aux.setSize(-1);
                aux.setMuerto(true);

            } else {

                this.fauna.remove(indice_animal);
                aux.setSize(-1);

            }
            
            if(indice_animal < i && aux.isMuerto() == false){
                
                aux.setRetroceder(-1);
                
            }

        }

        if (a_aux.reproduccion() && aux.isMuerto() == false) {

            gd_aux = new Gran_depredador(this.fecha, a_aux.getEspecie());
            this.fauna.add(gd_aux);

        }

        if (a_aux.morir() && aux.isMuerto() == false) {

            this.fauna.remove(a_aux);
            aux.setSize(-1);
            aux.setMuerto(true);

        }
        
        if(this.caza_furtiva > 0 && a_aux.morir_cazado() && aux.isMuerto() == false){
            
            this.fauna.remove(a_aux);
            aux.setSize(-1);
            aux.setMuerto(true);
            
        }
        
        if(this.contaminacion > 0 && a_aux.morir_contaminacion() && aux.isMuerto() == false){
            
            this.fauna.remove(a_aux);
            aux.setSize(-1);
            aux.setMuerto(true);
            
        }

        return aux;

    }

    //Funcion encargada de realizar comer, reproducirse y morir para los peces grandes
    public Auxiliar pasar_dia_pez_grande(Animal a_aux, int size, int i) throws InterruptedException {

        Pez_grande pg_aux;
        int indice_animal;
        Auxiliar aux = new Auxiliar(size, false);

        for (int indice = 0; indice < a_aux.comer(); indice++) {

            indice_animal = this.pez_pequeño_comer();

            if (indice_animal == -1) {

                this.fauna.remove(a_aux);
                aux.setSize(-1);
                aux.setMuerto(true);

            } else {

                this.fauna.remove(indice_animal);
                aux.setSize(-1);

            }
            
            if(indice_animal < i && aux.isMuerto() == false){
                
                aux.setRetroceder(-1);
                
            }

        }

        if (a_aux.reproduccion() && aux.isMuerto() == false) {

            pg_aux = new Pez_grande(this.fecha, a_aux.getEspecie(), ((Pez_grande) a_aux).getVelocidad());
            this.fauna.add(pg_aux);

        }

        if (a_aux.morir() && aux.isMuerto() == false) {

            this.fauna.remove(a_aux);
            aux.setSize(-1);
            aux.setMuerto(true);

        }
        
        if(this.contaminacion > 0 && a_aux.morir_contaminacion() && aux.isMuerto() == false){
            
            this.fauna.remove(a_aux);
            aux.setSize(-1);
            aux.setMuerto(true);
            
        }

        return aux;

    }

    //Funcion encargada de realizar comer, reproducirse y morir para los peces pequeños
    public Auxiliar pasar_dia_pez_pequeño(Animal a_aux, int size) throws InterruptedException {

        Pez_pequeño pp_aux;
        Auxiliar aux = new Auxiliar(size, false);

        int comida = a_aux.comer();

        if (comida > this.krill_plancton) {

            this.fauna.remove(a_aux);
            aux.setSize(-1);
            aux.setMuerto(true);

        } else {
            this.krill_plancton -= comida;
        }

        if (a_aux.reproduccion() && aux.isMuerto() == false) {

            pp_aux = new Pez_pequeño(this.fecha, a_aux.getEspecie(), ((Pez_pequeño) a_aux).getVelocidad());
            this.fauna.add(pp_aux);

        }

        if (a_aux.morir() && aux.isMuerto() == false) {

            this.fauna.remove(a_aux);
            aux.setSize(-1);
            aux.setMuerto(true);

        }
        
        if(this.contaminacion > 0 && a_aux.morir_contaminacion() && aux.isMuerto() == false){
            
            this.fauna.remove(a_aux);
            aux.setSize(-1);
            aux.setMuerto(true);
            
        }

        return aux;

    }
    
    //Funcion que devuelve una Array con los detalles de todos los animales ordenados por grupos
    public ArrayList<String> mostrar_detalles(){
        
        ArrayList<String> detalles = new ArrayList<String>();
        Animal a_aux;
        
        for(int i = 0; i < this.fauna.size(); i++){
            
            a_aux = this.fauna.get(i);
            
            if(a_aux instanceof Gran_depredador)
                detalles.add(((Gran_depredador) a_aux).toString());
            
        }
        
        for(int i = 0; i < this.fauna.size(); i++){
            
            a_aux = this.fauna.get(i);
            
            if(a_aux instanceof Pez_grande)
                detalles.add(((Pez_grande) a_aux).toString());
            
        }
        
        for(int i = 0; i < this.fauna.size(); i++){
            
            a_aux = this.fauna.get(i);
            
            if(a_aux instanceof Pez_pequeño)
                detalles.add(((Pez_pequeño) a_aux).toString());
            
        }
        
        return detalles;
        
    }

}

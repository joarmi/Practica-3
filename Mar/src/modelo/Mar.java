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

    private double krill_plancton;
    private ArrayList<Animal> fauna = new ArrayList<Animal>();
    private float temperatura;
    private int fecha;

    public Mar() {
        this.temperatura = 18;
        this.fecha = 1;
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

    public void crear_vida() {

        this.crear_depredadores();
        this.crear_peces_grandes();
        this.crear_peces_pequeños();
        this.crear_krill_plancton();

    }

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

    public void crear_peces_grandes() {

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

    public void crear_peces_pequeños() {

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

    public void crear_krill_plancton() {

        Random r = new Random(System.currentTimeMillis());

        double randomValue = 50000000000l + (70000000000l - 50000000000l) * r.nextDouble();

        this.krill_plancton = randomValue;

    }

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

    public void crece_krill_plancton() {

        if (this.temperatura > 19 || this.temperatura < 17) {
            this.krill_plancton += 0;
        } else if (this.temperatura == 19 || this.temperatura == 17) {
            this.krill_plancton += 5000000000l;
        } else {
            this.krill_plancton += 12000000000l;
        }

    }

    public void pasar_dia() {

        Animal a_aux;
        int size = this.fauna.size();
        int i = 0;

        while (i < size) {

            a_aux = this.fauna.get(i);

            if (a_aux instanceof Gran_depredador) {

                size = this.pasar_dia_gran_depredador(a_aux, size, i);

            } else if (a_aux instanceof Pez_grande) {

                size = this.pasar_dia_pez_grande(a_aux, size, i);

            } else {

                size = this.pasar_dia_pez_pequeño(a_aux, size, i);

            }

            i++;

        }

        this.crece_krill_plancton();
        this.cambio_temperatura();
        this.fecha++;

    }

    public int pasar_dia_gran_depredador(Animal a_aux, int size, int i) {

        Gran_depredador gd_aux;
        int indice_animal;
        boolean muerto = false;

        if (a_aux.reproduccion()) {

            gd_aux = new Gran_depredador(this.fecha, a_aux.getEspecie());
            this.fauna.add(gd_aux);
            //size = this.fauna.size();

        }

        for (int indice = 0; indice < a_aux.comer(); indice++) {

            indice_animal = this.pez_grande_comer();

            if (indice_animal == -1) {

                this.fauna.remove(i);
                //size = this.fauna.size();
                size -= 1;
                muerto = true;

            } else {

                this.fauna.remove(indice_animal);
                //size = this.fauna.size();
                size -= 1;

            }

        }

        if (a_aux.morir() && muerto == false) {

            this.fauna.remove(i);
            //size = this.fauna.size();
            size -= 1;

        }

        return size;

    }

    public int pasar_dia_pez_grande(Animal a_aux, int size, int i) {

        Pez_grande pg_aux;
        int indice_animal;
        boolean muerto = false;

        if (a_aux.reproduccion()) {

            pg_aux = new Pez_grande(this.fecha, a_aux.getEspecie(), ((Pez_grande) a_aux).getVelocidad());
            this.fauna.add(pg_aux);
            //size = this.fauna.size();

        }

        for (int indice = 0; indice < a_aux.comer(); indice++) {

            indice_animal = this.pez_pequeño_comer();

            if (indice_animal == -1) {

                this.fauna.remove(i);
                //size = this.fauna.size();
                size -= 1;
                muerto = true;

            } else {

                this.fauna.remove(indice_animal);
                //size = this.fauna.size();
                size -= 1;

            }

        }
        
        if (a_aux.morir() && muerto == false) {

            this.fauna.remove(i);
            //size = this.fauna.size();
            size -= 1;

        }

        return size;

    }

    public int pasar_dia_pez_pequeño(Animal a_aux, int size, int i) {

        Pez_pequeño pp_aux;
        boolean muerto = false;

        if (a_aux.reproduccion()) {

            pp_aux = new Pez_pequeño(this.fecha, a_aux.getEspecie(), ((Pez_pequeño) a_aux).getVelocidad());
            this.fauna.add(pp_aux);
            //size = this.fauna.size();

        }

        int comida = a_aux.comer();

        if (comida > this.krill_plancton) {

            this.fauna.remove(i);
            //size = this.fauna.size();
            size -= 1;
            muerto = true;

        } else {
            this.krill_plancton -= comida;
        }
        
        if (a_aux.morir() && muerto == false) {

            this.fauna.remove(i);
            //size = this.fauna.size();
            size -= 1;

        }

        return size;

    }

}

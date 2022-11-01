package com.example.gasolineraspringboot.gasolinera;

/**
 * Threads
 */
public class Threads extends Thread {
    public String nombreCliente = "";
    private Gasolinera gasolinera;
    private int indice;

    public Threads(String nombre, Gasolinera gasolinera) {
        nombreCliente = nombre;
        this.gasolinera = gasolinera;

    }

    @Override
    public void run() {
        gasolinera.llegado(this);
        indice = gasolinera.surtidorOcupado(this);
        gasolinera.servicio(this,indice);
        gasolinera.pagar(this,indice);
        gasolinera.partir(this,indice);
        gasolinera.semaforo.release();


    }


}
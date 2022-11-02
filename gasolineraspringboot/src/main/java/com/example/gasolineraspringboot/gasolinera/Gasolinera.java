package com.example.gasolineraspringboot.gasolinera;

import java.util.Random;

/**
 * Gasolinera
 */
public class Gasolinera {

    private int numSurtidores;
    private Threads[] surtidores;
    public static Semaforo semaforo;
    private Random rand;

    public Gasolinera( int numSurtidores) {
        this.numSurtidores = numSurtidores;
        semaforo = new Semaforo(numSurtidores);
        surtidores = new Threads[numSurtidores];
        rand = new Random();


    }


    public synchronized void llegado(Threads cliente) {System.out.println(cliente.nombreCliente + " ha llegado"); }

    public synchronized int surtidorOcupado(Threads cliente) {
        int i;
        for (i = 0; i < numSurtidores; i++) {
            if (surtidores[i] == null) {
                System.out.println(cliente.nombreCliente + " ha ocupado el surtidor " + (i +1));
                surtidores[i] = cliente;
                semaforo.acquire(cliente.nombreCliente, surtidores[i]);
                break;

            }
        }
        return i;
    }

    public synchronized void servicio(Threads cliente, int indice) {
        System.out.println(cliente.nombreCliente + " está repostando");
        Lanzador.gui.setColorYellow(indice, cliente.nombreCliente + " está repostando");
        try {
            cliente.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void pagar(Threads cliente, int indice) {
        System.out.println(cliente.nombreCliente + " está pagando");
        Lanzador.gui.setColorGreen(indice, cliente.nombreCliente + " está pagando");
        try {
            cliente.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void partir(Threads cliente, int indice) {
        System.out.println(cliente.nombreCliente + " está saliendo de la gasolinera");
        for (int i = 0; i < numSurtidores; i++) {
            if(surtidores[i] != null && surtidores[i].nombreCliente == cliente.nombreCliente){
                surtidores[i] = null;
            }
        }
        Lanzador.gui.setColorGray(indice, cliente.nombreCliente + " está saliendo de la gasolinera");
    }


}
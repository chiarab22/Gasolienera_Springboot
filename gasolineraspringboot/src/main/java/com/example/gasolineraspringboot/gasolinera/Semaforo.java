package com.example.gasolineraspringboot.gasolinera;


import java.util.LinkedList;
import java.util.Queue;

public class Semaforo {
    private int contador;
    private Queue<Threads> cola = new LinkedList<>();

    public Semaforo(int permisos){
        contador = permisos;
    }

    public void acquire(String nombre, Threads threads) {
        synchronized(this){
            contador--;
        }
        if (contador < 0){
            System.out.println(nombre + " está esperando en la cola.");

            try{
                cola.add(threads);
                threads.join();
            }catch (InterruptedException e){
                //        e.printStackTrace();
            }
        }
    }

    public void release() {
        contador++;

        if (!cola.isEmpty()) {
            Threads cliente = cola.remove();
            cliente.interrupt();
        }

    }


}

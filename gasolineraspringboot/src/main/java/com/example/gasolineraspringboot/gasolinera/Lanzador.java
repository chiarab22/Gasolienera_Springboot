package com.example.gasolineraspringboot.gasolinera;

import java.util.ArrayList;
import java.util.Scanner;

public class Lanzador {
    public static int numSurtidores;
    public static int numClientes;
    public static ArrayList<String> clientes = new ArrayList<>();
    public static Gasolinera gasolinera;
    public static GUI gui;

    public static void lanzador(String[] args){
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introducir el número de surtidores: ");
        numSurtidores = teclado.nextInt();

        gasolinera = new Gasolinera(4);

        System.out.print("Introducir el número de clientes: ");
        numClientes = teclado.nextInt();

        for (int i = 0; i < numClientes; i++) {
            clientes.add("Cliente " + i);
        }
        gui = new GUI(numSurtidores);
        for (int i = 0; i < numClientes; i++) {
            Threads cliente = new Threads(clientes.get(i), gasolinera);
            cliente.start();
        }
    }

}


package com.example.gasolineraspringboot;

import com.example.gasolineraspringboot.gasolinera.Lanzador;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GasolineraSpringBootApplication {

	public static void main(String[] args) {
		Lanzador.lanzador(args);
	}

}

package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import descargas.Conexion;
import descargas.Contenido;
import descargas.Fichero;
import descargas.Identificable;
import descargas.Musica;
import descargas.Pelicula;
import descargas.Utils;

public class DescargaApp {

	public static void main(String[] args) {
		Contenido cancion1 = new Musica(1L, "tituloA");
		Contenido cancion2 = new Musica(2L, "tituloB");
		Contenido pelicula1 = new Pelicula(3L, "tituloC");
		Fichero[] listaDescargas = {
				new Fichero("id1", null, cancion1, 15.2f),
				new Fichero("id2", null, cancion2, 14.5f),
				new Fichero("id3", null, pelicula1, 104.5f)
		};
		Conexion conexion = //new Conexion(5f, "Movistar");
							new Conexion() {
								
								@Override
								public float getVelocidadDescarga() {
									return 5f;
								}
								
							};
		System.out.println("Tiempo estimado: " + Utils.getTiempo(listaDescargas, conexion));
		
		Identificable[] identificables = { listaDescargas[0], cancion2, pelicula1 };
		for (Identificable identificable : identificables) {
			System.out.println(identificable.getId());
		}
		
		
		Collection<Fichero> listaFicheros = new ArrayList<Fichero>();// Arrays.asList(listaDescargas);
		for (int i = 0; i < listaDescargas.length; i++) {
			listaFicheros.add(listaDescargas[i]);
		}
//		listaFicheros.get(0).getId();
		listaFicheros.stream().map(Fichero::getId).forEach(System.out::println);
		listaFicheros.forEach(System.out::println);
		
		System.out.println(calcularTamanoTotal("", listaDescargas[0], listaDescargas[1], listaDescargas[1]));
		
		List<Fichero> descargas = new ArrayList<Fichero>();
		// Cargo la lista en orden inverso
		for (int i = listaDescargas.length - 1; i >= 0; i--) {
			descargas.add(listaDescargas[i]);
		}
		System.out.println("\nCarga inicial");
		descargas.forEach(System.out::println);
		
		System.out.println("\nLista ordenada naturalmente");
		descargas.sort(null);
		descargas.forEach(System.out::println);
		
		Comparator<Fichero> comparaTamano = new Comparator<Fichero>() {
			@Override
			public int compare(Fichero arg0, Fichero arg1) {
				return Float.compare(arg0.getTamano(), arg1.getTamano());
			}
		};
		
		System.out.println("\nLista ordenada por tamaño");
		descargas.sort(comparaTamano);
		descargas.forEach(System.out::println);
	}
	
	private static float calcularTamanoTotal(String loquesea, Fichero... ficheros) {
		return Utils.getTamano(ficheros);
	}
	
	private static float calcularTamanoTotal(Collection<Fichero> ficheros) {
		float total = 0;
		for (Fichero fichero : ficheros) {
			total += fichero.getTamano();
		}
		
		return total;
	}
	
}

package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import descargas.Conexion;
import descargas.ContenidoImpl;
import descargas.Fichero;
import descargas.Identificable;
import descargas.Libro;
import descargas.Musica;
import descargas.Nombrable;
import descargas.Pelicula;
import descargas.Utils;

public class DescargaApp {

	public static <T extends Identificable<String> & Nombrable> void main(String[] args) {
		ContenidoImpl cancion1 = new Musica("1", "tituloA");
		ContenidoImpl cancion2 = new Musica("2", "tituloB");
		ContenidoImpl pelicula1 = new Pelicula("3", "tituloC");
		
		// No se puede crear arrays de genericos
		Fichero[] listaDescargas = {
				new Fichero(1L, null, cancion1, 15.2f),
				new Fichero(2L, null, cancion2, 14.5f),
				new Fichero(3L, null, pelicula1, 104.5f)
		};
		Conexion conexion = () -> 5f; // 5MB/s
		
		List<Fichero<T>> descargas = new ArrayList<>();
		// Cargo la lista en orden inverso
		for (int i = listaDescargas.length - 1; i >= 0; i--) {
			descargas.add(listaDescargas[i]);
		}
		
		// Agrego un tipo heredado de tipo externo
		Libro miLibro = new Libro("XXXX123", "Titulo Libro");
		descargas.add(new Fichero(4L, null, miLibro, 20f));
		
		System.out.println("\nCarga inicial");
		descargas.forEach(System.out::println);
		
		System.out.println("\nLista ordenada naturalmente");
		descargas.sort(null);
		descargas.forEach(System.out::println);
		
		Comparator<Fichero<T>> comparaTamano = new Comparator<>() {
			@Override
			public int compare(Fichero<T> arg0, Fichero<T> arg1) {
				return Float.compare(arg0.getTamano(), arg1.getTamano());
			}
		};
		
		System.out.println("\nLista ordenada por tamaño");
		descargas.sort(comparaTamano);
		descargas.forEach(System.out::println);
		
		System.out.println();
		System.out.println(generarInforme(descargas, conexion));
	}
	
	// Puedo usar una Collection para generalizar y si el Informe me pide una List lo hago al vuelo
	private static <T extends Identificable<String> & Nombrable> Informe<T> generarInforme(Collection<Fichero<T>> descargas, Conexion conexion) {
		List<Fichero<T>> listaDescargas = new ArrayList<>(descargas);
		return new Informe<T>(listaDescargas, conexion);
	}
	
}

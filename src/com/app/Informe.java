package com.app;

import java.util.List;

import descargas.Conexion;
import descargas.Fichero;
import descargas.Identificable;
import descargas.Nombrable;
import descargas.Utils;

public class Informe <T extends Identificable<Long> & Nombrable> {

	private static final String SALTO_LINEA = System.lineSeparator();
	private static final String ENCABEZADO = "Informe descargas";
	private static final char CARACTER_SUBRAYADO = '-';
	private static final String TEXTO_VACIA = "La lista de descargas está vacía.";
	private List<Fichero<T>> descargas;
	private Conexion conexion;
	
	private static String crearSubrayado(char caracterSubrayador, int longitud) {
		// Hay mas formas de hacerlo, todo nativo: https://stackoverflow.com/a/25380937
		return String.format("%0" + longitud + "d", 0).replace('0', caracterSubrayador);
	}
	
	private List<Fichero<T>> getDescargas() {
		return descargas;
	}
	
	private Conexion getConexion() {
		return conexion;
	}
	
	public Informe(List<Fichero<T>> descargas, Conexion conexion) {
		super();
		this.descargas = descargas;
		this.conexion = conexion;
	}

	@Override
	public String toString() {
		// Esta linea es solo para poner bonito el encabezado
		StringBuilder sb = new StringBuilder(ENCABEZADO.toUpperCase() + SALTO_LINEA
				+ crearSubrayado(CARACTER_SUBRAYADO, ENCABEZADO.length()));
		
		getDescargas().sort(null);
		// Lo que tiene que ver con lineaMayor tambien
		int lineaMayor = 0;
		if (getDescargas().size() > 0) {
			for (Fichero fichero : getDescargas()) {
				sb.append(SALTO_LINEA + fichero);
				lineaMayor = Math.max(lineaMayor, fichero.toString().length());
			}
			sb.append(SALTO_LINEA + crearSubrayado(CARACTER_SUBRAYADO, lineaMayor));
			Fichero[] ficheros = getDescargas().toArray(new Fichero[0]);
			sb.append(SALTO_LINEA + "Tamaño total: " + Utils.getTamano(ficheros) + "MB");
			sb.append(SALTO_LINEA + "Tiempo estimado: "
					+ Utils.getTiempo(ficheros, getConexion())+ "s (a " + getConexion().getVelocidadDescarga() + "MB/s)");
		} else {
			sb.append(SALTO_LINEA + TEXTO_VACIA);
			sb.append(SALTO_LINEA + crearSubrayado(CARACTER_SUBRAYADO, TEXTO_VACIA.length()));
		}
		
		return sb.toString();
	}

}

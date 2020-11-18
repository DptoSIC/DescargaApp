package descargas;

public class Utils {

	public static float getTamano(Fichero[] listaDescargas) {
		float resultado  = 0;
		for (int i = 0; i < listaDescargas.length; i++) {
			resultado += listaDescargas[i].getTamano();
		}
		return resultado;
	}

	public static float getTiempo(Fichero[] listaDescargas, Conexion conexion) {
		return getTamano(listaDescargas)/conexion.getVelocidadDescarga();
	}
	
}

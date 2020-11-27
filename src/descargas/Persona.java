package descargas;

public abstract class Persona {

	String nombre;

	public Persona() {
		super();
	}

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		String resultado = nombre;
		if (resultado == null) {
			resultado = "No disponible";
		}
		
		return resultado;
	}

}
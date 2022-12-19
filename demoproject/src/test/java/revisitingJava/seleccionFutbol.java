package revisitingJava;

public class seleccionFutbol {
	int id;
	private String nombre;
	String apellidos;
	int edad;

	public seleccionFutbol(int id, String nombre, String apellidos, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;

	}

	public void concentrarse() {
		System.out.println("Concentrandose ");
	}

	public void viajar() {
		System.out.println("viajar");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

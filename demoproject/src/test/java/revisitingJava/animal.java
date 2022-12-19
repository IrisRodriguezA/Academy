package revisitingJava;

public class animal {

	String nombre;
	String raza;
	int edad;
	String color;
	int noPatas;

	// DECLARANDO EL CONSTRUCTOR DE LA CLASE
	public animal(String nombreEntrada, String razaEntrada, int edadEntrada, String colorEntrada) {

		this.nombre = nombreEntrada;
		this.raza = razaEntrada;
		this.edad = edadEntrada;
		this.color = colorEntrada;
		this.noPatas = 4;
	}

	public void getNombre() {
		System.out.println("Nombre: " + nombre);
	}

	public void getRaza() {
		System.out.println("Raza: " + raza);
	}

	public void getEdad() {
		System.out.println("Edad: " + edad);
	}

	public void getColor() {
		System.out.println("Color: " + color);
	}

	public void cambiarNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
	}

	public static void main(String arg[]) {

	}

	public void hacerSonido() {
		System.out.println("Grrr........");
	}

}

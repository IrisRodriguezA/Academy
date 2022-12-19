package revisitingJava.interfaces;

public class miPrueba {

	@SuppressWarnings("static-access")
	public static void main(String[] arg) {
		operaciones op = new operaciones();

		System.out.println("El resultado de la división es: " + op.dividir(3, 3));

		System.out.println("El resultado de la suma es: " + op.suma(10, 25));

		System.out.println("Obtener dato: " + op.obtenerDato());

		op.guardar(10);

		op.ImprimirNombre();
		op.ImprimirApellido();

		pruebaclase prueba = new pruebaclase();
		pruebaclase prueba2 = new pruebaclase();

		prueba.nombreMascota = "Luna";
		prueba.mostrarNombreMascota();
		prueba2.mostrarNombreMascota();
	}
}

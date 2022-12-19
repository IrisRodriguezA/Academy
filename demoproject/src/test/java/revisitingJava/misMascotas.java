package revisitingJava;

public class misMascotas {

	public static void main(String arg[]) {

		gato gatito = new gato("catnip", "angora", 5, "naranja");
		perro perrito = new perro("huesos", "jitsu", 3, "marron");

		gatito.setDueño("pepe");

		System.out.println(gatito.getDueno());

		perrito.comer();

	}
}

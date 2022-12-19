package revisitingJava;

public class ventaAutos {

	@SuppressWarnings("unused")
	public static void main(String arg[]) {
		agenciaDeCoches agencia = new agenciaDeCoches();

		// USAR METODOS DE LA SUPERCLASE AGENCIADECOCHES
		agenciaDeCoches silverado = new camioneta("chevy", "ramon");

		silverado.establecerConsesionario("chevroletGalo");
		silverado.imprimirNombreConcesionario();

		// USAMOS METODOS DE LA SUBCLASE CAMIONETA
		camioneta tornado = (camioneta) silverado;

		tornado.modelo();

		int numero = (int) '1';

		System.out.println(numero);

	}
}

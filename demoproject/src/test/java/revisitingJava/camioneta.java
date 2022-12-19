package revisitingJava;

public class camioneta extends agenciaDeCoches {

	// ATRIBUTOS
	String marca;
	int año;
	String propietario;

	// METODO CONSTRUCTOR

	public camioneta(String marca, String propietario) {
		this.marca = marca;
		this.propietario = propietario;
	}

	public void modelo() {
		System.out.println("La marca es " + marca + ", y no tiene modelo");
	}

	public void imprimirPropietario() {
		System.out.println(" El propietario de la camioneta es: " + this.propietario);
	}

}

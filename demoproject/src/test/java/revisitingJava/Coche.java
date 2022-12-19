package revisitingJava;

public class Coche extends agenciaDeCoches {

	// ATRIBUTOS
	String marca;
	int año;
	String propietario;

	// METODO CONSTRUCTOR

	public Coche(String marca, String propietario) {
		this.marca = marca;
		this.propietario = propietario;
	}

	public void imprimirModelo() {
		System.out.println("La marca es " + marca + ", y no tiene modelo");
	}

	public void imprimirModelo(String modelo) {
		System.out.println("La marca es " + marca + ", y modelo string: " + modelo);

	}

	public void imprimirModelo(int modelo) {
		System.out.println("La marca es " + marca + ", y modelo numerico: " + modelo);

	}

	public void imprimirModelo(String modelo1, String modelo2) {
		System.out.println("La marca es " + marca + ", y modelo1 : " + modelo1 + " modelo2:" + modelo2);

	}

	public void imprimirPropietario() {
		System.out.println(" El propietario del coche es: " + this.propietario);
	}

}

package revisitingJava;

public class agenciaDeCoches {
	// ATRIBUTTES
	String nombreConcesionario;
	String  direccion;
	
	public void imprimirNombreConcesionario() {
		System.out.println("Concesionario" + nombreConcesionario);
	}

	public void establecerConsesionario(String nombre) {
		this.nombreConcesionario = nombre;
		System.out.println("El concesionario es:" +nombre);
	}

	public void imprimirPropietario() {
		System.out.println("El propietario es la agencia");
	}
	
	
	
	
}

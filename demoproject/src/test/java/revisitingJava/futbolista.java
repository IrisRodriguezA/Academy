package revisitingJava;

public class futbolista extends seleccionFutbol {

	int dorsal;
	String demarcacion;

	public futbolista(int id, String nombre, String apellidos, int edad, int dorsal, String demarcacion) {
		super(id, nombre, apellidos, edad);
		this.dorsal = dorsal;
		this.demarcacion = demarcacion;
	}

	public void jugarPartido() {
		System.out.println("Jugando partido");
	}

	public void entrenar() {
		System.out.println("Entrenando");
	}
}

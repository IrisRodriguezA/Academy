package revisitingJava;

public class entrenador extends seleccionFutbol {
	String idFederacion;

	public entrenador(int id, String nombre, String apellidos, int edad, String idFederacion) {
		super(id, nombre, apellidos, edad);
		this.idFederacion = idFederacion;
	}

	public void dirigirPartido() {
		System.out.println(super.getNombre() + " " + super.apellidos + "-> Dirigiendo partido");
	}

	public void dirigirEntrenamiento() {
		System.out.println("Dirigir entrenamiento");

	}
}

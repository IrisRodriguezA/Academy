package revisitingJava.abstraccion;

public abstract class Empleado {
	@SuppressWarnings("unused")
	private String nombre;
	@SuppressWarnings("unused")
	private String direccion;

	public abstract float calcularPago(float pago1, float pago2);

	public void modificarNombre(String modif) {
		this.nombre = modif;
	}

	public void modificarDireccion(String dire) {
		this.direccion = dire;
	}

}

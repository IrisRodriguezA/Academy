package revisitingJava.abstraccion;

public abstract class MiClaseAbstracta {

	// UNA PROPIEDAD NORMAL COMO EN CUALQUIER CLASE
	@SuppressWarnings("unused")
	private int propiedad;

	// UNA CONSTANTE
	public static final int CONSTANTE = 1;

	// UN METODO NORMAL COMO EN CUALQUIER CLASE
	protected int sumar(int argumento1, int argumento2) {
		return argumento1 + argumento2;
	}

	public float multiplicacionYdivision(int argumento1, int argumento2) {
		return argumento1 * argumento2 / argumento1;

	}

	// UN METODO ABSTRACTO QUE TIENE QUE SER IMPLEMENTADO POR LA CLASE QUE HEREDE
	// ESTA CLASE ABSTRACTA.
	public abstract int restar(int argumento1, int argumento2);

	public abstract float dividir(int argumento1, int argumento2);

	public abstract void imprimirTexto();

}

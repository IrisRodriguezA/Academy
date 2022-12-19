package revisitingJava.interfaces;

public interface MiInterfaz {

	public static final int VariableInterfaz = 23;

	default void guardar(int dato) {
		int variableGuardar = dato;
		System.out.println("Se guardo el dato: " + variableGuardar);

	}

	public abstract int obtenerDato();

}

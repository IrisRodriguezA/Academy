package revisitingJava.abstraccion;

public class AplicacionMain {

	@SuppressWarnings({ "unused", "static-access" })
	public static void main(String[] args) {

		// MiClaseAbstracta variableOK = new MiClase();

		MiClase variableOK2 = new MiClase();

		MiClase variableOK3 = new MiClase();

		System.out.println("El valor original :" + variableOK3.numeroPrueba);

		// MODIFICANDO EL VALOR DE LA VARIABLE NUMEROPRUEBA
		// variableOK2.numeroPrueba = 2;

		System.out.println("Valor de numeroPrueba" + variableOK3.numeroPrueba);

	}
}
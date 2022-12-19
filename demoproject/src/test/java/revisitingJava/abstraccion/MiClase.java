package revisitingJava.abstraccion;

public class MiClase extends MiClaseAbstracta {

	public static int numeroPrueba = 99;

	@Override
	public void imprimirTexto() {
		System.out.println("algo");
	}

	@Override
	public int restar(int argumento1, int argumento2) {
		return argumento1 - argumento2;
	}

	// COMO SUMAR TIENE EL MODIFICADOR DE ACCESO "PROTECTED" SOLO PUEDE SER ACCEDIDO
	// POR UNA CLASE QUE LO HEREDA
	// POR ESO CREAMOS UNA CLASE PUBLIC QUE INTERNAMENTE LLAMA AL METODO PROTECTED
	// DE LA CLASE PUBLICA.

	public int sumar(int argumento1, int argumento2) {

		// PARA LLAMAR AL METODO DE LA CLASE PADRE
		// USAMOS LA PALABRA CLAVE "SUPER"
		return super.sumar(argumento1, argumento2);
	}

	public int multiplicar(int argumento1, int argumento2) {
		return argumento1 * argumento2;
	}

	@Override
	public float dividir(int argumento1, int argumento2) {
		return argumento1 / argumento2;
	}
}
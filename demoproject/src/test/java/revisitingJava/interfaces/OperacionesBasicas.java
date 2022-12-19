package revisitingJava.interfaces;

public interface OperacionesBasicas {

	default float dividir(int arg1, int arg2) {
		return arg1 / arg2;
	}

	default int suma(int arg1, int arg2) {
		return arg1 + arg2;
	}

	default int multiplicar(int arg1, int arg2) {
		return arg1 * arg2;
	}
}

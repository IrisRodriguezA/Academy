package revisitingJava.abstraccion;

public class PruebaAbstracta {

	public static void main(String arg[]) {

		Empleado variable = new Salario();
		System.out.println("resultado: " + variable.calcularPago(2344, 5));
	}
}

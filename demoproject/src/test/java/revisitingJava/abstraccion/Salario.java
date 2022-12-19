package revisitingJava.abstraccion;

public class Salario extends Empleado {
	String empresa = "Itstark";

	@Override
	public float calcularPago(float pago1, float pago2) {
		return pago1 / pago2;
	}

	public void imprimirTexto() {
		System.out.print(empresa);
	}

}

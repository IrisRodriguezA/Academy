package revisitingJava;

//declarando la clase
public class perro extends animal {
	private String dueño = "";

	public perro(String nombreEntrada, String razaEntrada, int edadEntrada, String colorEntrada) {
		super(nombreEntrada, razaEntrada, edadEntrada, colorEntrada);
	}

	public void ladrar() {
		System.out.println("guau guau");
	}

	public void comer() {
		System.out.println("ñam ñam");

	}

	public void establecerDueño(String nuevoDueño) {
		this.dueño = nuevoDueño;
	}

	public void getDueño() {
		System.out.println("Dueño: " + this.dueño);

	}

	public static void main(String arg[]) {
		perro solo = new perro("solovino", "husky", 4, "blanco/gris");

		solo.getRaza();
		solo.getDueño();
		solo.getColor();

		solo.establecerDueño("juan");
		solo.getDueño();

	}

	public void hacerSonido() {
		System.out.println("Guau guau guau guau");

	}

}

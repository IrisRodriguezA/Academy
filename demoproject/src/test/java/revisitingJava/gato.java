package revisitingJava;

public class gato extends animal {
	private String dueño;
	public String vacunacion;

	public gato(String nombreEntrada, String razaEntrada, int edadEntrada, String colorEntrada) {
		super(nombreEntrada, razaEntrada, edadEntrada, colorEntrada);

	}

	public void maullar() {
		System.out.println("miau");
	}

	public void duerme() {
		System.out.println("brrr brrr brrr");

	}

	public void hacerSonido() {
		System.out.println("Miau miau miau");
	}

	public void brinca() {
		System.out.println("brinca");
	}

	public void setDueño(String dueño) {
		this.dueño = dueño;
	}

	public String getDueno() {
		return this.dueño;
	}

	public void brinca(int numeroDeBrincos) {
		for (int numero = 0; numero < numeroDeBrincos; numero++) {
			System.out.println("brinca!!!");
		}
	}

}
package revisitingJava;

import java.util.ArrayList;

public class Main {

	public static ArrayList<seleccionFutbol> integrantes = new ArrayList<seleccionFutbol>();

	public static void main(String arg[]) {
		entrenador MiguelHerrera = new entrenador(1, "Miguel", "Herrera", 50, "123ID23");
		futbolista guillermoOchoa = new futbolista(2, "Guillermo", "Ochoa", 36, 10, "arquero");
		futbolista cuahu = new futbolista(2, "Cuahutemoc", "Blanco", 45, 8, "delantero");

		masajista albertoPerez = new masajista(3, "Alberto", "Perez", 40, "Licenciado en Fisioterpia", 20);

		integrantes.add(MiguelHerrera);
		integrantes.add(guillermoOchoa);
		integrantes.add(albertoPerez);
		integrantes.add(cuahu);

		System.out.println(" Todos los integrantes viajan para jugar un partido");
		for (seleccionFutbol integrante : integrantes) {
			System.out.println(integrante.getNombre() + " " + integrante.apellidos + " - >");
			integrante.viajar();
		}

		System.out.println("Todos los integrantes comienzan una concentracion");
		for (seleccionFutbol integrante : integrantes) {
			System.out.println(integrante.getNombre() + " " + integrante.apellidos + " - >");
			integrante.concentrarse();
		}

		System.out.println("Entrenamient: Solamente el entrenador y el futbolista tienen metodos para entrenar");
		System.out.println(MiguelHerrera.getNombre() + " " + MiguelHerrera.apellidos + " - > ");
		MiguelHerrera.dirigirEntrenamiento();

		System.out.println(guillermoOchoa.getNombre() + " " + guillermoOchoa.apellidos + " - > ");
		guillermoOchoa.entrenar();

		System.out.println(cuahu.getNombre() + " " + cuahu.apellidos + " - > ");
		cuahu.entrenar();

		System.out.println("Partido: Solamente el entrenador y el futbolista tienen metodos para el partido");
		MiguelHerrera.dirigirPartido();

	}
}

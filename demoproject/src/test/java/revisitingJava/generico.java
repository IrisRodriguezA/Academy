package revisitingJava;

import revisitingJava.operaciones.multiply;

public class generico {
	int numero = 0;

	public static void main(String arg[]) {
		int intArray[] = new int[] { 12, 24, 35, 46, 45 };

		for (int index = 0; index < intArray.length; index++) {
			System.out.println("Valor del elemento en el indice" + index + ": " + intArray[index]);
		}

		int xlimit = 3;
		int ylimit = 3;

		int dosdimensiones[][] = new int[xlimit][ylimit];

		dosdimensiones[0][0] = 99;
		dosdimensiones[0][1] = 98;
		dosdimensiones[0][2] = 97;
		dosdimensiones[1][0] = 100;
		dosdimensiones[1][1] = 101;
		dosdimensiones[1][2] = 102;
		dosdimensiones[2][0] = 103;
		dosdimensiones[2][1] = 104;
		dosdimensiones[2][2] = 105;

		for (int y = 0; y < ylimit; y++) {
			for (int x = 0; x < xlimit; x++) {
				System.out.println(dosdimensiones[x][y]);
			}
		}

		multiply.multiplicar();

	}
}

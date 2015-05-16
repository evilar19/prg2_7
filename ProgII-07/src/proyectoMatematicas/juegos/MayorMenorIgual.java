package proyectoMatematicas.juegos;

import java.util.Random;

import proyectoMatematicas.Utilidades;

public class MayorMenorIgual implements Jugable {

	public void jugar() {
		boolean continua = true;// variable para saber si desea jugar de nuevo o
		// no
		boolean pasa = true; // variable utilizada para saber si pasa de nivel o
		// salir
		boolean salir = false; // salir del juego
		// no
		int aciertos = 0;// numero de aciertos
		int nivel = 1;// nivel en el que se encuentra el jugador

		int[] dificultad = { 10, 100, 1000 };

		System.out.println("Bienvenido al juego matematico educativo");
		System.out
				.println("¿PORQUE LAS MATES NO TIENEN QUE SER ABURRIDAS!!!");

		do {
			for (int i = 0; i < 10; i++) {
				System.out.println("*********************************");
				System.out.println("NIVEL " + nivel);
				System.out.println("Prueba nï¿½mero " + (i + 1) + ":");
				System.out.println("Se muestran dos numeros");

				int randomInt = (int) (Math.random() * dificultad[nivel - 1] + 1);
				int randomInt2 = (int) (Math.random() * dificultad[nivel - 1] + 1);

				System.out.println("A." + randomInt);
				System.out.println("B." + randomInt2);

				System.out.println("ï¿½Como son los siguientes numeros? ");
				System.out.println("1. A>B");
				System.out.println("2. A<B");
				System.out.println("3. A=B");

				System.out.println("Introduce tu respuesta");
				int opcion = Utilidades.leerEntero();

				switch (opcion) {
				case 1:
					if (randomInt > randomInt2)
						pasa = true;
					else
						pasa = false;
					break;
				case 2:
					if (randomInt < randomInt2) {
						pasa = true;
					} else
						pasa = false;
					break;
				case 3:
					if (randomInt == randomInt2) {
						pasa = true;
					} else
						pasa = false;
					break;
				}

				if (pasa) {
					System.out
							.println("Enhorabuena tu respuesta es correcta pasas");
					aciertos++;
				} else {
					System.out.println("Lo siento, respuesta incorrecta");

				}
			}
			if (aciertos >= 5) {
				if (nivel <= 2) {
					System.out
							.println("Enhorabuena ha pasado al siguiente nivel");
					nivel++;
				} else
					System.out.println("Has ganado!!!");
			} else
				System.out.println("Lo siento no ha pasado el juego ");

			if (nivel <= 2) {

				System.out.println("ï¿½Desea continuar?");
				System.out.println("ï¿½S/N?");
				char respuesta = Utilidades.leerCaracter();
				if (respuesta == 'S') {
					continua = true;
				} else {
					continua = false;
					salir = true;
				}
			} else {
				System.out.println("Ha finalizado el juego campeon");
				salir = true;
			}
		} while ((continua || nivel < 4) || salir);
	}

	public static void main(String[] args) {

	}
}

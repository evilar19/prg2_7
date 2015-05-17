package proyectoMatematicas.juegos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import proyectoMatematicas.JuegoMatesEDU;
import proyectoMatematicas.Utilidades;
import proyectoMatematicas.usuarios.Usuario;

public class MayorMenorIgual extends Juego {
	
	private Usuario user;
	private int points;
	private int times;
	private File file;

	public void jugar(Usuario user, ArrayList<Usuario> array) {
		int p = 0;  // 
		p++;
		int t = 0; //
		this.user = user;
		
		update_score(user,array,t,p);
		
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
				System.out.println("Prueba numero " + (i + 1) + ":");
				System.out.println("Se muestran dos numeros");

				int randomInt = (int) (Math.random() * dificultad[nivel - 1] + 1);
				int randomInt2 = (int) (Math.random() * dificultad[nivel - 1] + 1);

				System.out.println("A." + randomInt);
				System.out.println("B." + randomInt2);

				System.out.println(" Como son los siguientes numeros? ");
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
					p++;
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
					t++;
				} else
					System.out.println("Has ganado!!!");
			} else
				System.out.println("Lo siento no ha pasado el juego ");

			if (nivel <= 2) {

				System.out.println("Desea continuar?");
				System.out.println(" S/N?");
				char respuesta = Utilidades.leerCaracter();
				if (respuesta == 'S' || respuesta == 's') {
					continua = true;
					update_score(user,array,t,p);
				} else {
					continua = false;
					salir = true;
					update_score(user,array,t,p);
				}
			} else {
				System.out.println("Ha finalizado el juego campeon");
				salir = true;
			}
		} while ((continua || nivel < 4) || salir);
	}
	
	public void update_score(Usuario u, ArrayList<Usuario>a, int t, int p){
		ArrayList<Juego> ar = u.getGames();
		
		if(ar == null){
			ar = new ArrayList<Juego>();
		}
		
		if(ar.size() == 0){
			MayorMenorIgual mmi = new MayorMenorIgual(t,p);
			ar.add(mmi);
		}else{
			for(Juego juego : ar){
				if(juego instanceof MayorMenorIgual){
					int t_o = ((MayorMenorIgual) juego).getTimes();
					int p_o = ((MayorMenorIgual) juego).getPoints();
					((MayorMenorIgual) juego).setTimes(t + t_o);
					((MayorMenorIgual) juego).setPoints(p + p_o);
					System.out.println("puntuacion: " + ((MayorMenorIgual) juego).getPoints());
					System.out.println("intentos: " + ((MayorMenorIgual) juego).getTimes());
					break;
				}
			}
		}
		
		
		
		// update game score
		u.setGames(ar);		
		
		try {
			update_array(a);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MayorMenorIgual(int times, int points){
		super();
		this.points = points;
		this.times = times;
	}
	
	public MayorMenorIgual(File file){
		super();
		this.file = file;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}
	public void update_array(ArrayList<Usuario> array) throws IOException{
		if(file.exists()){
			file.delete();
			file.createNewFile();
		}else file.createNewFile();
		
		// write users again
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		for(Usuario u : array){
			oos.writeObject(u);
		}
		
		oos.close();
		fos.close();
	}

}

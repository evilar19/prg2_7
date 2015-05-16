package proyectoMatematicas.usuarios;

import java.util.ArrayList;
import java.util.HashMap;

import proyectoMatematicas.juegos.Juegos;

public class Alumno extends Usuario {

	private HashMap<String, ArrayList<Juegos>> partidas;
	public Alumno() {
		super();
		partidas = new HashMap<String, ArrayList<Juegos>> ();

		// TODO Auto-generated constructor stub
	}

	public Alumno(String nombre, String apellido, int dni, String user,
			String contrasena) {
		super(nombre, apellido, dni, user, contrasena);
		partidas = new HashMap<String, ArrayList<Juegos>> ();
		// TODO Auto-generated constructor stub
	}

	public Alumno(String nombre, String apellido, int dni) {
		// TODO Auto-generated constructor stub
	}

	public void mostrar() {
		System.out.println(" Nombre: " + nombre + " Apellidos: " + apellido
				+ " DNI: " + dni + " y soy alumno.");
	}
}

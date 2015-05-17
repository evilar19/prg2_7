package proyectoMatematicas.usuarios;

import java.util.ArrayList;

import proyectoMatematicas.juegos.Juego;

@SuppressWarnings("serial")
public class Profesor extends Usuario {

	private String materia;

	public Profesor(String nombre, String apellido, int dni, String user, String contrasena, String materia, ArrayList<Juego> games) {
		super(nombre, apellido, dni, user, contrasena, games);
		this.materia = materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public void mostrar() {
		System.out.println("Profesor: " + nombre + " " + apellido + " | DNI: " + dni + " imparte: " + materia);
	}

	
}

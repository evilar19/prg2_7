package proyectoMatematicas.usuarios;

import java.util.ArrayList;

import proyectoMatematicas.Utilidades;

public class Profesor extends Usuario {

	private String materia;
	

	public Profesor() {
		super();
	}

	public Profesor(String nombre, String apellido, int dni, String user,
			String contrasena, String materia) {
		super(nombre, apellido, dni, user, contrasena);
		this.materia = materia;
		// TODO Auto-generated constructor stub
	}

	public Profesor(String nombre, String apellido, int dni, String materia) {
		super(nombre, apellido, dni);
		this.materia = materia;
		// TODO Auto-generated constructor stub
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public void mostrar() {
		System.out.println("Nombre: " + nombre + "Apellidos: " + apellido
				+ "DNI: " + dni + " imparte: " + materia);
	}

	
}

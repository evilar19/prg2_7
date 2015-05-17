package proyectoMatematicas.usuarios;

import java.util.ArrayList;

import proyectoMatematicas.juegos.Juego;

@SuppressWarnings("serial")
public class Administrador extends Usuario {


	// contructor de atributos
	public Administrador(String nombre, String apellido, int dni, String user,String contrasena, ArrayList<Juego> games) {
		super(nombre, apellido, dni, user, contrasena, games);
	}

	// metodo que sirve para mostrar los distintos atributos del usuario en
	// concreto
	public void mostrar() {
		System.out.println(" Administrador: " + nombre + " " + apellido + " | DNI: " + dni);
	}

}

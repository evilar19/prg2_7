package proyectoMatematicas.usuarios;

import java.util.ArrayList;

import proyectoMatematicas.Utilidades;


public class Administrador extends Usuario {

	
	// constructor vacio
	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	// contructor de atributos
	public Administrador(String nombre, String apellido, int dni, String user,
			String contrasena) {
		super(nombre, apellido, dni, user, contrasena);
		// TODO Auto-generated constructor stub
	}

	// metodo que sirve para mostrar los distintos atributos del usuario en
	// concreto
	public void mostrar() {
		System.out.println(" Nombre: " + nombre + " Apellidos: " + apellido
				+ " DNI: " + dni);
	}

	
	

	public static void main(String[] args) {
		Profesor[] arrayProf=new Profesor[50];
		int contador=0;
		Administrador admin = new Administrador("Juan", "Perico", 666666,
				"admin", "1234");
		//admin.crearProfesor(arrayProf, contador);
	//	admin.crearProfesor(arrayProf, contador);
		arrayProf[0].mostrar();
		arrayProf[1].mostrar();
		//admin.modificarProfesor(arrayProf);
		admin.mostrar();
		


	}

}

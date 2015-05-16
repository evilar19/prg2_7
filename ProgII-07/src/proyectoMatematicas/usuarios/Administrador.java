package proyectoMatematicas.usuarios;

@SuppressWarnings("serial")
public class Administrador extends Usuario {


	// contructor de atributos
	public Administrador(String nombre, String apellido, int dni, String user,String contrasena) {
		super(nombre, apellido, dni, user, contrasena);
	}

	// metodo que sirve para mostrar los distintos atributos del usuario en
	// concreto
	public void mostrar() {
		System.out.println(" Administrador: " + nombre + " " + apellido + " | DNI: " + dni);
	}

}

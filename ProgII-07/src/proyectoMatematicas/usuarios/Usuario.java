package proyectoMatematicas.usuarios;

import java.io.Serializable;

//Clase usuario que se utilizara como clase padre de las posteriores 
//clases administrador, profesor y alumno
@SuppressWarnings("serial")
public abstract class Usuario implements Serializable {
	// atributos de la clase usuario
	protected String nombre, apellido;
	protected int dni;
	protected String user;
	protected String contrasena;
	
	public Usuario(String nombre, String apellido, int dni, String user,String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.user = user;
		this.contrasena = contrasena;
	}

	// getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContraseña(String contrasena) {
		this.contrasena = contrasena;
	}

	public abstract void mostrar();

}

package proyectoMatematicas.usuarios;

@SuppressWarnings("serial")
public class Alumno extends Usuario {

	private double nota;

	public Alumno(String nombre, String apellido, int dni, String user, String contrasena, double nota) {
		super(nombre, apellido, dni, user, contrasena);
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public void mostrar() {
		System.out.println(" Alumno: " + nombre + " " + apellido + " | DNI: " + dni + " | Nota: " + nota);
	}
}

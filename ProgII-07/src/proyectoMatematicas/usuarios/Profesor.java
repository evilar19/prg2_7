package proyectoMatematicas.usuarios;

@SuppressWarnings("serial")
public class Profesor extends Usuario {

	private String materia;

	public Profesor(String nombre, String apellido, int dni, String user, String contrasena, String materia) {
		super(nombre, apellido, dni, user, contrasena);
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

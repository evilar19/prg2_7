package proyectoMatematicas;

import proyectoMatematicas.usuarios.Alumno;

//crear hasmap de los juegos y de registro de juego
public class RegistroJuego {
	int puntuacionTotal;
	Alumno alumno;

	public RegistroJuego(int puntuacionTotal, Alumno alumno) {
		super();
		this.puntuacionTotal = puntuacionTotal;
		this.alumno = alumno;
	}

	public int getPuntuacionTotal() {
		return puntuacionTotal;
	}

	public void setPuntuacionTotal(int puntuacionTotal) {
		this.puntuacionTotal = puntuacionTotal;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

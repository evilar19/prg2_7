package proyectoMatematicas.usuarios;

import java.util.ArrayList;
import java.util.List;

import proyectoMatematicas.Utilidades;

public class GestorUsuarios extends Usuario{

	// Atributo lista/Pila/Cola/Diccionario de usuarios
	//crear el lector de ficheros 
	public static List<Usuario> arrayUsuarios;
	public GestorUsuarios() {
		super();
		//hacer el new del list
		// TODO Auto-generated constructor stub
	}

		// metodo usado para crear profesores
		/**Metodo utilizado para crerar profesores en elsistema
		 * @param arrayUsuarios
		 */
		public void crearProfesor() {
			System.out.println("Introduce el nombre del profesor: ");
			String nombre = Utilidades.leerCadena();
			System.out.println("Introduce los apellidos del profesor: ");
			String apellido = Utilidades.leerCadena();
			System.out.println("Introduce el DNI del profesor ");
			int dni = Utilidades.leerEntero();
			System.out.println("Introduce la materia que imparte el profesor ");
			String materia = Utilidades.leerCadena();

			Profesor p = new Profesor(nombre, apellido, dni, materia);
			arrayUsuarios.add(p);
			

		}

		// metodo usado para borrar profesores
		/**Metodo utilizado para borrar profesores en elsistema
		 * @param arrayUsuarios
		 */
		public void borrarProfesor() {
			listarProfesores();// metodo que lista profesores que ya se encuentran
								// introducidos en la lista
			System.out
					.println("Selecciona el profesor que desea borrar de la lista: ");
			int opcion = Utilidades.leerEntero();
			arrayUsuarios.remove(opcion);

		}

		// metodo usado para modificar distintas caracteristicas de los profesores
		/**Metodo utilizado para modificar profesores en elsistema
		 * @param arrayUsuarios
		 */
		public void modificarProfesor() {
			listarProfesores();
			System.out
					.println("Selecciona el profesor que desea modificar de la lista: ");
			int opcion = Utilidades.leerEntero();
		//posible fallo a la hora de introducir los demas datos sin modificar
			Profesor p = (Profesor) arrayUsuarios.get(opcion-1);
			System.out.println("¿Que desea modificar?");
			System.out.println("1.Nombre");
			System.out.println("2.Apellido");
			System.out.println("3.DNI");
			System.out.println("4.Materia");
			int opcion2 = Utilidades.leerEntero();
			switch (opcion2) {
			case 1:
				System.out.println("¿Que nombre desea introducir?");
				String nombre = Utilidades.leerCadena();
				p.setNombre(nombre);
				break;
			case 2:
				System.out.println("¿Que apellido desea introducir?");
				String apellido = Utilidades.leerCadena();
				p.setApellido(apellido);
				break;

			case 3:
				System.out.println("¿Que DNI desea introducir?");
				int dni = Utilidades.leerEntero();
				p.setDni(dni);
				break;

			case 4:
				System.out.println("¿Que materia desea introducir?");
				String materia = Utilidades.leerCadena();
				p.setMateria(materia);
				break;

			}
			arrayUsuarios.set(opcion-1, p);
		}

		// metodo que lista profesores que ya se encuentran introducidos en la lista
		/**Metodo utilizado para listar profesores en elsistema
		 * @param arrayUsuarios2
		 */
		public void listarProfesores() {
			System.out.println("Esta es la lista actual de los profesores ingresados: ");
			int cuenta = 0;
			for (int i = 0; i < arrayUsuarios.size(); i++) {
				System.out.println(cuenta + 1 + ".");
				arrayUsuarios.get(i).mostrar();;
				cuenta++;
			}

		}
		/**Metodo utilizado para crerar alumnos en elsistema
		 * @param arrayUsuarios
		 */
		public void crearAlumno() {
			System.out.println("Introduce el nombre del alumno: ");
			String nombre = Utilidades.leerCadena();
			System.out.println("Introduce los apellidos del alumno: ");
			String apellido = Utilidades.leerCadena();
			System.out.println("Introduce el DNI del alumno ");
			int dni = Utilidades.leerEntero();

			Alumno a = new Alumno(nombre, apellido, dni);
			arrayUsuarios.add(a);

		}

		// metodo usado para borrar alumnos
		/**Metodo utilizado para borrar profesores en elsistema
		 * @param arrayUsuarios
		 */
		public void borrarAlumno() {
			listarAlumnos();// metodo que lista alumnos que ya se encuentran
							// introducidos en la lista
			System.out
					.println("Selecciona el alumno que desea borrar de la lista: ");
			int opcion = Utilidades.leerEntero();
			arrayUsuarios.remove(opcion);

		}

		// metodo usado para modificar distintas caracteristicas de los alumnos
		/**Metodo utilizado para modificar alumnos en elsistema
		 * @param arrayUsuarios
		 */
		public void modificarAlumno() {
			listarAlumnos();
			System.out
					.println("Selecciona el alumno que desea modificar de la lista: ");
			int opcion = Utilidades.leerEntero();
			Alumno a = (Alumno) arrayUsuarios.get(opcion-1);
			System.out.println("¿Que desea modificar?");
			System.out.println("1.Nombre");
			System.out.println("2.Apellido");
			System.out.println("3.DNI");

			int opcion2 = Utilidades.leerEntero();
			switch (opcion2) {
			case 1:
				System.out.println("¿Que nombre desea introducir?");
				String nombre = Utilidades.leerCadena();
				a.setNombre(nombre);
				break;
			case 2:
				System.out.println("¿Que apellido desea introducir?");
				String apellido = Utilidades.leerCadena();
				a.setApellido(apellido);
				break;

			case 3:
				System.out.println("¿Que DNI desea introducir?");
				int dni = Utilidades.leerEntero();
				a.setDni(dni);
				break;

			}
			arrayUsuarios.set(opcion-1, a);
		}

		// metodo que lista profesores que ya se encuentran introducidos en la lista
		/**Metodo utilizado para listar alumnos en elsistema
		 * @param arrayUsuarios2 
		 * @param arrayUsuarios2
		 */
		public void listarAlumnos() {
			System.out
					.println("Esta es la lista actual de los profesores ingresados: ");
			int cuenta = 0;
			for (int i = 0; i < arrayUsuarios.size(); i++) {
				System.out.println(cuenta + 1 + ".");
				arrayUsuarios.get(i).mostrar();;
			cuenta++;
			}

		}
		@Override
		public void mostrar() {
			// TODO Auto-generated method stub
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}

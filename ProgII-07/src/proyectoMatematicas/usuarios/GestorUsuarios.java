package proyectoMatematicas.usuarios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import proyectoMatematicas.Utilidades;

public class GestorUsuarios{

	// Atributo lista/Pila/Cola/Diccionario de usuarios
	//crear el lector de ficheros 
	
	public static ArrayList<Usuario> arrayUsuarios;
	private static File file; 
	
	@SuppressWarnings("static-access")
	public GestorUsuarios(ArrayList<Usuario> arrayUsuarios,File file) {
		this.arrayUsuarios = arrayUsuarios;
		this.file = file;
	}

		// metodo usado para crear profesores
		/**Metodo utilizado para crerar profesores en elsistema
		 * @param arrayUsuarios
		 * @throws IOException 
		 */
		public void crearProfesor() throws IOException {
			System.out.println("Introduce el nombre del profesor: ");
			String nombre = Utilidades.leerCadena();
			System.out.println("Introduce los apellidos del profesor: ");
			String apellido = Utilidades.leerCadena();
			System.out.println("Introduce el DNI del profesor ");
			int dni = Utilidades.leerEntero();
			System.out.println("Introduce el usuario del profesor ");
			String usuario = Utilidades.leerCadena();
			System.out.println("Introduce la contrasena del profesor ");
			String contrasena = Utilidades.leerCadena();
			System.out.println("Introduce la materia que imparte el profesor ");
			String materia = Utilidades.leerCadena();

			Profesor p = new Profesor(nombre, apellido, dni, usuario, contrasena, materia, null);
			
			boolean located = false;
			for(Usuario u : arrayUsuarios){
				if(u.getDni() == dni){
					located = true;
					break;
				}
			}
			
			if(!located){
				arrayUsuarios.add(p);
				update_array(arrayUsuarios);
			}
			else{
				System.out.println("El DNI introducido ya existe: ");
				crearProfesor();
			}

		}

		// metodo usado para borrar profesores
		/**Metodo utilizado para borrar profesores en elsistema
		 * @param arrayUsuarios
		 * @throws IOException 
		 */
		public void borrarProfesor() throws IOException {
			listarProfesores();// metodo que lista profesores que ya se encuentran
								// introducidos en la lista
			System.out.println("Selecciona el profesor que desea borrar de la lista: ");
			int opcion = Utilidades.leerEntero();
			arrayUsuarios.remove(opcion);
			
			update_array(arrayUsuarios);
		}

		// metodo usado para modificar distintas caracteristicas de los profesores
		/**Metodo utilizado para modificar profesores en elsistema
		 * @param arrayUsuarios
		 * @throws IOException 
		 */
		public void modificarProfesor() throws IOException {
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
			
			update_array(arrayUsuarios);
		}

		// metodo que lista profesores que ya se encuentran introducidos en la lista
		/**Metodo utilizado para listar profesores en elsistema
		 * @param arrayUsuarios2
		 */
		public void listarProfesores() {
			System.out.println("Profesores ingresados: ");
			for (int i = 0; i < arrayUsuarios.size(); i++) {
				Usuario u = (Usuario) arrayUsuarios.get(i);
				if(u instanceof Profesor){
					u.mostrar();
				}
			}

		}
		/**Metodo utilizado para crerar alumnos en elsistema
		 * @param arrayUsuarios
		 * @throws IOException 
		 */
		public void crearAlumno() throws IOException {
			System.out.println("Introduce el nombre del alumno: ");
			String nombre = Utilidades.leerCadena();
			System.out.println("Introduce los apellidos del alumno: ");
			String apellido = Utilidades.leerCadena();
			System.out.println("Introduce el DNI del alumno ");
			int dni = Utilidades.leerEntero();
			System.out.println("Introduce el usuario del alumno: ");
			String usuario = Utilidades.leerCadena();
			System.out.println("Introduce la contrasena del alumno: ");
			String contrasena = Utilidades.leerCadena();
			System.out.println("Introduce el DNI del alumno ");
			double nota = Utilidades.leerReal();

			Alumno a = new Alumno(nombre, apellido, dni, usuario, contrasena, nota, null);
			arrayUsuarios.add(a);
			update_array(arrayUsuarios);
		}

		// metodo usado para borrar alumnos
		/**Metodo utilizado para borrar profesores en elsistema
		 * @param arrayUsuarios
		 * @throws IOException 
		 */
		public void borrarAlumno() throws IOException {
			listarAlumnos();// metodo que lista alumnos que ya se encuentran
							// introducidos en la lista
			System.out.println("Selecciona el alumno que desea borrar de la lista: ");
			int opcion = Utilidades.leerEntero();
			arrayUsuarios.remove(opcion);

			update_array(arrayUsuarios);
		}

		// metodo usado para modificar distintas caracteristicas de los alumnos
		/**Metodo utilizado para modificar alumnos en elsistema
		 * @param arrayUsuarios
		 * @throws IOException 
		 */
		public void modificarAlumno() throws IOException {
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
			
			update_array(arrayUsuarios);
		}

		// metodo que lista profesores que ya se encuentran introducidos en la lista
		/**Metodo utilizado para listar alumnos en elsistema
		 * @param arrayUsuarios2 
		 * @param arrayUsuarios2
		 */
		public void listarAlumnos() {
			System.out.println("Alumnos ingresados: ");
			for (int i = 0; i < arrayUsuarios.size(); i++) {
				Usuario u = (Usuario) arrayUsuarios.get(i);
				if(u instanceof Alumno){
					u.mostrar();
				}
			}
		}
		
		public void update_array(ArrayList<Usuario> array) throws IOException{
			if(file.exists()){
				file.delete();
				file.createNewFile();
			}else file.createNewFile();
			
			// write users again
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			for(Usuario u : array){
				oos.writeObject(u);
			}
			
			oos.close();
			fos.close();
		}

	

}

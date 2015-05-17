package proyectoMatematicas;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import proyectoMatematicas.juegos.Juego;
import proyectoMatematicas.juegos.Jugable;
import proyectoMatematicas.juegos.MayorMenorIgual;
import proyectoMatematicas.juegos.NumeroMisterioso;
import proyectoMatematicas.juegos.Restas;
import proyectoMatematicas.juegos.Sumas;
import proyectoMatematicas.usuarios.Administrador;
import proyectoMatematicas.usuarios.Alumno;
import proyectoMatematicas.usuarios.Profesor;
import proyectoMatematicas.usuarios.Usuario;
import proyectoMatematicas.usuarios.GestorUsuarios;

public class JuegoMatesEDU {
	
	private static MayorMenorIgual mmi;
	private static Restas r;
	private static Sumas s;
	private static NumeroMisterioso nm;
	private static GestorUsuarios gestor;
	
	private static File file;

	public static ArrayList<Usuario> arrayUsuarios;
	public static Usuario user;
	private static void escribirMenuInicial() {
		System.out.println("+----------------------------------------+");
		System.out.println("| 		Maths Class- the game            |");
		System.out.println("+----------------------------------------+");
		System.out.println("\t\t 1. Entrar ");
		System.out.println("\t\t 2. Salir");

	}

	/**Metodo que lanza el menu inicial del juego para saber si el usuario introducio
	 * existe o no 
	 * @return true en caso de que el usuario introducido exista
	 * @throws IOException 
	 */
	public static boolean lanzarMenuInicial() throws IOException {
		int opcion = 0;

		// Escribimos el menu
		escribirMenuInicial();

		// Obtenemos la opci贸n
		opcion = Utilidades.leerEntero();

		// Comprobamos que la opci贸n sea alguno de los valores permitidos
		if (opcion == 1) {
			System.out.println("INTRODUCE USUARIO:");
			String nom = Utilidades.leerCadena();
			System.out.println("INTRODUCE CONTRASE袮");
			String cont = Utilidades.leerCadena();
			
			boolean located = false;
			for(Usuario u : arrayUsuarios){
				if(nom.equals(u.getUser())){
					located = true;
					user = (Usuario) u;
					break;
				}
			}
			
			System.out.println("" + located);

			if(located){
				if(user instanceof Administrador){
					lanzarMenuAdministrador();
				}else if(user instanceof Profesor){
					lanzarMenuProfesor();
				}else lanzarMenuAlumno(user);
			} else System.out.println("El usuario introducido no existe");
			
			

		}

		if (opcion == 2) {
			System.out.println();
			System.out.println("Gracias por jugar a este juego... ^_^");
			return false;
		}
		return true;
	}

	/**
	 * Metodo que escribe el menu del administrador en caso de que este
	 * sea el menu seleccionado
	 */
	private static void escribirMenuAdministrador() {
		System.out.println("+----------------------------------------+");
		System.out.println("+       Bienvenido Administrador         +");
		System.out.println("+----------------------------------------+");
		System.out.println("\t\t 1. Crear perfil de profesor ");
		System.out.println("\t\t 2. Borrar perfil de profesor");
		System.out.println("\t\t 3. Modificar perfil de profesor");
		System.out.println("\t\t 4. Consultar listado de profesores");
		System.out.println("\t\t 5. Cerrar sesion");
	}
	/**
	 * Metodo que escribe el menu del profesor en caso de que este
	 * sea el menu seleccionado
	 */
	private static void escribirMenuProfesor() {
		System.out.println("+----------------------------------------+");
		System.out.println("+        Bienvenido Profesor             +");
		System.out.println("+----------------------------------------+");
		System.out.println("\t\t 1. Crear perfil de alumno ");
		System.out.println("\t\t 2. Borrar perfil de alumno");
		System.out.println("\t\t 3. Modificar perfil de alumno");
		System.out.println("\t\t 4. Consultar listado de alumnos");
		System.out.println("\t\t 5. Cerrar sesion");
	}
	/**
	 * Metodo que escribe el menu del alumno en caso de que este
	 * sea el menu seleccionado
	 */
	private static void escribirMenuAlumno() {
		System.out.println("+----------------------------------------+");
		System.out.println("+        Bienvenido Alumno             +");
		System.out.println("+----------------------------------------+");
		System.out.println("\t\t 1. Mayor menor igual");
		System.out.println("\t\t 2. Sumas");
		System.out.println("\t\t 3. Restas");
		System.out.println("\t\t 4. Numero misterioso");
	}
	/**Metodo que lanza el menu inicial del administrador y permite elegir entre varias ociones
	 * crear profesor
	 * borrar profesor
	 * modificar prefesor
	 * listar profesores
	 * @throws IOException 
	 * 
	 */
	public static void lanzarMenuAdministrador() throws IOException {
		int opcion = 0;

		// Escribimos el menu
		escribirMenuAdministrador();

		// Obtenemos la opci贸n
		opcion = Utilidades.leerEntero();

		// Comprobamos que la opci贸n sea alguno de los valores permitidos
		
		switch (opcion) {
			case 1: gestor.crearProfesor();
				break;
			case 2: gestor.borrarProfesor();
				break; 
			case 3: gestor.modificarProfesor();
				break; 
			case 4: gestor.listarProfesores();
				break; 
			default: System.out.println();
			System.out.println("Gracias por jugar a este juego... ^_^");
			
		}
		
	}
	/**Metodo que lanza el menu inicial del profesor y permite elegir entre varias ociones
	 * crear alumno
	 * borrar alumno
	 * modificar alumno
	 * listar alumnos
	 * @throws IOException 
	 * 
	 */
	public static void lanzarMenuProfesor() throws IOException {
		int opcion = 0;

		// Escribimos el menu
		escribirMenuProfesor();

		// Obtenemos la opci贸n
		opcion = Utilidades.leerEntero();

		// Comprobamos que la opci贸n sea alguno de los valores permitidos
		switch (opcion)
		{
			case 1: gestor.crearAlumno();break;
			case 2: gestor.borrarAlumno();break; 
			case 3: gestor.modificarAlumno();break; 
			case 4: gestor.listarAlumnos();break; 
			default: System.out.println();
			System.out.println("Gracias por jugar a este juego... ^_^");
			
		}
		
	}
	// menu alumno
	/**Metodo que lanza el menu inicial del alumno y permite elegir entre varias ociones
	 * juegar al juego mayormenorigual
	 *juegar al juego sumas
	 * juegar al juego restas
	 * juegar al juego numeromisterioso
	 * 
	 */
	public static void lanzarMenuAlumno(Usuario u) {
		int opcion = 0;

		// Escribimos el menu
		escribirMenuAlumno();

		// Obtenemos la opci贸n
		opcion = Utilidades.leerEntero();
		
		// Comprobamos que la opci贸n sea alguno de los valores permitidos
		switch (opcion)
		{
			case 1: mmi.jugar(u,arrayUsuarios);
			break;
			case 2: s.jugar(u,arrayUsuarios);
			break; 
			case 3: r.jugar(u,arrayUsuarios);
			break; 
			case 4: nm.jugar(u,arrayUsuarios);
			
			break; 
			default: System.out.println();
			System.out.println("Gracias por jugar a este juego... ^_^");
			
		}
		
	}

	

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		// file to use
		file = new File("users.dat");
		
		// create users
		check_arrays();	
		
		// games
		mmi = new MayorMenorIgual(file);
		r = new Restas(file);
		s = new Sumas(file);
		nm = new NumeroMisterioso(file);
		
		
		boolean iniciado = true;
		
		gestor = new GestorUsuarios(arrayUsuarios, file);

		while (iniciado) {
			iniciado = lanzarMenuInicial();
		}
	}
	
	private static void check_arrays() throws IOException, ClassNotFoundException{
		
		arrayUsuarios = new ArrayList<Usuario>();
		
		// check if file exists
		if(!file.exists()){
			file.createNewFile();
			write_users();
		}else{
			read_users();
		}
	}
	
	public static void write_users() throws IOException{
		System.out.println("escribiendo");
		arrayUsuarios.add(new Administrador("Juan", "Perico", 666666,"admin", "1234",null));
		arrayUsuarios.add(new Profesor("Profesor", "Oak", 234123, "oak", "2345","Informatica",null));
		arrayUsuarios.add(new Alumno("David", "Valle", 235183, "deif", "5678",5.0,null));
		
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		for(Usuario u : arrayUsuarios){
			oos.writeObject(u);
		}
		
		oos.close();
		fos.close();
	}
	
	public static void read_users() throws IOException, ClassNotFoundException{
		System.out.println("leyendo");
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);

	    for (;;) {
	    	Usuario u;
	        try{
	        	u = (Usuario) ois.readObject();
	        	arrayUsuarios.add(u);
	        }catch(EOFException e){
	        	ois.close();
	    		fis.close();
	        	break;
	        }catch(InvalidClassException i){
	        	ois.close();
	    		fis.close();
	    		if(file.exists()){
	    			file.delete();
	    			file.createNewFile();
	    		}
	    		write_users();
	        	break;
	        }
	    }
	    
		
	}
	
	public static ArrayList<Usuario> get_usuarios(){
		if(arrayUsuarios != null) return arrayUsuarios;
		else return null;
	}

}

package videoclub;

import java.util.*;

public class principalVideoclub {

	static Scanner sc = new Scanner(System.in);
	static Scanner scLine = new Scanner(System.in);
	
	static int dia = 1;
	static double ganancias;
	
	static ArrayList<Pelicula> peliculas= new ArrayList();
	static ArrayList<CD> CDs = new ArrayList();
	
	public static void main(String[] args) {
		
		boolean salir = false;

		while (!salir) {

			int opcion = 0;

			do {
				System.out.println("MENU: DIA " + dia);
				System.out.println("1.- Introducir nuevo producto.");
				System.out.println("2.- Eliminar producto");
				System.out.println("3.- Ver listado de películas");
				System.out.println("4.- Ver listado de CDs");
				System.out.println("5.- Alquilar película");
				System.out.println("6.- Vender disco");
				System.out.println("7.- Ver películas en alquiler");
				System.out.println("8.- Ver ganancias");
				System.out.println("9.- Pasar al día siguiente");

				try {
					System.out.println("\nSeleccione una opción");
					opcion = sc.nextInt();
				} catch (Exception e) {
					System.err.println("Ingresa un número válido");
					sc.next();
				}

			} while (opcion < 1 || opcion > 9);

			switch (opcion) {

			case 1:
				introducirProducto();
				break;
			case 2:
				eliminarProducto();
				break;
			case 3:
				listadoPeliculas();
				break;
			case 4:
				listadoCDs();
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
				
			} // fin switch

		} // fin while

	}

	private static void eliminarProducto() {
		listadoPeliculas();
		listadoCDs();
		System.out.println("¿Que desea eliminar? Pulse 1:Peliculas, 2:CD");
		int pelicula = 1;
		int cd = 2;
		int eliminar = seleccionarNumero(pelicula, cd);
		
		System.out.println("¿Que numero desea eliminar?");
		if(eliminar==1) {
			peliculas.remove(eliminar);
		}
		if(eliminar==2) {
			CDs.remove(eliminar);
		}
		System.out.println("Producto eliminado");
		System.out.println("\nPulse enter para continuar");
		scLine.nextLine();
	}

	private static void listadoCDs() {
		
		for (int i=0; i<CDs.size(); i++) {
			System.out.println(i + " " + CDs.get(i));
		}
		System.out.println("\nPulse enter para continuar");
		scLine.nextLine();
	}

	private static void listadoPeliculas() {
		
		for (int i=0; i<peliculas.size(); i++) {
			System.out.println(i + " " + peliculas.get(i));
		}
		System.out.println("\nPulse enter para continuar");
		scLine.nextLine();
	}

	private static void introducirProducto() {
		boolean salir = false;

		while (!salir) {

			int opcion = 0;

			do {
				System.out.println("¿Qué producto desea añadir?");
				System.out.println("1.- Pelicula");
				System.out.println("2.- CD");
				try {
					System.out.println("\nSeleccione una opción");
					opcion = sc.nextInt();
				} catch (Exception e) {
					System.err.println("Ingresa un número válido");
					sc.next();
				}

			} while (opcion < 1 || opcion > 2);

			switch (opcion) {

			case 1:
				introducirPelicula();
				salir=true;
				break;
			case 2:
				introducirCD();
				salir=true;
				break;

			} // fin switch

		} // fin while
		
	}

	private static void introducirCD() {
		boolean anyadir = false;
		
		do {
			System.out.println("Titulo?");
			String titulo = scLine.nextLine();
			
			System.out.println("Autor");
			String autor = scLine.nextLine();
			
			System.out.println("Precio?");
			double precio = sc.nextInt();
			
			System.out.println("Unidades?");
			int unidades = sc.nextInt();
			
			for (int i=0;i<unidades;i++) {
				CD c = new CD(titulo, autor, precio);
				CDs.add(c);
			}
			
			anyadir = true;
		}
		while(!anyadir);
	}

	private static void introducirPelicula() {
		
		boolean anyadir = false;
		
		do {
			System.out.println("Titulo?");
			String titulo = scLine.nextLine();
			
			System.out.println("Categoria? 1:Novedad, 2:Semi-novedad, 3:Antigua");
			int categoria = sc.nextInt();
			
			System.out.println("Unidades?");
			int unidades = sc.nextInt();
			
			for (int i=0;i<unidades;i++) {
				Pelicula p = new Pelicula(titulo, categoria);
				peliculas.add(p);
			}
			
			anyadir = true;
		}
		while(!anyadir);
	}
	
	
	public static int seleccionarNumero (int a, int b) {
		Scanner sc = new Scanner(System.in);
		
		boolean salir = false;
		int numeroSeleccionado = -100;
		while(!salir) {
			
			int opcion = 0;
			
			do {
				try {
					opcion = sc.nextInt();
				}
				catch (Exception e){
					System.out.println("Seleccione un número valido");
					sc.next();
				}
			} while(opcion < a || opcion > b);
			
			numeroSeleccionado = opcion;
			salir=true;
		}
		return numeroSeleccionado;
	}

} //fin principal

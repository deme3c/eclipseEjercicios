package videoclub;

import java.util.*;

public class principalVideoclub {

	static Scanner sc = new Scanner(System.in);
	static Scanner scLine = new Scanner(System.in);
	
	static int dia = 1;
	static double ganancias;
	static double gananciaAlquileres;
	static double gananciaVentaCD;
	
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
				alquilarPelicula();
				break;
			case 6:
				venderCD();
				break;
			case 7:
				peliculasAlquiladas();
				break;
			case 8:
				ganaciasTotales();
				break;
			case 9:
				pasarDeDia();
				break;
				
			} // fin switch

		} // fin while

	} // fin main

	private static void pasarDeDia() {
		
		System.out.println("Desea pasar al día siguiente (s/n)?");
		String respuesta = scLine.next();
		
		if(respuesta.equalsIgnoreCase("s")) {
			dia+=1;
			
			for(Pelicula p : peliculas) {
				if(!p.isDisponible()) {
					
					p.setDiasAlquilada(p.getDiasAlquilada()+1);
					
					if(p.getCategoria()==1 && p.getDiasAlquilada()==1) {
						p.setDiasAlquilada(0);
						p.setDisponible(true);
					}
					if(p.getCategoria()==2 && p.getDiasAlquilada()==2) {
						p.setDiasAlquilada(0);
						p.setDisponible(true);
					}
					if(p.getCategoria()==3 && p.getDiasAlquilada()==4) {
						p.setDiasAlquilada(0);
						p.setDisponible(true);
					}
				}
			}
		}
		
		System.out.println("\nPulse enter para continuar");
		scLine.nextLine();
	}
	

	private static void ganaciasTotales() {
		
		System.out.println("Ganancias por alquiler de películas: " + gananciaAlquileres);
		System.out.println("Ganancias por venta de CDs: " + gananciaVentaCD);
		System.out.println("\nGanancias totales: " + ganancias);

		System.out.println("\nPulse enter para continuar");
		scLine.nextLine();
	}

	private static void peliculasAlquiladas() {
		
		for(Pelicula p : peliculas) {
			if(!p.isDisponible()) {
				System.out.println(p);
			}
		}
		
		System.out.println("\nPulse enter para continuar");
		scLine.nextLine();
	}

	private static void venderCD() {
		listadoCDs();
		System.out.println("\n¿Qué CD desea vender?\n");
		
		int vender = sc.nextInt();
		
		gananciaVentaCD += CDs.get(vender).getPrecio();
		ganancias += CDs.get(vender).getPrecio();
		
		System.out.println("El disco de titulo: " + CDs.get(vender).getTitulo() + " y autor " + CDs.get(vender).getAutor() +
				" ha sido por vendido por " + CDs.get(vender).getPrecio() + " euros");
		
		CDs.remove(vender);
		
		System.out.println("\nPulse enter para continuar");
		scLine.nextLine();
	}

	private static void alquilarPelicula() {
		
		for (int i=0; i<peliculas.size(); i++) {
			if(peliculas.get(i).isDisponible()) {
				System.out.println(i + " " + peliculas.get(i));
			}	
		}
		
		System.out.println("\n¿Qué película desea alquilar?\n");
		System.out.println("Novedades: alquiler 3 euros unidad por 1 día.");
		System.out.println("Semi-novedades: alquiler 2 euros unidad por 2 días.");
		System.out.println("Antiguas: alquiler 1 euro 4 días.");
		
		int alquilar = sc.nextInt();
		
		if(peliculas.get(alquilar).getCategoria()==1) {
			peliculas.get(alquilar).setDisponible(false);
			gananciaAlquileres+=3;
			ganancias+=3;
		}
		if(peliculas.get(alquilar).getCategoria()==2) {
			peliculas.get(alquilar).setDisponible(false);
			gananciaAlquileres+=2;
			ganancias+=2;
		}
		if(peliculas.get(alquilar).getCategoria()==3) {
			peliculas.get(alquilar).setDisponible(false);
			gananciaAlquileres+=1;
			ganancias+=1;
		}
		
		System.out.println("\nPulse enter para continuar");
		scLine.nextLine();
	}

	private static void eliminarProducto() {
		
		int posicion = 0;
		
		for(Pelicula p : peliculas) {
			System.out.println(posicion + " " + p);
			posicion++;
		}
		for(CD c : CDs) {
			System.out.println(posicion + " " + c);
			posicion++;
		}
		
		System.out.println("¿Qué producto desea eliminar?");
		int eleccion = sc.nextInt();
		
		posicion = 0;
		
		
		for(Pelicula p : peliculas) {
			if(eleccion == posicion) {
				peliculas.remove(p);
				break;
			}
			posicion++;
		}
		for(CD c : CDs) {
			if(eleccion == posicion) {
				CDs.remove(c);
				break;
			}
			posicion++;
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
			double precio = sc.nextDouble();
			
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

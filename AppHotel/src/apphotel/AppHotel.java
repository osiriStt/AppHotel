package apphotel;

import java.util.ArrayList;
import java.util.Scanner;

public class AppHotel {
	static ArrayList<Hotel> dbHotel = new ArrayList<Hotel>();

	public static void main(String[] args) {
		// Var
		menuOpciones();
	}

	public static void menuOpciones() {
		byte opcion;
		do {
			System.out.println("Aplicacio per donar d alta," + " modificar, veure i eliminar hotels.,\n1) "
					+ "Crear Hotel\n2) Donar de Baixa Hotel\n3) Veure Hotel\n4) Modificar Hotel\n5) Sortir");
			Scanner opc = new Scanner(System.in);
			opcion = opc.nextByte();
			switch (opcion) {
			case 1:
				crearHotel();
				opc.close();
				break;
			case 2:
				// Donar de Baixa Hotel
				String nombreHotel = Tools.loadStringData("Ingrese nombre del Hotel a dar de Baja");
				darDeBaixaHotel(nombreHotel);
				break;
			case 3:
				// Veura Hotel
				String nameSearchHotel = Tools.loadStringData("Ingrese nombre del Hotel a buscar");
				veuraHotel(nameSearchHotel);
				break;
			case 4:
				// Modificar Hotel
				String nameModHotel = Tools.loadStringData("Ingrese nombre del Hotel a modificar");
				modificarHotel(nameModHotel);
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Opcion Incorrecta");
				break;
			}
		} while (opcion != 5);
	}

	public static void crearHotel() {
		Scanner tclad = new Scanner(System.in);
		String opcText = "No";
		String nombreHotel;
		int numeroHabitaciones, numeroPlantas;
		double superficieTotalHotel;

		do {
			nombreHotel = Tools.loadStringData("Ingrese Nombre del Hotel");
			numeroHabitaciones = Tools.loadIntData("Ingrese Numero de Habitaciones");
			numeroPlantas = Tools.loadIntData("Indique el numero de plantas del Hotel");
			superficieTotalHotel = Tools.loadDoubleData("Indique la superfie total del Hotel");

			dbHotel.add(new Hotel(nombreHotel, numeroHabitaciones, numeroPlantas, superficieTotalHotel));
			// Mostrar hoteles cargados
			for (Hotel hoteles : dbHotel) {
				System.out.println("\n" + "  Hotel creado:  " + hoteles);
			}
			System.out.print("\n" + "  Agregrar otro Hotel?   Si/No  ");
			opcText = tclad.next();
		} while (opcText.equalsIgnoreCase("SI"));
		tclad.close();
	}

	public static void darDeBaixaHotel(String nombreHotel) { // Hotel dbHotel
		Hotel hoTemp = Tools.searchHotel(nombreHotel, dbHotel);
		if (hoTemp == null) {
			System.out.println("El Hotel: " + nombreHotel + " no encontrado ¿Desea Crear un nuevo Hotel?");
			crearHotel();
		} else {
			dbHotel.remove(hoTemp);
			System.out.println("El Hotel es:   " + nombreHotel + "ha sido dado de baja");
		}
		for (Hotel hoteles : dbHotel) {
			System.out.println("Los Hoteles registrados son:" + hoteles.getnombreHotel());
		}
	}

	public static void veuraHotel(String nombreHotel) {
		Hotel ho = Tools.searchHotel(nombreHotel, dbHotel);
		if (ho == null) {
			System.out.println("El Hotel: " + nombreHotel + " no encontrado ¿Desea Crear un nuevo Hotel?");
			crearHotel();
		} else {
			System.out.println("El Hotel es:   " + nombreHotel);
		}
		double numeroHabitaciones = ho.getNumerohabitaciones();
		// Mostrar Costo Total Mantenimiento
		System.out.println("El costo total de mantenimiento de: " + numeroHabitaciones + "Habitaciones es: "
				+ ho.calcularMantenimiento(ho)); // Correccion Hecha
		}

	public static void modificarHotel(String nombreHotel) {
		Scanner opcSub = new Scanner(System.in);
		byte opcionSub = 0;
		Hotel hoModif = Tools.searchHotel(nombreHotel, dbHotel);
		if (hoModif == null) {
			System.out.println("El Hotel: " + nombreHotel + " no encontrado ¿Desea Crear un nuevo Hotel?");
			crearHotel();
		} else {
			System.out.println("Presione 1) Nombre Hotel  \n" + "2) Modificar el número de habitaciones  \n"
					+ "3) Número de plantas  \n" + "4) Superficie total del hotel.");
			opcionSub = opcSub.nextByte();

			switch (opcionSub) {
			case 1:
				// Modify name
				String modificaNomHotel = Tools.loadStringData("indique nomebre Hotel");
				hoModif.setnombreHotel(modificaNomHotel);
				break;

			case 2:
				// Modify Habs
				int modificaNumHab = Tools.loadIntData("Indique numero Habitaciones");
				hoModif.setNumerohabitaciones(modificaNumHab);
				break;

			case 3:
				// Modify number of Stages?
				int modificaNumPlantas = Tools.loadIntData("Indique numero de Plantas");
				hoModif.setNumerodeplantas(modificaNumPlantas);
				break;
			case 4:
				// Modify Total Square Feet???
				double supTotHot = Tools.loadDoubleData("Indique numero Habitaciones");
				hoModif.setSuperficietotal(supTotHot);
				break;
			}
			opcSub.close();
		}
	}
}



































// Notes cargar obetos arraylist
// Hotel objHotel = new Hotel(nombreHotel, numeroHabitaciones, numeroPlantas,
// superficieTotalHotel);
// dbHotel.add(i, objHotel);

//for(Hotel hoteles : dbHotel) {
//System.out.println(hoteles);
//}

//System.out.println(objHotel.toString());
//System.out.println(dbHotel.get(superficieTotalHotel));        //objHotel.get .getNombre().toString());
//public static ArrayList<Hotel> cargarObjArrayList(Hotel ho);
//boolean ubicado=false;
//dbHotel.indexOf(hoMostrar);
////numHabHoMostrar = dbHotel.get(i).getNumerohabitaciones(); // Dato para calcular mantenimiento
/*
 * byte opcion = 0;
 * 
 * int numHabHoModificar = 0, indexhoModificar = 0;
 * 
 * String hoModificar = "";
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * System.out.println("Introdusca el Hotel a Modificar"); hoModificar =
 * sc.next();
 * 
 * for (int i = 0; i < dbHotel.size(); i++) {
 * 
 * if (dbHotel.get(i).getNombre().equalsIgnoreCase(hoModificar)) {
 * 
 * System.out.println("Hotel encontrado:" + dbHotel.get(i).getNombre());
 * 
 * hoModificar = dbHotel.get(i).getNombre();
 * 
 * indexhoModificar = dbHotel.indexOf(hoModificar);
 * 
 * } else { System.out.println("Hotel no encontrado"); }
 * 
 * // Preguntar por modificaciones Scanner opc = new Scanner(System.in);
 * System.out.
 * println("Presione 1) desea modificar el número de habitaciones, 2) el\r\n" +
 * "	 * número de plantas o la 3) superficie total del hotel."); opcion =
 * opc.nextByte();
 * 
 * switch (opcion) { case 1: // Modificar numero de Habitaciones Scanner
 * opmodHab = new Scanner(System.in);
 * System.out.println("inidque numero Habitaciones"); int modificaHab =
 * opmodHab.nextInt();
 * dbHotel.get(indexhoModificar).setNumerohabitaciones(modificaHab); break;
 * 
 * case 2: // Modificar numero de plantas Scanner opmodNp = new
 * Scanner(System.in); System.out.println("inidque numero Habitaciones"); int
 * modificaNumPlantas = opmodNp.nextInt();
 * dbHotel.get(indexhoModificar).setNumerodeplantas(modificaNumPlantas); break;
 * 
 * case 3: // Modifica Superficie Total Hotel Scanner opmodStH = new
 * Scanner(System.in); System.out.println("inidque numero Habitaciones"); int
 * supTotHot = opmodStH.nextInt();
 * dbHotel.get(indexhoModificar).setSuperficietotal(supTotHot); break; } } }
 */
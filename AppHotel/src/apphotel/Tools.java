package apphotel;

import java.util.*;

public class Tools {

	private static Scanner sc = new Scanner(System.in);

	

	private Tools() {
	}

	// Metodo pedir Datos [cargar el ArrayList] just in case of fire
	public static String loadStringData(String mensaje) { // String Data
		System.out.println(mensaje);
		return sc.nextLine();
	}

	public static int loadIntData(String mensaje) {// int Data
		System.out.println(mensaje);
		return sc.nextInt();
	}

	public static double loadDoubleData(String mensaje) { // Double Data
		System.out.println(mensaje);
		return sc.nextInt();
	}

	public static String[] loadStrArrData(String mensaje) { // load many data one time
		System.out.println(mensaje);
		return sc.nextLine().split(",");
	}

	public static ArrayList<Integer> loadIntArrLData(String mensaje) {
		System.out.println(mensaje);
		ArrayList<Integer> num = new ArrayList<>();
		for (int i = 0; i < num.size(); i++) {
			num.add(sc.nextInt());
		}
		return num;
	}

	// Metodo checkHotel

	public static void showHotels(ArrayList<Hotel> hoteles) {
		if (!hoteles.isEmpty()) {
			System.out.println("Hotel no existe en BD");
		} else {
			for (Hotel ho : hoteles) {
				System.out.println("Listado Hoteles en BD");
			}
		}
	}

	// ArrayList<Hotel> hoArr;//
	public static int cantHotels(ArrayList<Hotel> hoteles) {
		return hoteles.size();
	}
	
	public static Hotel searchHotel (String nombreHotel, ArrayList<Hotel> hoteles) {
		Hotel hotelFinded = null;
		int i=0;
			while(i<hoteles.size() && !hoteles.get(i).getnombreHotel().equalsIgnoreCase(nombreHotel)) {
				i++;
			}
				if(i<hoteles.size()) {
					hotelFinded = hoteles.get(i);
				}
		return hotelFinded;
	}
	
	// Pass an Array Objects as Parameter

} /* End Class */
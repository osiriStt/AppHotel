package apphotel;

import java.util.ArrayList;

public class Hotel {
	// Atributos
	private String nombreHotel;
	private int numerohabitaciones;
	private int numerodeplantas;
	private double superficietotal;

	//Contructores
	
	public Hotel() {
		nombreHotel="Hotel";
		numerohabitaciones=0;
		numerodeplantas=1;
		superficietotal=100.0;
	}
	
	
	public Hotel(String nombreHotel, int numerodehabitaciones, int numerodeplantas, double superficietotal) {
		this.nombreHotel = nombreHotel;
		this.numerohabitaciones = numerodehabitaciones;
		this.numerohabitaciones = numerodeplantas;
		this.superficietotal = superficietotal;
	}

	// Getters and Setters
	public void setnombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public void setNumerohabitaciones(int numerohabitaciones) {
		this.numerohabitaciones = numerohabitaciones;
	}

	public void setNumerodeplantas(int numerodeplantas) {
		this.numerodeplantas = numerodeplantas;
	}

	public void setSuperficietotal(double superficietotal) {
		this.superficietotal = superficietotal;
	}

	public String getnombreHotel() {
		return nombreHotel;
	}

	public int getNumerohabitaciones() {
		return numerohabitaciones;
	}

	public int getNumerodeplantas() {
		return numerodeplantas;
	}

	public double getSuperficietotal() {
		return superficietotal;
	}

	// Metodos de Clase

	public float calcularMantenimiento(Hotel ho) { //no va static porq no se puede llamar 
		return (((ho.getNumerohabitaciones())/20)*1500);
	}

	@Override
	public String toString() {
		return "  nombreHotelHotel Hotel:\n  " + this.nombreHotel + "  \nNumero de Habitaciones\n   " + this.numerohabitaciones
				+ " \nNumero de Plantas del Hotel\n  " + this.numerodeplantas + "  \nSuperficiel Total  "
				+ this.superficietotal;
	}

}



//Notes 
/*String mensaje = "";
int numeroHab = 0, cantMucamas = 0;
double costeTotMantHotel = 0;
cantMucamas = ((numerohabitaciones) / 20); // Cuantas Mucamas son necesarias para limpiar las habitaciones
costeTotMantHotel = (numerohabitaciones /(double) cantMucamas * (1500)); // Coste Total 
return ("Se requieren:  " + cantMucamas + "para limpiar:  " + numeroHab + " habitaciones "
		+ " El coste total es:  " + costeTotMantHotel);*/

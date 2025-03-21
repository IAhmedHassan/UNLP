/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej;

/**
 *
 * @author pelo
 */
public class Estacionamiento {
	private String nombre;
	private String direccion;
	private String horaApertura;
	private String horaCierre;
	private int pisos;
	private int plazas;
	private Auto[][] lugares;

	public Estacionamiento(String nombre, String direccion) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setHoraApertura("8:00");
		this.setHoraCierre("21:00");
		
		this.innitLugares(5,10);
	}

	public Estacionamiento(String nombre, String direccion, String horaApertura, String horaCierre, int pisos, int plazas) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setHoraApertura(horaApertura);
		this.setHoraCierre(horaCierre);
		
		this.innitLugares(pisos, plazas);
	}

	public void registrarAuto(Auto unAuto, int unPiso, int unaPlaza) {
		this.lugares[unPiso -1][unaPlaza -1] = unAuto;
		
	}
	
	public int CantAutosEnPlaza(int unaPlaza) {
		int cant = 0;
		for (int i = 0 ; i < this.getPisos() ; i++) {
			if (this.lugares[i][unaPlaza] != null) {
				cant++;
			}
		}
		return cant;
	}
	
	public String encontrarAutoPorPatente(String unaPatente) {
		int i = 0, j = 0; boolean encontrado = false;
		
		while (i < this.getPisos()) {
			while (j < this.getPlazas()) {
				if (this.lugares[i][j].getPatente().equals(unaPatente))
					return "Piso " + (i+1) + ", plaza " + (j+1); 
				j++;
			}
			i++;
		}
		
		return "Auto Inexistente";
		
	}
	
	
	private void innitLugares(int pisos, int plazas) {
		
		this.setPisos(pisos);
		this.setPlazas(plazas);
		this.lugares = new Auto[pisos][plazas];
		for (int i = 0; i < pisos ; i++) {
			for (int j=0 ; j < plazas ; j++) {
				this.lugares[i][j] = null;
			}
		}
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	private void setHoraApertura(String horaApertura) {
		this.horaApertura = horaApertura;
	}

	private void setHoraCierre(String horaCierre) {
		this.horaCierre = horaCierre;
	}

	private void setPisos(int pisos) {
		this.pisos = pisos;
	}

	private void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
	
	//getters

	private String getNombre() {
		return this.nombre;
	}

	private String getDireccion() {
		return this.direccion;
	}

	private String getHoraApertura() {
		return this.horaApertura;
	}

	private String getHoraCierre() {
		return this.horaCierre;
	}

	private int getPisos() {
		return pisos;
	}

	private int getPlazas() {
		return plazas;
	}

	@Override
	public String toString() {
		String aux = "";
		for (int i = 0 ; i < this.getPisos() ; i++) {
			aux += "---Piso " + (i+1) + "---\n";
			for (int j = 0 ; j < this.getPlazas(); j++) {
				String estado;
				if (this.lugares[i][j] == null) estado = "libre";
				else estado = this.lugares[i][j].toString();
				aux += "Plaza " + (j+1) + ": " + estado + "\n";
			}
		}
		
		return aux; 
	}
	
	
	
}

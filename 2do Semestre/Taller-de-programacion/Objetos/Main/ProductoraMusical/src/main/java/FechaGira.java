/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pelo
 */
public class FechaGira extends Fecha{
	private String ciudad;

	public FechaGira(int dia, int mes, int año, String ciudad) {
		super(dia, mes, año);
		this.setCiudad(ciudad);
	}

	public String getCiudad() {
		return ciudad;
	}

	private void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}

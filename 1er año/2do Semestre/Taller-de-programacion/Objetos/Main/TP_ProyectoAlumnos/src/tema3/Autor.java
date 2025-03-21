/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author pelo
 */
public class Autor {
	
	private String nombre, 
			biografia = "escribió X libros",
			origen = "Posadas, Misiones";

	public Autor(String nombre, String biografia, String origen) {
		this.nombre = nombre;
		this.biografia = biografia;
		this.origen = origen;
	}
	
	public Autor(String unNombre) {
		this.setNombre(unNombre);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getBio() {
		return biografia;
	}
	
	public String getOrigen() {
		return origen;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return (nombre + ", " + biografia + ", " + "oriundo de " + origen + ".");
	}
	
	
	
	
	
	}

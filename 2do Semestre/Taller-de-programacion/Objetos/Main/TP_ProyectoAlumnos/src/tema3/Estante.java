/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author pelo
 */
public class Estante {
	private int capacidad = 20;
	private final Libro[] libros = new Libro[capacidad];
	private int numLibros = 0;
	
	public Estante() {
	}
	
	public Estante(int unaCapacidad) {
		capacidad = unaCapacidad;
	}
	
	public boolean estaLleno() {
		return numLibros == capacidad;
	}
	
	public void agregarLibro(Libro unLibro) {
		if (this.estaLleno()) {
			System.out.println("No se pudo agregar. Estante Lleno.");
		} else {
			libros[numLibros] = unLibro;
			System.out.println("Libro agregado.");
			numLibros++;
		}	
	}
	
	public Libro devolverLibro(String unTitulo) {
		int i;
		for (i=0 ; i < capacidad ; i++) {
			if (libros[i].getTitulo().equals(unTitulo)) {
				System.out.println("Libro encontrado.");
				return libros[i];
			}
		}
		System.out.println("No se encontró el libro.");
		return null;
		
	}
}

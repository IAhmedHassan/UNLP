/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author pelo
 */
public class Ej03Estantes {
	public static void main(String[] args) {
		Estante e = new Estante();
		
		Libro libro1 = new Libro("El Túnel", "pichocho", new Autor("Ernesto Sábato"), "12345");
		
		Libro libro2 = new Libro("Mujercitas", "pichuchu", new Autor("Juana de Arco"), "11111");
		
		Libro libro3 = new Libro("Harry Potter", "iguana", new Autor("She-Who-Must-Not-Be-Named"),	"2222222");
		
		e.agregarLibro(libro1);
		e.agregarLibro(libro2);
		e.agregarLibro(libro3);
		
		System.out.println(e.devolverLibro("Mujercitas"));
	}
}

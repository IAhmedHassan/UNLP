/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ej01;


/**
 * 
 * @author pelo
 */
public class RepasoEj1 {

	public static void main(String[] args) {
		
		System.out.println("Iniciando...");
		
		Investigador inv1, inv2, inv3;
		Proyecto p;
		
		System.out.println("Creando Investigadores...");
		
		inv1 = new Investigador("Pedro Rosemblat", 1, "carpintero");
		inv2 = new Investigador("Chapulin Colorado", 2, "Héroe");
		inv3 = new Investigador("Leonardo Davinci", 5, "Diseñador");
		
		System.out.println("Solicitando subsidios...");
		
		inv1.solicitarSubsidio(150, "Mesa");
		inv1.solicitarSubsidio(250, "Silla");
		
		inv2.solicitarSubsidio(200, "Salvar al mundo");
		inv2.solicitarSubsidio(300, "Arreglar Martillo");
		
		inv3.solicitarSubsidio(20, "El hombre de vitruvio");
		inv3.solicitarSubsidio(200, "Capilla Sixtina");
		
		System.out.println("Creando proyecto...");

		p = new Proyecto("Comer una pizza", 0, "Pelo Hassan");
		p.agregarInvestigador(inv1);
		p.agregarInvestigador(inv2);
		p.agregarInvestigador(inv3);
		
		System.out.println("Otorgando subsidios...");
		
		p.otorgarTodos("Chapulin Colorado");
		
		System.out.println(p);
		

	}
}

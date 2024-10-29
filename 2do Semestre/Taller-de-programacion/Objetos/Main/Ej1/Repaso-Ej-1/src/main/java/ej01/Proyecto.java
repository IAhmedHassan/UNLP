/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej01;

/**
 *
 * @author pelo
 */
public class Proyecto {
	private String nombre;
	private int codigo;
	private String directorDelProyecto;
	private Investigador[] investigadores;
	private int cantInvestigadores;



	public Proyecto(String nombre, int codigo, String directorDelProyecto) {
		this.setNombre(nombre);
		this.setCodigo(codigo);
		this.setDirectorDelProyecto(directorDelProyecto);
		this.initInvestigadores();
	}

	private void initInvestigadores() {
		investigadores = new Investigador[50];
		for (int i = 0 ; i > 50 ; i++) {
			investigadores[i] = null;
		}
		this.setCantInvestigadores(0);
	}
	
	public void agregarInvestigador(Investigador unInvestigador) {
		int inv = this.getCantInvestigadores();
		investigadores[inv] = unInvestigador;
		this.setCantInvestigadores(inv + 1);
	}
	
	public double dineroTotalOtorgado() {
		double cantTotal = 0;
		for (int i = 0; i < this.getCantInvestigadores() ; i++) {
			cantTotal += this.investigadores[i].informarTotalSubsidiosOtorgados();
		}
		return cantTotal;
	}
	
	public void otorgarTodos(String unNombreDeInvestigador) {
		boolean flag = true;
		int i = 0;
		while (flag) {
			if (this.investigadores[i].getNombre().equals(unNombreDeInvestigador)) {
				this.investigadores[i].otorgarTodos();
				flag = false;
			}
			i++;
		}
	}
	
	private String getNombre() {
		return this.nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private int getCodigo() {
		return this.codigo;
	}

	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	private String getDirectorDelProyecto() {
		return this.directorDelProyecto;
	}

	private void setDirectorDelProyecto(String directorDelProyecto) {
		this.directorDelProyecto = directorDelProyecto;
	}

	private int getCantInvestigadores() {
		return cantInvestigadores;
	}

	private void setCantInvestigadores(int cantInvestigadores) {
		this.cantInvestigadores = cantInvestigadores;
	}	

	@Override
	public String toString() {
		String listaInvestigadores = "";
		for (int i = 0 ; i < this.getCantInvestigadores() ; i++) {
			listaInvestigadores += this.investigadores[i] + "\n";
		}
		
		return "Proyecto: " + this.getNombre() + "\n" +
				"Código: " + this.getCodigo() + "\n" +
				"Director: " + this.getDirectorDelProyecto() + "\n" +
				"Dinero total entregado: $" + String.format("%.2f", this.dineroTotalOtorgado()) + "\n" + "Investigadores: \n" + listaInvestigadores ;
				
				
	}
	
	
	
}

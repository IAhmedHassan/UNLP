/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej01;

/**
 *
 * @author pelo
 */
public class Subsidio {
	private double monto;
	private String motivo;
	private boolean otorgado;
	
	public Subsidio(double unMonto, String unMotivo) {
		this.setMonto(unMonto);
		this.setMotivo(unMotivo);
		this.setOtorgado(false);
	}
	
	public void otorgar() {
		this.setOtorgado(true);
		System.out.println("El subsidio correspondiente a " + this.getMotivo() + " fue otorgado satisfactoriamente.");
	}	

	public double getMonto() {
		return this.monto;
	}

	private void setMonto(double monto) {
		this.monto = monto;
	}

	private String getMotivo() {
		return this.motivo;
	}

	private void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public boolean fueOtorgado() {
		return this.otorgado;
	}
	
	private void setOtorgado(boolean unEstado) {
		this.otorgado = unEstado;
	}
	
	
}

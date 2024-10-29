/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pelo
 */
public class Evento extends Recital{
	private int motivo; //1.beneficencia | 2.show de TV | 3.show privado
	private String contratante;
	private Fecha dia;
	
	// constructor

	public Evento(int motivo, String contratante, Fecha dia, String unNombreBanda, int cantidadDeCanciones) {
		super(unNombreBanda, cantidadDeCanciones);
		this.setMotivo(motivo);
		this.setContratante(contratante);
		this.setDia(dia);
	}
	
	@Override
	public void actuar() {
		String saludo;
		saludo = switch (this.getMotivo()) {
			case 1 -> "Recuerden colaborar con " + this.getContratante();
			case 2 -> "Saludos amigos televidentes!";
			case 3 -> "Un feliz cumpleaños para " + this.getContratante() + "!";
			default -> "";
		};
		System.out.println(saludo);
		super.actuar();
	}

	// getters
	
	private int getMotivo() {
		return this.motivo;
	}

	private String getContratante() {
		return this.contratante;
	}

	private Fecha getdia() {
		return this.dia;
	}
	
	//setters

	private void setMotivo(int motivo) {
		this.motivo = motivo;
	}

	private void setContratante(String contratante) {
		this.contratante = contratante;
	}

	private void setDia(Fecha dia) {
		this.dia = dia;
	}
	
	
}

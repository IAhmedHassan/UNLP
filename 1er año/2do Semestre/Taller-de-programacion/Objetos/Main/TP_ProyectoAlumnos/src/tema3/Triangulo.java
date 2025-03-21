/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author pelo
 */
public class Triangulo {
    private double lado1, lado2, lado3;
    private String relleno = "blanco",
                   linea = "negro";
    
    public Triangulo(double inlado1, double unlado2, double unlado3, String unrelleno,String unalinea) {
        
        lado1 = inlado1;
        lado2 = unlado2;
        lado3 = unlado3;
        relleno = unrelleno;
        linea = unalinea;
    }
    
    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado1(double unlado) {
	lado1 = unlado;
    }

    public void setLado2(double unLado) {
	lado2 = unLado;
    }
    
    public void setLado3 (double unLado) {
	lado3 = unLado;
    }
    
    public void setLinea(String unColor) {
	linea = unColor;
    }
    
    public void setRelleno(String unColor) {
	relleno = unColor;
    }
    
    public double calcularPerimetro() {
	return lado1 + lado2 + lado3;
    }
    
    public double calcularArea() {
	double s = (lado1 + lado2 + lado3) / 2;
	return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
	
    }


    public String toString() {
	return "Triangulo{ " + "lado1=" + lado1 + ", lado2=" + lado2 + ", lado3=" + lado3 + ", relleno=" + relleno + ", linea=" + linea + '}';
    }
    
}

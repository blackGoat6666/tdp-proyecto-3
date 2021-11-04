package personaje;

import java.awt.Point;

import logica.Logica;

public class Personaje {
	//atributos de instancia
	private String miImagen;
	private String conBomba;
	private String Invisibilidad;
	private int tamanioBloqueGrafico;
	private Logica miLogica;
	private Point miPosicion;
	//constructor
	public Personaje(Logica MiLogica, Point posicion) {
		miLogica = MiLogica;
		miPosicion = posicion;
		
	}
	public void moverDerecha() {
		
	}
	public void moverIzquierda() {
		
	}
	public void moverAbajo() {
		
	}
	public void moverArriba() {
		
	}
	public void volverModoNormal() {
		
	}
}

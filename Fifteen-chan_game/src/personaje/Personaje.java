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
		miPosicion.setLocation(miPosicion.getX(),miPosicion.getY()+1);
	}
	public void moverIzquierda() {
		miPosicion.setLocation(miPosicion.getX(),miPosicion.getY()-1);
	}
	public void moverAbajo() {
		miPosicion.setLocation(miPosicion.getX()-1,miPosicion.getY());
	}
	public void moverArriba() {
		miPosicion.setLocation(miPosicion.getX()+1,miPosicion.getY());
	}
	public void volverModoNormal() {
		
	}
	public Point getPosicion() {
		return miPosicion;
	}
}

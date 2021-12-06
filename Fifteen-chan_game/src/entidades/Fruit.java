package entidades;

import java.awt.Point;

import visitor.Visitor;


/**
 * Entidad que representa a una fruta, objeto consumible que aumenta los puntos en una cantidad superior a 
 * los dots.
 * @author Iara
 *
 */

public class Fruit extends EntidadEstatica {
	
	/**
	 * Constructor de las frutas
	 * @param point ubicacion de la fruta
	 * @param imagen imagen que caracteriza a la fruta
	 */
	public Fruit(Point point, EntidadGraficaEstatica imagen) {
		super(imagen);
		ubicacion=point;
		miImagen.setLocation(ubicacion);
	}

	/**
	 * Retorna el valor en puntos de la fruta
	 * @return int puntos
	 */
	public int getPuntaje() {
		return 400;
	}
	
	/**
	 * Un metodo que acepta el visitor (patron de diseño)
	 */
	public void accept(Visitor v) {
		v.visitFruit(this);
		
	}
	
	/**
	 * Retorna la imagen que representa a la fruta
	 * @return EntidadGraficaEstatica imagen
	 */
	public EntidadGraficaEstatica getImagen() {
		return this.miImagen;
	}

	
}

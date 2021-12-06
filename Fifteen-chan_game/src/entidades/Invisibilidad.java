package entidades;

import java.awt.Point;

import visitor.Visitor;

/**
 * Entidad que representa a una potion, objeto consumible que cambia la habilidad del personaje, 
 * haciendolo invisible para los enemigos (no lo matan).
 * @author Iara
 *
 */
public class Invisibilidad  extends EntidadEstatica{

	/**
	 * Constructor de Invisibilidad
	 * @param posicion en x-y del consumible
	 * @param imagen que representa al consumible
	 */
	public Invisibilidad(Point posicion,EntidadGraficaEstatica imagen) {
		super(imagen);
		ubicacion=posicion;
		imagen.setLocation(posicion);
	}

	
	/**
	 * Un metodo que acepta el visitor (patron de diseño)
	 */
	public void accept(Visitor v) {
		v.visitInvisibilidad(this);
	}

}

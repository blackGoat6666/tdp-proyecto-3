package entidades;

import java.awt.Point;

import visitor.Visitor;

/**
 * Las entidades son clases abstractas utilizadas para generalizar el comportamiento de aquellas clases de nuestro
 * juego que tienen en comun una posicion y relacionarse con el visitor
 * @author Iara
 *
 */
public abstract class Entidad {
	protected  Point ubicacion;
	
	/**
	 * retorna la posicion de la entidad.
	 * @return Point ubicacion
	 */
	public Point getPosicion() {
		return ubicacion;
	}

	/**
	 * Un metodo que acepta el visitor (patron de diseño)
	 */
	public abstract void accept(Visitor v);
	
	/**
	 * elimina la entidad
	 */
	public abstract void morir();
	
}

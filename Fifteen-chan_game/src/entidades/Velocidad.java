package entidades;

import java.awt.Point;

import visitor.Visitor;

/**
 * Un tipo de consumible potion que le da mas velocidad al personaje.
 * @author Iara
 *
 */
public class Velocidad extends Potion{

	/**
	 * Constructor
	 * @param point representa la ubicacion de la entidad velocidad
	 * @param imagen representa graficamente a la entidad.
	 */
	public Velocidad(Point point, EntidadGraficaEstatica imagen) {
		super(imagen);
		ubicacion=point;
		imagen.setLocation(point);
	}

	/**
	 * Un metodo que acepta el visitor (patron de diseño)
	 */
	public void accept(Visitor v) {
		v.visitVelocidad(this);
	}

}

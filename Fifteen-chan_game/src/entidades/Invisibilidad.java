package entidades;

import java.awt.Point;

import visitor.Visitor;

public class Invisibilidad  extends EntidadEstatica{

	public Invisibilidad(Point posicion,EntidadGraficaEstatica imagen) {
		super(imagen);
		ubicacion=posicion;
		imagen.setLocation(posicion);
	}

	public void accept(Visitor v) {
		v.visitInvisibilidad(this);
	}

}

package entidades;

import java.awt.Point;

import visitor.Visitor;

public class Velocidad extends Potion{

	public Velocidad(Point point, EntidadGraficaEstatica imagen) {
		super(imagen);
		ubicacion=point;
		imagen.setLocation(point);
	}


	@Override
	public String toString() {
		return ("my name is barry allen... and i am the fastest man alive");
	}

	
	public void accept(Visitor v) {
		v.visitVelocidad(this);
	}

}

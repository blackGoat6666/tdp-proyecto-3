package entidades;

import java.awt.Point;

import visitor.Visitor;

public class Dot extends MasPuntos {
	int puntaje;
	
	public Dot(Point posicion, EntidadGraficaEstatica imagen) {
		super(imagen);
		puntaje=10;
		ubicacion=posicion;
		imagen.setLocation(posicion);
		
	}
	public int getPuntaje() {
		return puntaje;
	}
	
	public void accept(Visitor v) {
		v.visitDot(this);
	}

}

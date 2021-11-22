package entidades;

import java.awt.Point;

import visitor.Visitor;

public class PowerPellet extends EntidadEstatica {

	public PowerPellet(Point posicion, EntidadGraficaEstatica imagen){
		super(imagen);
		ubicacion=posicion;
		imagen.setLocation(posicion);
	}
	
	public String toString() {
		return ("esto es un pellet");
	}

	public void accept(Visitor v) {
		v.visitPowerPellet(this);
	}
	public int getPuntaje() {
		return 100;
	}

}

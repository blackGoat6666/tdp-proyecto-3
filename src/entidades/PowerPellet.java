package entidades;

import java.awt.Point;

import visitor.Visitor;

public class PowerPellet extends MasHabilidad {

	public PowerPellet(Point ub, EntidadGraficaEstatica imagen){
		super(imagen);
		ubicacion=ub;
	}
	
	@Override
	public String toString() {
		return ("esto es un pellet");
	}

	@Override
	public void accept(Visitor v) {
	}

}

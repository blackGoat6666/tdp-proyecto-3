package entidades;

import java.awt.Point;

import visitor.Visitor;

public class PowerPellet extends MasHabilidad {

	public PowerPellet(Point ub, EntidadGraficaEstatica imagen){
		ubicacion=ub;
		miImagen= imagen;
	}
	
	@Override
	public String toString() {
		return ("esto es un pellet");
	}

	@Override
	public void accept(Visitor v) {
	}
	public EntidadGrafica getEntidadGrafica() {
		return imagen;
	}
}

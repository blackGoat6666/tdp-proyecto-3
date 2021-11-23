package entidades;

import java.awt.Point;

import visitor.Visitor;

public class Fruit extends EntidadEstatica {
	public Fruit(Point point, EntidadGraficaEstatica imagen) {
		super(imagen);
		ubicacion=point;
		miImagen.setLocation(ubicacion);
	}

	public int getPuntaje() {
		return 400;
	}
	
	public void accept(Visitor v) {
		v.visitFruit(this);
		
	}
	
	public EntidadGraficaEstatica getImagen() {
		return this.miImagen;
	}

	
}

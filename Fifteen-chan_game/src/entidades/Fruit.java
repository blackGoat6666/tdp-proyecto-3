package entidades;

import visitor.Visitor;

public class Fruit extends MasPuntos {
	public Fruit(EntidadGraficaEstatica imagen) {
		super(imagen);
	}

	int puntaje;
	public int getPuntaje() {
		return puntaje;
	}
	
	public void accept(Visitor v) {
		v.visitFruit(this);
		
	}

	
}

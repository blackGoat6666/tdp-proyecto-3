package entidades;

import visitor.Visitor;

public class Ladrillo extends EntidadEstatica{

	public Ladrillo() {
		
	}
	
	public void accept(Visitor v) {
		v.visitLadrillo();
	}
	public EntidadGrafica getEntidadGrafica() {
		return imagen;
	}
}

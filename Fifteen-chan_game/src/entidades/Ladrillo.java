package entidades;

import visitor.Visitor;

public class Ladrillo extends EntidadEstatica{

	public Ladrillo(EntidadGraficaEstatica imagen) {
		super(imagen);
	}
	
	public void accept(Visitor v) {
		v.visitLadrillo();
	}

}

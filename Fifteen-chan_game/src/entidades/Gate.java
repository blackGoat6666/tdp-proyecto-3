package entidades;

import visitor.Visitor;

public class Gate extends EntidadEstatica{

	public Gate(EntidadGraficaEstatica imagen) {
		super(imagen);
	}
	@Override
	public void accept(Visitor v) {
		v.visitGate();
	}

}

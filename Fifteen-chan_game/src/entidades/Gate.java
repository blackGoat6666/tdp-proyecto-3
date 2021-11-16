package entidades;

import visitor.Visitor;

public class Gate extends EntidadEstatica{

	public Gate() {
		
	}
	@Override
	public void accept(Visitor v) {
		v.visitGate();
	}

}

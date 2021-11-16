package entidades;

import visitor.Visitor;

public class PowerPellet extends MasHabilidad {

	@Override
	public String toString() {
		return ("esto es un pellet");
	}

	@Override
	public void accept(Visitor v) {
	}

}

package entidades;

import visitor.Visitor;

public class Velocidad extends Potion{

	@Override
	public String toString() {
		return ("my name is barry allen... and i am the fastest man alive");
	}

	@Override
	public void accept(Visitor v) {
		v.visitVelocidad();
		
	}

}

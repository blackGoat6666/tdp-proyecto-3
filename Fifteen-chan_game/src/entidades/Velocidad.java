package entidades;

import visitor.Visitor;

public class Velocidad extends Potion{

	public Velocidad(EntidadGraficaEstatica imagen) {
		super(imagen);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return ("my name is barry allen... and i am the fastest man alive");
	}

	
	public void accept(Visitor v) {
		
		
	}

	
	public void morir() {
		// TODO Auto-generated method stub
		
	}
}

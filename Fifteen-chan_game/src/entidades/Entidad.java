package entidades;

import java.awt.Point;

import visitor.Visitor;

public abstract class Entidad {
	protected  Point ubicacion;
	protected EntidadGrafica imagen;
	public Entidad() {
		this.ubicacion= new Point(0,0);
	}
	
	public Point getPosicion() {
		return ubicacion;
	}

	public abstract void accept(Visitor v);
	
	public abstract EntidadGrafica getEntidadGrafica();

	public abstract void morir();
	
}

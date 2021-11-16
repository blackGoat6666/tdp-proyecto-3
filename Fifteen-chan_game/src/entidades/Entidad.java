<<<<<<< Updated upstream
package entidades;

import java.awt.Point;

import visitor.Visitor;

public abstract class Entidad {
	protected  Point ubicacion;
	protected EntidadGrafica imagen;
	public Point getPosicion() {
		return ubicacion;
	}

	public abstract void accept(Visitor v);

}
=======
package entidades;

import java.awt.Point;

import visitor.Visitor;

public abstract class Entidad {
	protected  Point ubicacion;
	protected EntidadGrafica imagen;
	public Point getPosicion() {
		return ubicacion;
	}

	public abstract void accept(Visitor v);

	public abstract void morir();
	
}
>>>>>>> Stashed changes

package entidades;

import java.awt.Point;

import visitor.Visitor;

public abstract class Entidad {
protected  Point ubicacion;

public Point getPosicion() {
	return ubicacion;
}

public abstract void accept(Visitor v);

}

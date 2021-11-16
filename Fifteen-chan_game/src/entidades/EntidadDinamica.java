package entidades;

import java.awt.Point;

import visitor.Visitor;

public abstract class EntidadDinamica extends Entidad {

public abstract void resetear();

public abstract void mover();

public abstract void morir();

public void acceptVisitor(Visitor v){
	
}
	
}

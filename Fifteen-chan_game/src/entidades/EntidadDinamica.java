package entidades;


import visitor.Visitor;

public abstract class EntidadDinamica extends Entidad {
protected EntidadGraficaDinamica miImagen;
	
	
public abstract void resetear();

public abstract void mover();

public abstract void morir();

public void acceptVisitor(Visitor v){
	
}
	
}

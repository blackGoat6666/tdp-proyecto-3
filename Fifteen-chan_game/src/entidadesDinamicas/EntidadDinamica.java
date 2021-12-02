package entidadesDinamicas;


import entidades.Entidad;
import visitor.Visitor;

public abstract class EntidadDinamica extends Entidad {
protected EntidadGraficaDinamica miImagen;
protected Visitor miVisitor;

	
	public EntidadDinamica(EntidadGraficaDinamica fotito) {
		miImagen=fotito;
	}
	
	public abstract void resetear();

	public abstract void mover();


	public abstract String toString(); 

	public void accept(Visitor v) {
	}
	public void morir() {
	}
	public Visitor getVisitor() {
		return this.miVisitor;
	}
	
}

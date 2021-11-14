package entidades;

import java.awt.Point;

import visitor.Visitor;

public abstract class Enemigo extends EntidadDinamica {
    
	protected Point preferencias;
	protected Point posicionObjetivo;
	protected Point ultimaDireccion;
	protected int intentos;
	protected int tamanioBloqueGrafico;
	
	public Enemigo(int tamanioBloque) {
		this.tamanioBloqueGrafico=tamanioBloque;
		intentos=0;
		ultimaDireccion= new Point(0,0);
		preferencias= new Point(0,0);
	}

	public Boolean colisiona(Point ubicacion) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void resetear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	public abstract void calcularDir(Point Pacman);
}

package entidades;

import java.awt.Point;

import visitor.Visitor;
import visitor.VisitorPacman;

public class Personaje extends EntidadDinamica {
	//constructor
	public Personaje() {
		ubicacion.setLocation(308, 369);
	}
	
	public void moverDerecha() {
		int movimiento =4;
		Point posicion= this.getPosicion();
		int ubicacion = posicion.x + movimiento;
		posicion.setLocation(ubicacion, posicion.y);
	}
	public void moverIzquierda() {
		int movimiento =4;
		Point posicion= this.getPosicion();			
		int ubicacion = posicion.x - movimiento;
		posicion.setLocation(ubicacion, posicion.y);
	}
	
	public void moverAbajo() {
		int movimiento =4;
		Point posicion= this.getPosicion();
		int ubicacion = posicion.y + movimiento;
		posicion.setLocation(posicion.x, ubicacion);
	}
	public void moverArriba() {
		int movimiento =4;
		Point posicion= this.getPosicion();
		int ubicacion = posicion.y - movimiento;
		posicion.setLocation(posicion.x, ubicacion);
	}
	
	
	public void resetear() {
		ubicacion.setLocation(308, 369);
		
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
		
		
	}
	
}

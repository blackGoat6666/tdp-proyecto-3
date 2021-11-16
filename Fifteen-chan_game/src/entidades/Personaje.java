package entidades;

import java.awt.Point;

import logica.Logica;
import visitor.Visitor;
import visitor.VisitorPacman;

public class Personaje extends EntidadDinamica {
	private Logica miLogica;
	private Boolean meMuevo;
	private int movimiento;
	private Point dir;
	
	//constructor
	public Personaje(Logica miLog) {
		miLogica=miLog;
		ubicacion.setLocation(300, 345);
		meMuevo=false;
		movimiento=4;
	}
	
	public void setMovimiento(int mov) {
		this.movimiento=mov;
	}
	
	public void setMeMuevo(Boolean estado) {
		this.meMuevo=estado;
	}
	public void setDireccion(Point dire) {
		this.dir=dire;
	}
	
	public void mover() {
		if(miLogica.estoyAMitadBloque(ubicacion)){ 
			Point vectorMovimiento;
			vectorMovimiento= new Point( (dir.x*30)+ ubicacion.x ,(dir.y*30)+ ubicacion.y);
		    miLogica.visitarBloque(this, vectorMovimiento);
			if(meMuevo) {
				this.moverPosicion(dir);
			}
		}
		else {
			this.moverPosicion(dir);
		}
		
	}
	
	private void moverPosicion(Point dir) {
		switch(dir.x) {
		case 1: this.moverDerecha();
				break;
		case -1: this.moverIzquierda();
				break;
		case 0: if(dir.y==1) {
					this.moverAbajo();
				}
				else {
					this.moverArriba();
				}
	}
	}
	
	private void moverDerecha() {
		Point posicion= this.getPosicion();
		int ubicacion = posicion.x + movimiento;
		posicion.setLocation(ubicacion, posicion.y);
	}
	private void moverIzquierda() {
		Point posicion= this.getPosicion();			
		int ubicacion = posicion.x - movimiento;
		posicion.setLocation(ubicacion, posicion.y);
	}
	
	private void moverAbajo() {
		Point posicion= this.getPosicion();
		int ubicacion = posicion.y + movimiento;
		posicion.setLocation(posicion.x, ubicacion);
	}
	private void moverArriba() {
		Point posicion= this.getPosicion();
		int ubicacion = posicion.y - movimiento;
		posicion.setLocation(posicion.x, ubicacion);
	}
	public Boolean colisiona(Point ubicacion) {
		
		return null;
	}

	
	public void resetear() {
		
		
	}


	@Override
	public void morir() {
		// TODO Auto-generated method stub
	}

	@Override
	public void accept(Visitor v) {
	}


	
}


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
	public Personaje(Logica miLog, EntidadGraficaDinamica imagen) {
		super(imagen);
		ubicacion= new Point((320), (360));
		miLogica=miLog;
		meMuevo=false;
		movimiento=5;
		miImagen.setLocation(ubicacion.x, ubicacion.y-30);
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
		Point vectorMovimiento;
		vectorMovimiento= new Point( (dir.x*30)+ ubicacion.x ,(dir.y*30)+ ubicacion.y);
		System.out.println("x "+ vectorMovimiento.x+" y "+vectorMovimiento.y);
		if( (vectorMovimiento.x>=0) && (vectorMovimiento.y>=0) && (vectorMovimiento.x<=21*30)&& (vectorMovimiento.y<=21*30)) {
			miLogica.visitarBloque(this, vectorMovimiento);
			if(meMuevo) {
				this.moverPosicion(dir);
			}
			meMuevo=false;
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
		miImagen.setLocation(ubicacion, posicion.y-30);
	}
	private void moverIzquierda() {
		Point posicion= this.getPosicion();			
		int ubicacion = posicion.x - movimiento;
		posicion.setLocation(ubicacion, posicion.y);
		miImagen.setLocation(ubicacion, posicion.y-30);
	}
	
	private void moverAbajo() {
		Point posicion= this.getPosicion();
		int ubicacion = posicion.y + movimiento;
		posicion.setLocation(posicion.x, ubicacion);
		miImagen.setLocation(posicion.x, ubicacion-30);
	}
	private void moverArriba() {
		Point posicion= this.getPosicion();
		int ubicacion = posicion.y - movimiento;
		posicion.setLocation(posicion.x, ubicacion);
		miImagen.setLocation(posicion.x,ubicacion-30);
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

	public EntidadGrafica getEntidadGrafica() {
		// TODO Auto-generated method stub
		return miImagen;
	}
	
	public String toString() {
		return "Personaje";
	}


	
}


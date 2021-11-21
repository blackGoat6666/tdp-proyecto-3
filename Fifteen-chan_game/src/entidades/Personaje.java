package entidades;

import java.awt.Point;

import logica.Logica;
import visitor.Visitor;

public class Personaje extends EntidadDinamica {
	private Logica miLogica;
	private Boolean meMuevo;
	private int movimiento;
	private Point dir;
	private int acomodarIzquierda;
	
	//constructor
	public Personaje(Logica miLog, EntidadGraficaDinamica imagen) {
		super(imagen);
		ubicacion= new Point((315), (375));
		miLogica=miLog;
		meMuevo=false;
		movimiento=4;
		miImagen.setLocation(ubicacion.x-17, ubicacion.y-50);
		acomodarIzquierda=0;
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
		if( (vectorMovimiento.x>0) && (vectorMovimiento.y>0) && (vectorMovimiento.x<=21*30)&& (vectorMovimiento.y<=21*30)) {
			if(vectorMovimiento.x==-1) {
				vectorMovimiento.setLocation(vectorMovimiento.x,vectorMovimiento.y);
			}
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
		ubicacion.setLocation(this.getPosicion().x+movimiento, this.getPosicion().y);
		miImagen.setDerecha();
		if(acomodarIzquierda>0) {
			miImagen.setLocation(miImagen.getLocation().x+movimiento+5, miImagen.getLocation().y);
			acomodarIzquierda--;
		}else {
			miImagen.setLocation(miImagen.getLocation().x+movimiento, miImagen.getLocation().y);
		}
	}
	private void moverIzquierda() {
		miImagen.setIzquierda();
		ubicacion.setLocation(this.getPosicion().x-movimiento, this.getPosicion().y);
		if(acomodarIzquierda<=3) {
			miImagen.setLocation(miImagen.getLocation().x-movimiento-5, miImagen.getLocation().y);
			acomodarIzquierda++;
		}
		else {
			miImagen.setLocation(miImagen.getLocation().x-movimiento, miImagen.getLocation().y);
		}
	}
	
	private void moverAbajo() {
		miImagen.setAdelante();
		ubicacion.setLocation(this.getPosicion().x, this.getPosicion().y+movimiento);
		miImagen.setLocation(miImagen.getLocation().x, miImagen.getLocation().y+movimiento);
	}
	
	private void moverArriba() {
		miImagen.setAtras();
		ubicacion.setLocation(this.getPosicion().x, this.getPosicion().y-movimiento);
		miImagen.setLocation(miImagen.getLocation().x, miImagen.getLocation().y-movimiento);
	}
	
	
	public Boolean colisiona(Point ubicacion) {
		
		return null;
	}

	
	public void resetear() {
		ubicacion= new Point((315), (375));
		miImagen.setLocation(ubicacion.x-15, ubicacion.y-50);
		acomodarIzquierda=0;
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

	public Point getDireccion() {
		return this.dir;
	}


	
}


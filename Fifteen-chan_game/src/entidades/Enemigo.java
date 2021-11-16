package entidades;

import java.awt.Point;

import logica.MenteEnemiga;
import visitor.Visitor;

public abstract class Enemigo extends EntidadDinamica {
    
	protected Point preferencias;
	protected Point posicionObjetivo;
	protected Point ultimaDireccion;
	protected int intentos;
	protected MenteEnemiga miMente;
	protected int movimiento;
	protected Boolean meMovi;
	
	public Enemigo(int mov, EntidadGraficaDinamica imagen) {
		movimiento=mov;
		intentos=0;
		ultimaDireccion= new Point(0,0);
		preferencias= new Point(0,0);
		meMovi=false;
		miImagen=imagen;
	}


	
	public abstract void resetear();



	@Override
	public void mover() {
		if(miMente.estoyAMitadBloque(ubicacion)) { 
		  Point vectorMovimiento;
		  while(!meMovi) {
			vectorMovimiento= this.siguienteDireccion();
			vectorMovimiento= new Point( (vectorMovimiento.x*30)+ ubicacion.x ,(vectorMovimiento.y*30)+ ubicacion.y);
		    miMente.chequearBloque(this, vectorMovimiento);
		    intentos++;
		  }
		  intentos--;
		  vectorMovimiento=this.siguienteDireccion();
		  this.actualizarMiEntidadGrafica();
		  vectorMovimiento.setLocation(vectorMovimiento.x*movimiento, vectorMovimiento.y*movimiento);
		  ubicacion.setLocation(ubicacion.x+vectorMovimiento.x, ubicacion.y+vectorMovimiento.y);
		  intentos=0;
		}
		else{
			
			ubicacion.setLocation(ubicacion.x+(ultimaDireccion.x *movimiento), ubicacion.y+(ultimaDireccion.y * movimiento));
			this.actualizarMiEntidadGrafica();
		}
		
	}
	
	public void seMovio() {
		meMovi=true;
	}

	@Override
	public void morir() {
		miImagen.setModo("invisibilidad");
	}
	protected void actualizarMiEntidadGrafica() {
		if(this.siguienteDireccion().x==0) {
			if(this.siguienteDireccion().y==1) {
				miImagen.setDerecha();
			}
			else {
				miImagen.setIzquierda();
			}
		}
		else {
			if(this.siguienteDireccion().x==1) {
				miImagen.setAdelante();
			}
			else {
				miImagen.setAtras();
			}
		}
		
	}
	
	
	protected Point siguienteDireccion() {
		switch(intentos) {
			case 0: if(ultimaDireccion.x==0) {
						return new Point(preferencias.x, 0);
					}
					else {
						return new Point(0, preferencias.y);
					}
			case 1: return ultimaDireccion;
			case 2: if(ultimaDireccion.x==0) {
						return new Point(0, -(preferencias.y));
					}
					else {
						return new Point(-(preferencias.x), 0);
					}
			 
		}
		return null;
		
	}
	
	public Point getUbicacion() {
		return ubicacion;
	}
	public void accept(Visitor v) {
	}

	public abstract void calcularDir(Point Pacman);
}

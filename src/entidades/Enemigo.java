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
	protected Point ubicacion;
	
	public Enemigo(int mov, EntidadGraficaDinamica imagen, MenteEnemiga megamind) {
		super(imagen);
		movimiento=mov;
		intentos=0;
		ultimaDireccion= new Point(0,0);
		preferencias= new Point(0,0);
		meMovi=false;
		miMente=megamind;
		ubicacion= new Point(0,0);
		posicionObjetivo= new Point(0,0);
	}


	
	public abstract void resetear();



	@Override
	public void mover() {
		  
		  Point vectorMovimiento;
		  while(!meMovi && intentos<=2) {
			vectorMovimiento= this.siguienteDireccion();
			System.out.println("vector movimiento x "+vectorMovimiento.x+" y: "+vectorMovimiento.y);
			vectorMovimiento= new Point( ((vectorMovimiento.x)*30)+ ubicacion.x ,(vectorMovimiento.y*30)+ ubicacion.y);
			System.out.println("vector movimiento x "+vectorMovimiento.x+" y: "+vectorMovimiento.y);
		    if((vectorMovimiento.x>=31) && (vectorMovimiento.y>=31) && (vectorMovimiento.x<=22*30)&& (vectorMovimiento.y<=22*30)) {
		    	miMente.chequearBloque(this, vectorMovimiento);
			}
		    intentos++;
		  }
		  intentos--;
		  vectorMovimiento=this.siguienteDireccion();
		  ultimaDireccion.setLocation(vectorMovimiento);
		  this.actualizarMiEntidadGrafica();
		  vectorMovimiento.setLocation(vectorMovimiento.x*movimiento, vectorMovimiento.y*movimiento);
		  ubicacion.setLocation(ubicacion.x+vectorMovimiento.x, ubicacion.y+vectorMovimiento.y);
		  miImagen.setLocation(ubicacion);
		  meMovi=false;
		  intentos=0;
		
		
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
			case 2: if(ultimaDireccion.y==0) {
						return new Point(0, -(preferencias.y));
					}
					else {
						return new Point(-(preferencias.x), 0);
					}
			 
		}
		return new Point(0,0);
		
	}
	
	public Point getUbicacion() {
		return ubicacion;
	}
	public void accept(Visitor v) {
	}

	public abstract void calcularDir(Point Pacman);
	
	public String toString() {
		return "Enemigo";
	}
	public void setNoSeMovio() {
		meMovi=false;
	}
}

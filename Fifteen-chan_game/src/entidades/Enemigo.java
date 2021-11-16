package entidades;

import java.awt.Point;

import logica.MenteEnemiga;
import visitor.Visitor;
import visitor.VisitorFantasma;
import visitor.VisitorPacman;

public abstract class Enemigo extends EntidadDinamica {
    
	protected Point preferencias;
	protected Point posicionObjetivo;
	protected Point ultimaDireccion;
	protected int intentos;
	protected MenteEnemiga miMente;
	protected int movimiento;
	protected Boolean meMovi;
	
	public Enemigo(int mov) {
		movimiento=mov;
		intentos=0;
		ultimaDireccion= new Point(0,0);
		preferencias= new Point(0,0);
		meMovi=false;
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
		if(miMente.estoyAMitadBloque(ubicacion)) { 
		  int cambios=intentos;
		  Point movimiento;
		  while(!meMovi) {
			movimiento= this.siguienteDireccion();
			movimiento= new Point( (movimiento.x*30)+ ubicacion.x ,(movimiento.y*30)+ ubicacion.y);
		    miMente.chequearBloque(this, movimiento);
		  }
		  movimiento=this.siguienteDireccion();
		  ubicacion.setLocation(ubicacion.x+movimiento.x, ubicacion.y+movimiento.y);
		  intentos=0;
		}
		else{
			ubicacion.setLocation(ubicacion.x+ultimaDireccion.x, ubicacion.y+ultimaDireccion.y);
		}
		
	}
	
	public void seMovio() {
		meMovi=true;
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
	  v.visitFantasma(this);
		
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

	public abstract void calcularDir(Point Pacman);
}

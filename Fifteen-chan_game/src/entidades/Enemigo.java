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
	
	public Enemigo(int mov) {
		movimiento=mov;
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
		if(miMente.estoyAMitadBloque(ubicacion)) { 
		  	
		}
		
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
	  v.visitFantasma();
		
	}
	

	public abstract void calcularDir(Point Pacman);
}

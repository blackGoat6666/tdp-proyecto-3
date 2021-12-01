package state;

import java.awt.Point;

public interface StateFantasma { 
	
	public abstract void calcularDir(Point Pacman);
	public abstract void mover();
	public abstract void morir();
	public abstract void huir();
	public abstract Boolean puedeAtravesarGate();
	public abstract Boolean getMuerto();
	public abstract void modoNormal();
	public abstract void resetear();
	public int getIntentos();
}

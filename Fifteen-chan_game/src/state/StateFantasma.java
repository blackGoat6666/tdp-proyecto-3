package state;

import java.awt.Point;

public interface StateFantasma { 
	
	public abstract void calcularDir(Point Pacman);
	public abstract void mover();
	public abstract Boolean puedeAtravesarGate();
	public abstract Boolean getMuerto();
	public abstract int getIntentos();
}

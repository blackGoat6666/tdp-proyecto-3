package fabricas;

import entidades.EntidadGraficaDinamica;
import entidades.EntidadGraficaEstatica;

public abstract interface FabricaEntidades {
	public abstract EntidadGraficaDinamica getBlinky();
	public abstract EntidadGraficaDinamica getInky();
	public abstract EntidadGraficaDinamica getPinky();
	public abstract EntidadGraficaDinamica getClyde();
	public abstract EntidadGraficaDinamica getPersonaje();
	public abstract EntidadGraficaEstatica getDot();
	public abstract EntidadGraficaEstatica getPowerPellet();
	public abstract EntidadGraficaEstatica getFruit1();
	public abstract EntidadGraficaEstatica getFruit2();
	public abstract EntidadGraficaEstatica getFruit3();
	public abstract EntidadGraficaEstatica getBomba();
	public abstract EntidadGraficaEstatica getInvisibilidad();
	public abstract EntidadGraficaEstatica getVelocidad();
	
}

package fabricas;

import EntidadesGraficas.EntidadDinamicaGrafica;
import EntidadesGraficas.EntidadGraficaConsumible;

public abstract interface FabricaEntidades {
	public abstract EntidadDinamicaGrafica getBlinky();
	public abstract EntidadDinamicaGrafica getInky();
	public abstract EntidadDinamicaGrafica getPinky();
	public abstract EntidadDinamicaGrafica getClyde();
	public abstract EntidadDinamicaGrafica getPersonaje();
	public abstract EntidadGraficaConsumible getDot();
	public abstract EntidadGraficaConsumible getPowerPellet();
	public abstract EntidadGraficaConsumible getFruit1();
	public abstract EntidadGraficaConsumible getFruit2();
	public abstract EntidadGraficaConsumible getFruit3();
	public abstract EntidadGraficaConsumible getBomba();
	public abstract EntidadGraficaConsumible getInvisibilidad();
	public abstract EntidadGraficaConsumible getVelocidad();
	
}

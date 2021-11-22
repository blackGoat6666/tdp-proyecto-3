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
	public abstract EntidadGraficaEstatica getFruit(int nivel);
	public abstract EntidadGraficaEstatica getBomba();
	public abstract EntidadGraficaEstatica getInvisibilidad();
	public abstract EntidadGraficaEstatica getVelocidad();
	public abstract String getVida();
	public abstract String getVidaMuerta();
	public abstract String getMusica(int nivel);
	public abstract String getFondo(int nivel);
}

package fabricas;

import java.awt.Point;

import entidades.EntidadEstatica;
import entidadesDinamicas.Enemigo;
import entidadesDinamicas.Personaje;
import logica.LogicaColisiones;

public abstract interface FabricaEntidades {
	public abstract Enemigo getBlinky();
	public abstract Enemigo getInky();
	public abstract Enemigo getPinky();
	public abstract Enemigo getClyde();
	public abstract Personaje getPersonaje(LogicaColisiones log);
	public abstract EntidadEstatica getDot(Point ubicacion);
	public abstract EntidadEstatica getPowerPellet(Point ubicacion);
	public abstract EntidadEstatica getFruit(Point ubicacion,int nivel);
	public abstract EntidadEstatica getBomba(Point ubicacion);
	public abstract EntidadEstatica getInvisibilidad(Point ubicacion);
	public abstract EntidadEstatica getVelocidad(Point ubicacion);
	public abstract String getVida();
	public abstract String getVidaMuerta();
	public abstract String getMusica(int nivel);
	public abstract String getFondo(int nivel);
}

package fabricas;

import java.awt.Point;

import entidades.EntidadEstatica;
import entidadesDinamicas.Enemigo;
import entidadesDinamicas.Personaje;
import logica.LogicaColisiones;

/**
 * Esta interfaz es porque implementamos el patron de diseño fabrica abstracta
 * @author Iara
 *
 */
public abstract interface FabricaEntidades {
	//aca tenemos metodos para cada entidad que necesitamos en el juego
	/**
	 * retorna a Blinky
	 * @return Enemigo
	 */
	public abstract Enemigo getBlinky();
	/**
	 * retorna a Inky
	 * @return Enemigo
	 */
	public abstract Enemigo getInky();
	/**
	 * retorna a Pinky
	 * @return Enemigo
	 */
	public abstract Enemigo getPinky();
	/**
	 * retorna a Clyde
	 * @return Enemigo
	 */
	public abstract Enemigo getClyde();
	/**
	 * retorna al Personaje
	 * @return Personaje
	 */
	public abstract Personaje getPersonaje(LogicaColisiones log);
	/**
	 * retorna dot
	 * @return EntidadEstatica
	 */
	public abstract EntidadEstatica getDot(Point ubicacion);
	/**
	 * retorna powerPellet
	 * @return EntidadEstatica
	 */
	public abstract EntidadEstatica getPowerPellet(Point ubicacion);
	/**
	 * retorna fruit
	 * @return EntidadEstatica
	 */
	public abstract EntidadEstatica getFruit(Point ubicacion,int nivel);
	/**
	 * retorna bomba
	 * @return EntidadEstatica
	 */
	public abstract EntidadEstatica getBomba(Point ubicacion);
	/**
	 * retorna invisibilidad
	 * @return EntidadEstatica
	 */
	public abstract EntidadEstatica getInvisibilidad(Point ubicacion);
	/**
	 * retorna velocidad
	 * @return EntidadEstatica
	 */
	public abstract EntidadEstatica getVelocidad(Point ubicacion);
	/**
	 * retorna a Blinky
	 * @return Enemigo
	 */
	public abstract String getVida();
	public abstract String getVidaMuerta();
	public abstract String getMusica(int nivel);
	public abstract String getFondo(int nivel);
}

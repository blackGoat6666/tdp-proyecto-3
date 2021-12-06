package entidades;

import java.awt.Point;

import visitor.Visitor;

/**
 * Entidad que representa a un power pellet, objeto consumible que hace que el personaje sea capaz de
 * capturar a los enemigos durante algunos segundos.
 * @author Iara
 *
 */
public class PowerPellet extends EntidadEstatica {

	/**
	 * Constructor de los power pellets.
	 * @param posicion representa la ubicacion espacial del power pellet.
	 * @param imagen representa graficamente al power pellet.
	 */
	public PowerPellet(Point posicion, EntidadGraficaEstatica imagen){
		super(imagen);
		ubicacion=posicion;
		imagen.setLocation(posicion);
	}
	
	

	/**
	 * Un metodo que acepta el visitor (patron de diseño)
	 */
	public void accept(Visitor v) {
		v.visitPowerPellet(this);
	}
	
	/**
	 * Retorna el valor en puntos de la fruta
	 * @return int puntos
	 */
	public int getPuntaje() {
		return 100;
	}

}

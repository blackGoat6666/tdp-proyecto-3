package entidades;

import java.awt.Point;

import visitor.Visitor;

/**
 * Clase que representa un tipo de consumible que aumenta los puntos.
 * @author Iara
 *
 */
public class Dot extends EntidadEstatica {
	int puntaje;
	
	/**
	 * constructor
	 * @param posicion coordenadas en xy de la entidad
	 * @param imagen representacion grafica del dot
	 */
	public Dot(Point posicion, EntidadGraficaEstatica imagen) {
		super(imagen);
		puntaje=10;
		ubicacion=posicion;
		imagen.setLocation(posicion);
		
	}
	
	/**
	 * Metodo que retorna el puntaje que da cada dot
	 * @return int puntos
	 */
	public int getPuntaje() {
		return puntaje;
	}
	
	/**
	 * Un metodo que acepta el visitor (patron de diseño)
	 */
	public void accept(Visitor v) {
		v.visitDot(this);
	}

}

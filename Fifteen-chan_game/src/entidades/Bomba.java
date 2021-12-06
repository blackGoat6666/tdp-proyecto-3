package entidades;
import java.awt.Point;
import visitor.Visitor;

/**
 * Un consumible tipo Potion, que da la capacidad de que el personaje ponga una bomba.
 * @author Iara
 *
 */
public class Bomba extends Potion{
	
	/**
	 * Constructor de la bomba.
	 * @param posicion ubicacion de la bomba, Point
	 * @param imagen representa a la bomba de forma grafica.
	 */
	public Bomba(Point posicion, EntidadGraficaEstatica imagen) {
		super(imagen);
		ubicacion=posicion;
		imagen.setLocation(posicion);
		
	}
	
	/**
	 * Un metodo que acepta el visitor (patron de diseño)
	 */
	public void accept(Visitor v) {
		v.visitBomba(this);
	}
	
	
}
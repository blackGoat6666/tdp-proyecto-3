package entidades;
import java.awt.Point;
import visitor.Visitor;
public class Bomba extends Potion{
	
	public Bomba(Point posicion, EntidadGraficaEstatica imagen) {
		super(imagen);
		ubicacion=posicion;
		imagen.setLocation(posicion);
		
	}
	public void accept(Visitor v) {
		v.visitBomba(this);
	}
}
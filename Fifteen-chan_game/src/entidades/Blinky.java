package entidades;

import java.awt.Point;

import logica.MenteEnemiga;
import state.NormalState;
import visitor.Visitor;


public class Blinky extends Enemigo {

	public Blinky(int mov, EntidadGraficaDinamica grafico, MenteEnemiga megamind) {
		super(mov,grafico, megamind);
		ubicacion.setLocation(310,300);
		miImagen.setLocation(ubicacion.x-30, ubicacion.y-50);
		this.miEstado = new NormalState(this);
	}

	public void calcularDirNormal(Point Pacman) {
		this.calcularDirDirecta(Pacman);
	}
	
	public void resetear() {
		ubicacion.setLocation(310,310);
		this.resetearGeneral();
	}

}

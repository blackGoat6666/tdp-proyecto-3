package entidadesDinamicas;

import java.awt.Point;


public class Blinky extends Enemigo {

	public Blinky(int mov, EntidadGraficaDinamica grafico) {
		super(mov,grafico);
		ubicacion.setLocation(310,300);
		miImagen.setLocation(ubicacion.x-30, ubicacion.y-50);
	}

	public void calcularDirNormal(Point Pacman) {
		this.calcularDirDirecta(Pacman);
	}
	
	public void resetear() {
		ubicacion.setLocation(310,310);
		saliDeGate=false;
	}

}

package entidadesDinamicas;

import java.awt.Point;

import logica.MenteEnemiga;
import state.NormalState;

public class Clyde extends Enemigo {

	public Clyde(int mov, EntidadGraficaDinamica imagen) {
		super(mov, imagen);
		ubicacion.setLocation(310,300);
		miImagen.setLocation(ubicacion.x-30, ubicacion.y-50);
	}

	public void resetear() {
		this.resetearGeneral();
		ubicacion.setLocation(310,310);
		miImagen.setLocation(ubicacion.x-30, ubicacion.y-50);
	}

	public void calcularDirNormal(Point Pacman) {
		posicionObjetivo.setLocation(Pacman);
		if(ubicacion.x<=posicionObjetivo.x){
		  preferencias.setLocation(1, 0);
		}
		else{
		  preferencias.setLocation(-1, 0);
		}
		if(ubicacion.y<=posicionObjetivo.y){
		  preferencias.setLocation(preferencias.x, 1); 	
		}
		else {
		  preferencias.setLocation(preferencias.x, -1); 	
		}
	}

}

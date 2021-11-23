package entidades;

import java.awt.Point;

import logica.MenteEnemiga;

public class Clyde extends Enemigo {

	public Clyde(int mov, EntidadGraficaDinamica imagen, MenteEnemiga megamind) {
		super(mov, imagen, megamind);
		ubicacion.setLocation(280,310);
		miImagen.setLocation(ubicacion.x-30, ubicacion.y-50);
	}

	public void resetear() {
		this.resetearGeneral();
		ubicacion.setLocation(280,310);
		miImagen.setLocation(ubicacion.x-30, ubicacion.y-50);
	}

	protected void calcularDirNormal(Point Pacman) {
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

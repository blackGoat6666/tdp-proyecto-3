package entidades;

import java.awt.Point;

import logica.MenteEnemiga;


public class Blinky extends Enemigo {

	public Blinky(int mov, EntidadGraficaDinamica grafico, MenteEnemiga megamind) {
		super(mov,grafico, megamind);
		ubicacion.setLocation(310,310);
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
	
	public void resetear() {
		ubicacion.setLocation(310,310);
		this.resetearGeneral();
	}

	public EntidadGrafica getEntidadGrafica() {
		return miImagen;
		
	}



	

	
}

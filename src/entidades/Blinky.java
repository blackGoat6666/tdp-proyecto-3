package entidades;

import java.awt.Point;

import logica.MenteEnemiga;


public class Blinky extends Enemigo {

	public Blinky(int mov, EntidadGraficaDinamica grafico, MenteEnemiga megamind) {
		super(mov,grafico, megamind);
		ubicacion.setLocation(31,31);
		miImagen.setLocation(ubicacion.x-15, ubicacion.y-50);
	}

	public void calcularDir(Point Pacman) {
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
		ubicacion.setLocation((9*30)+30,(9*30)+30);
		intentos=0;
		miImagen.setModo("normal");
		miImagen.setLocation(ubicacion);
	}

	public EntidadGrafica getEntidadGrafica() {
		return miImagen;
		
	}

	public void moverPrimeraVez(Point wakawaka) {
		this.ultimaDireccion.setLocation(1, 0);
	}
	


	

	
}

package entidades;

import java.awt.Point;

import logica.MenteEnemiga;
import state.NormalState;

public class Inky extends Enemigo {

	public Inky(int mov, EntidadGraficaDinamica imagen, MenteEnemiga megamind) {
		super(mov, imagen, megamind);
		ubicacion.setLocation(330,300);
		miImagen.setLocation(ubicacion.x-30, ubicacion.y-50);
		this.miEstado = new NormalState(this);
		
		// TODO Auto-generated constructor stub
	}

	public void resetear() {
		ubicacion.setLocation(330,300);
		this.resetearGeneral();
	}

	@Override
	public void calcularDirNormal(Point Pacman) {
		Point blinkyBro= miMente.getUbicacionBlinky();
		Point objetivo= new Point(10,10);
		if(Pacman.x>=blinkyBro.x) {
			objetivo.setLocation(Pacman.x+(Pacman.x-blinkyBro.x), 10);
		}
		else {
			objetivo.setLocation(Pacman.x-(Pacman.x-blinkyBro.x), 10);
		}
		if(Pacman.y>=blinkyBro.y) {
			objetivo.setLocation(objetivo.x, Pacman.y+(Pacman.y-blinkyBro.y));
		}
		else {
			objetivo.setLocation(objetivo.x, Pacman.y-(Pacman.y-blinkyBro.y));
		}
		posicionObjetivo.setLocation(objetivo.x,objetivo.y);
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

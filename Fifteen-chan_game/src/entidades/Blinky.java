package entidades;

import java.awt.Point;

import visitor.Visitor;

public class Blinky extends Enemigo {

	public Blinky(int mov) {
		super(mov);
		ubicacion= new Point((9*30)+30, (9*30)+30);
		ubicacion.setLocation(ubicacion.x, ubicacion.y+mov);
		ultimaDireccion= new Point(0,-1);
	}

	public void calcularDir(Point Pacman) {
		posicionObjetivo=Pacman;
		if(ubicacion.x<=posicionObjetivo.x){
		  preferencias.setLocation(1, preferencias.y);
		}
		else{
		  preferencias.setLocation(-1, preferencias.y);
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
	}



	

	
}

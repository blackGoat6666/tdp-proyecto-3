<<<<<<< Updated upstream
package entidades;

import java.awt.Point;

public class Blinky extends Enemigo {

	public Blinky(int tamanioBloque) {
		super(tamanioBloque);
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
	
	public void mover(){
		
	}
	protected void moverArriba() {
	  ultimaDireccion.setLocation(0, -1);
	}
	
	protected void moverAbajo() {
	  ultimaDireccion.setLocation(0, 1);	
	}
	protected void moverIzquierda() {
	  ultimaDireccion.setLocation(-1, 0);
	}
	protected void moverDerecha() {
	  ultimaDireccion.setLocation(1,0);	
	}
	
}
=======
package entidades;

import java.awt.Point;

public class Blinky extends Enemigo {

	public Blinky(int mov) {
		super(mov);
		ubicacion= new Point((9*30)+30, (9*30)+30);
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
	}
	
	
	
}
>>>>>>> Stashed changes

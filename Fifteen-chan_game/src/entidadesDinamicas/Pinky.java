package entidadesDinamicas;

import java.awt.Point;

import logica.MenteEnemiga;
import state.NormalState;

public class Pinky extends Enemigo{

	public Pinky(int mov, EntidadGraficaDinamica imagen) {
		super(mov,imagen);
		ubicacion.setLocation(330,310);
		miImagen.setLocation(ubicacion.x-30, ubicacion.y-50);
	}
	

	@Override
	public void resetear() {
		ubicacion.setLocation(330,310);
		saliDeGate=false;
	}

	@Override
	public void calcularDirNormal(Point Pacman) {
		Point direccion=miMente.getDireccionPacman();
		if(direccion.y==-1) {
			posicionObjetivo.setLocation(Pacman.x-60, Pacman.x-120);
		}
		else {
			posicionObjetivo.setLocation(Pacman.x+(direccion.x*160),Pacman.y+(direccion.y*160));
		}
		
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

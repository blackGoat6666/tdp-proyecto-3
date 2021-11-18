package logica;

import java.awt.Point;

import entidades.Blinky;
import entidades.Enemigo;
import entidades.Entidad;

public class MenteEnemiga extends Thread{

	private Logica miLogica;
	private Blinky blinky;
	
	
	public MenteEnemiga(Logica logica, Blinky rojito) {
		miLogica=logica;
		blinky=rojito;
	}
	
	@Override
	public void run() {
		while(miLogica.jugando()) {
			blinky.mover();
			miLogica.actualizarPantalla();
			try {
				this.sleep(NORM_PRIORITY);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean estoyAMitadBloque(Point ubicacion) {
    	return miLogica.estoyAMitadBloque(ubicacion);
    }
 
	public void chequearBloque(Enemigo visitante, Point direccion) {
		miLogica.visitarBloque(visitante,  direccion);
	}
	
	public Point getUbicacionBlinky() {
		return blinky.getUbicacion();
	}
	
	public void murioBlinky() {
		blinky.morir();
	}
	
}

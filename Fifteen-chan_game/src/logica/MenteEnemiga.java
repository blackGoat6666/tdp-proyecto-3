package logica;

import java.awt.Point;

import entidades.Blinky;
import entidades.Enemigo;
import entidades.Entidad;

public class MenteEnemiga implements Runnable{

	private Logica miLogica;
	private Blinky blinky;
	
	
	public MenteEnemiga(Logica logica, Blinky rojito) {
		miLogica=logica;
		blinky=rojito;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean estoyAMitadBloque(Point ubicacion) {
    	return miLogica.estoyAMitadBloque(ubicacion);
    }
 
	public void chequearBloque(Enemigo visitante, Point direccion) {
		miLogica.visitarBloque(visitante,  direccion);
	}
	
	public Point getUbicacionBlinky() {
		return Blinky.
	}
	
	
}

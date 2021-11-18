package logica;

import java.awt.Point;

import entidades.Blinky;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.EntidadGraficaDinamica;

public class MenteEnemiga extends Thread{

	private Logica miLogica;
	private Blinky blinky;
	
	
	public MenteEnemiga(Logica logica, EntidadGraficaDinamica rojito) {
		miLogica=logica;
		blinky=new Blinky(5,rojito, this );
		miLogica.graficar(rojito);
		miLogica.actualizarPantalla();
		blinky.moverPrimeraVez(miLogica.getUbicacionPacman());
	}
	
	@Override
	public void run() {
		while(miLogica.jugando()) {
			
			blinky.calcularDir(miLogica.getUbicacionPacman());
			blinky.mover();
			miLogica.actualizarPantalla();
			try {
				this.sleep(1000);
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

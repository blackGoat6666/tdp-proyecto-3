package logica;

import java.awt.Point;

import entidades.Blinky;
import entidades.Clyde;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.EntidadGraficaDinamica;
import entidades.Inky;
import entidades.Pinky;

public class MenteEnemiga extends Thread{

	private Logica miLogica;
	private Blinky blinky;
	private Inky inky;
	private Pinky pinky;
	private Clyde elPana;
	private Boolean huir;
	private Point pacman;
	
	
	public MenteEnemiga(Logica logica, EntidadGraficaDinamica rojito, EntidadGraficaDinamica celestito, EntidadGraficaDinamica rosita) {
		miLogica=logica;
		blinky=new Blinky(5,rojito, this );
		inky= new Inky(3, celestito, this);
		pinky= new Pinky(3,rosita,this);
		miLogica.graficar(rojito);
		miLogica.graficar(celestito);
		miLogica.graficar(rosita);
		miLogica.actualizarPantalla();
		huir=false;
	}
	
	@Override
	public void run() {
		while(miLogica.jugando()) {
			this.pacman=miLogica.getUbicacionPacman();
			blinky.calcularDir(pacman);
			inky.calcularDir(pacman);
			pinky.calcularDir(pacman);
			blinky.mover();
			inky.mover();
			pinky.mover();
			miLogica.actualizarPantalla();
			this.chequearColisiones();
			 try {
		    	this.sleep(100);
		    
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Point getPosicionPacman() {
		return pacman;
	}
	public Boolean llegueAGate(Point ubicacion) {
		return miLogica.llegoAGate(ubicacion);
	}
	public Boolean saliDeGate(Point ubicacion) {
		return miLogica.salioDeGate(ubicacion);
	}

	public void chequearBloque(Enemigo visitante, Point direccion) {
		miLogica.visitarBloque(visitante,  direccion);
	}
	
	public Point getUbicacionBlinky() {
		return blinky.getUbicacion();
	}

	public void resetearFantasmas() {
		blinky.resetear();
		inky.resetear();
		pinky.resetear();
	}
	
	public void fantasmasModoNormal() {
		blinky.volverModoNormal();
		inky.volverModoNormal();
		pinky.volverModoNormal();
		huir=false;
		miLogica.actualizarPantalla();
	}
	public Point getDireccionPacman() {
		if(miLogica.getDireccionPacman()==null) {
			return( new Point(0,-1));
		}
		return miLogica.getDireccionPacman();
	}
	
	public void setHuir(Boolean estado) {
		huir=estado;
		blinky.setHuir(huir);
		inky.setHuir(huir);
		pinky.setHuir(huir);
	}
	
	public Boolean cambioDeBloque(Point ubicacion1, Point ubicacion2) {
		return !miLogica.mismoBloque(ubicacion1, ubicacion2);
	}
	
	
	private void chequearColisiones() {
		if(huir) {
			this.fantasmasMuertos();
		}
		else {
			this.pacmanMuerto();
		}

	}
	private void fantasmasMuertos() {
		if(miLogica.colisionaConPacman(blinky.getUbicacion())) {
			blinky.morir();
			miLogica.sumarPuntos(200);
		}
		if(miLogica.colisionaConPacman(inky.getUbicacion())) {
			inky.morir();
			miLogica.sumarPuntos(200);
		}
		if(miLogica.colisionaConPacman(pinky.getUbicacion())) {
			pinky.morir();
			miLogica.sumarPuntos(200);
		}
		
	}
	private void pacmanMuerto() {
		if(miLogica.colisionaConPacman(blinky.getUbicacion()) ||miLogica.colisionaConPacman(inky.getUbicacion()) ||miLogica.colisionaConPacman(pinky.getUbicacion()) ) {
			miLogica.perderVida();
		}
	}
	
}

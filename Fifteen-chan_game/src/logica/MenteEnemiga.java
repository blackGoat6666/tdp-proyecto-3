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

	private LogicaGeneral miLogicaGeneral;
	private LogicaColisiones miLogicaColisiones;
	private Blinky blinky;
	private Inky inky;
	private Pinky pinky;
	private Clyde elPana;
	private Boolean huir;
	private Point pacman;
	
	
	public MenteEnemiga(LogicaGeneral logicaGeneral, LogicaColisiones logicaColisiones, EntidadGraficaDinamica rojito, EntidadGraficaDinamica celestito, EntidadGraficaDinamica rosita) {
		miLogicaGeneral= logicaGeneral;
		miLogicaColisiones =logicaColisiones;
		blinky=new Blinky(5,rojito, this );
		inky= new Inky(3, celestito, this);
		pinky= new Pinky(3,rosita,this);
		miLogicaColisiones.graficar(rojito);
		miLogicaColisiones.graficar(celestito);
		miLogicaColisiones.graficar(rosita);
		miLogicaColisiones.actualizarPantalla();
		huir=false;
	}
	
	@Override
	public void run() {
		while(miLogicaColisiones.jugando()) {
			this.pacman=miLogicaColisiones.getUbicacionPacman();
			blinky.calcularDir(pacman);
			inky.calcularDir(pacman);
			pinky.calcularDir(pacman);
			blinky.mover();
			inky.mover();
			pinky.mover();
			miLogicaColisiones.actualizarPantalla();
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
		return miLogicaColisiones.llegoAGate(ubicacion);
	}
	public Boolean saliDeGate(Point ubicacion) {
		return miLogicaColisiones.salioDeGate(ubicacion);
	}

	public void chequearBloque(Enemigo visitante, Point direccion) {
		miLogicaColisiones.visitarBloque(visitante,  direccion);
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
		miLogicaColisiones.actualizarPantalla();
	}
	public Point getDireccionPacman() {
		if(miLogicaColisiones.getDireccionPacman()==null) {
			return( new Point(0,-1));
		}
		return miLogicaColisiones.getDireccionPacman();
	}
	
	public void setHuir(Boolean estado) {
		huir=estado;
		blinky.setHuir(huir);
		inky.setHuir(huir);
		pinky.setHuir(huir);
	}
	
	public Boolean cambioDeBloque(Point ubicacion1, Point ubicacion2) {
		return !miLogicaColisiones.mismoBloque(ubicacion1, ubicacion2);
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
		if(miLogicaColisiones.colisionaConPacman(blinky.getUbicacion())) {
			blinky.morir();
			miLogicaGeneral.sumarPuntos(200);
		}
		if(miLogicaColisiones.colisionaConPacman(inky.getUbicacion())) {
			inky.morir();
			miLogicaGeneral.sumarPuntos(200);
		}
		if(miLogicaColisiones.colisionaConPacman(pinky.getUbicacion())) {
			pinky.morir();
			miLogicaGeneral.sumarPuntos(200);
		}
		
	}
	private void pacmanMuerto() {
		if(miLogicaColisiones.colisionaConPacman(blinky.getUbicacion()) ||miLogicaColisiones.colisionaConPacman(inky.getUbicacion()) ||miLogicaColisiones.colisionaConPacman(pinky.getUbicacion()) ) {
			miLogicaColisiones.perderVida();
		}
	}
	
}

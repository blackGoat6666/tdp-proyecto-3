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
	private Boolean pacmanInvisible;
	
	public MenteEnemiga(LogicaGeneral logicaGeneral, LogicaColisiones logicaColisiones, EntidadGraficaDinamica rojito, EntidadGraficaDinamica celestito, EntidadGraficaDinamica rosita, EntidadGraficaDinamica miRey) {
		miLogicaGeneral= logicaGeneral;
		miLogicaColisiones =logicaColisiones;
		blinky=new Blinky(5,rojito, this );
		inky= new Inky(3, celestito, this);
		pinky= new Pinky(3,rosita,this);
		elPana= new Clyde(3, miRey,this);
		miLogicaColisiones.graficar(rojito);
		miLogicaColisiones.graficar(celestito);
		miLogicaColisiones.graficar(rosita);
		miLogicaColisiones.graficar(miRey);
		miLogicaColisiones.actualizarPantalla();
		huir=false;
		pacmanInvisible=false;
	}
	
	@Override
	public void run() {
		while(miLogicaColisiones.jugando()) {
			this.pacman=miLogicaColisiones.getUbicacionPacman();
			blinky.calcularDir(pacman);
			inky.calcularDir(pacman);
			pinky.calcularDir(pacman);
			elPana.calcularDir(pacman);
			blinky.mover();
			inky.mover();
			pinky.mover();
			elPana.mover();
			miLogicaColisiones.actualizarPantalla();
			this.chequearColisiones();
			 try {
		    	this.sleep(200);
		    
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
		elPana.resetear();
	}
	
	public void fantasmasModoNormal() {
		blinky.volverModoNormal();
		inky.volverModoNormal();
		pinky.volverModoNormal();
		elPana.volverModoNormal();
		huir=false;
		this.pacmanInvisible=false;
		miLogicaColisiones.actualizarPantalla();
	}
	public Point getDireccionPacman() {
		if(miLogicaColisiones.getDireccionPacman()==null) {
			return( new Point(0,-1));
		}
		return miLogicaColisiones.getDireccionPacman();
	}
	
	public void setHuir() {
		huir=true;
		blinky.setHuir();
		inky.setHuir();
		pinky.setHuir();
		elPana.setHuir();
	}
	
	public Boolean cambioDeBloque(Point ubicacion1, Point ubicacion2) {
		return !miLogicaColisiones.mismoBloque(ubicacion1, ubicacion2);
	}
	
	public void explotoBomba(Point ub) {
		if(Math.abs(ub.x-blinky.getUbicacion().x)<=31*8 ||Math.abs(ub.y-blinky.getUbicacion().y)<=31*8 ) {
			blinky.morir();
			miLogicaGeneral.sumarPuntos(400);
		}
		if(Math.abs(ub.x-inky.getUbicacion().x)<=31*8 ||Math.abs(ub.y-inky.getUbicacion().y)<=31*8 ) {
			inky.morir();
			miLogicaGeneral.sumarPuntos(400);
		}
		if(Math.abs(ub.x-pinky.getUbicacion().x)<=31*8 ||Math.abs(ub.y-pinky.getUbicacion().y)<=31*8 ) {
			pinky.morir();
			miLogicaGeneral.sumarPuntos(400);
		}
		if(Math.abs(ub.x-elPana.getUbicacion().x)<=31*8 ||Math.abs(ub.y-elPana.getUbicacion().y)<=31*8 ) {
			elPana.morir();
			miLogicaGeneral.sumarPuntos(400);
		}
		miLogicaColisiones.actualizarPantalla();
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
		if(this.colisionoConPacman(blinky) ) {
			blinky.morir();
			miLogicaGeneral.sumarPuntos(200);
		}
		if(this.colisionoConPacman(inky)) {
			inky.morir();
			miLogicaGeneral.sumarPuntos(200);
		}
		if(this.colisionoConPacman(pinky)) {
			pinky.morir();
			miLogicaGeneral.sumarPuntos(200);
		}
		if(this.colisionoConPacman(elPana)) {
			elPana.morir();
			miLogicaGeneral.sumarPuntos(200);
		}
		
	}
	private void pacmanMuerto() {
		if( !(this.pacmanInvisible) && ( (this.colisionoConPacman(blinky)  && !(blinky.estoyMuerto()) ) ||
		 (this.colisionoConPacman(inky)  && !(inky.estoyMuerto())) ||(this.colisionoConPacman(pinky)  && !(pinky.estoyMuerto())) || (this.colisionoConPacman(elPana) && !(elPana.estoyMuerto())) ) ) {
			miLogicaColisiones.perderVida();
		}
	}
	
	private boolean colisionoConPacman(Enemigo fantasma) {
		return miLogicaColisiones.colisionaConPacman(fantasma.getUbicacion());
	}
	
	public void setPacmanInvisible() {
		this.pacmanInvisible=true;
	}
	public void graficarFantasmitas() {
		miLogicaColisiones.graficar(blinky.getEntidadGrafica());
		miLogicaColisiones.graficar(this.inky.getEntidadGrafica());
		miLogicaColisiones.graficar(this.pinky.getEntidadGrafica());
		miLogicaColisiones.graficar(this.elPana.getEntidadGrafica());
	}
	public void cambiarVelocidad() {
		blinky.setMovimiento(blinky.getMovimiento()+1);
		inky.setMovimiento(inky.getMovimiento()+1);
		pinky.setMovimiento(pinky.getMovimiento()+1);
		elPana.setMovimiento(elPana.getMovimiento()+1);
	}
}

package logica;

import java.awt.Point;

import TDALista.BoundaryViolationException;
import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.ListaDoblementeEnlazada;
import TDALista.Position;
import TDALista.PositionList;
import entidadesDinamicas.Enemigo;
import state.HuirState;
import state.MuertoState;
import state.NormalState;

public class MenteEnemiga extends Thread{

	private LogicaGeneral miLogicaGeneral;
	private LogicaColisiones miLogicaColisiones;
	private PositionList<Enemigo> listaEnemigos;
	private Enemigo blinky;
	private Boolean huir;
	private Point pacman;
	private Boolean pacmanInvisible;
	
	public MenteEnemiga(LogicaGeneral logicaGeneral, LogicaColisiones logicaColisiones, Enemigo rojito, Enemigo celestito, Enemigo rosita, Enemigo miRey) {
		miLogicaGeneral= logicaGeneral;
		miLogicaColisiones =logicaColisiones;
		listaEnemigos= new ListaDoblementeEnlazada<Enemigo>();
		blinky=rojito;
		listaEnemigos.addLast(rojito);
		listaEnemigos.addLast(celestito);
		listaEnemigos.addLast(rosita);
		listaEnemigos.addLast(miRey);
		for(Enemigo e: this.listaEnemigos) {
			miLogicaColisiones.graficar(e.getEntidadGrafica());
			e.setMenteEnemiga(this);
		}
		miLogicaColisiones.actualizarPantalla();
		huir=false;
		pacmanInvisible=false;
	}
	
	@Override
	public void run() {
		while(miLogicaColisiones.jugando()) {
			this.pacman=miLogicaColisiones.getUbicacionPacman();
			for(Enemigo e: this.listaEnemigos) {
				e.calcularDir(pacman);
				e.mover();
			}
			miLogicaColisiones.actualizarPantalla();
			 try {
				this.chequearColisiones();
		    	this.sleep(200);
		    
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EmptyListException|InvalidPositionException|BoundaryViolationException  e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
		for(Enemigo e: this.listaEnemigos) {
			e.resetear();
			e.changeState(new NormalState(e));
		}
	}
	
	public void fantasmasModoNormal() {
		for(Enemigo e: this.listaEnemigos) {
			e.changeState(new NormalState(e));
		}
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
		for(Enemigo e: this.listaEnemigos) {
			if( !(e.estoyMuerto()) ) {
				e.changeState(new HuirState(e));
			}
		}
	}
	
	public Boolean cambioDeBloque(Point ubicacion1, Point ubicacion2) {
		return !miLogicaColisiones.mismoBloque(ubicacion1, ubicacion2);
	}
	
	public void explotoBomba(Point ub) {
		for(Enemigo e: this.listaEnemigos) {
			if(Math.abs(ub.x-e.getUbicacion().x)<=31*8 ||Math.abs(ub.y-e.getUbicacion().y)<=31*8 ) {
				e.changeState(new MuertoState(e));
				miLogicaGeneral.sumarPuntos(400);
			}
		}
		miLogicaColisiones.actualizarPantalla();
	}
	
	private void chequearColisiones() throws EmptyListException, InvalidPositionException, BoundaryViolationException {
		if(huir) {
			this.fantasmasMuertos();
		}
		else {
			this.pacmanMuerto();
		}

	}
	private void fantasmasMuertos() {
		for(Enemigo e: this.listaEnemigos) {
			if(this.colisionoConPacman(e)) {
				e.changeState(new MuertoState(e));
				miLogicaGeneral.sumarPuntos(200);
			}
		}
	}
	private void pacmanMuerto() throws EmptyListException, InvalidPositionException, BoundaryViolationException {
		boolean murio=false;
		if(!(this.pacmanInvisible)) {
			Position<Enemigo> cursor=this.listaEnemigos.first();
			while(!murio && cursor!=this.listaEnemigos.last()) {
				Enemigo e=cursor.element();
				if(this.colisionoConPacman(e)  && !(e.estoyMuerto()) ){
						murio=true;
				}
				cursor=this.listaEnemigos.next(cursor);
			}
			Enemigo e=cursor.element();
			if(this.colisionoConPacman(e)  && !(e.estoyMuerto()) ){
					murio=true;
			}
			
		}
		if(murio) {
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
		for(Enemigo e: this.listaEnemigos) {
			this.miLogicaColisiones.graficar(e.getEntidadGrafica());
		}
	}
	public void cambiarVelocidad() {
		for(Enemigo e: this.listaEnemigos) {
			e.setMovimiento(e.getMovimiento()+1);
		}
	}
}

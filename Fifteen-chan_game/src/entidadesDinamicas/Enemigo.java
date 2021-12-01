package entidadesDinamicas;

import java.awt.Point;

import logica.MenteEnemiga;
import state.NormalState;
import state.StateFantasma;

public abstract class Enemigo extends EntidadDinamica {
    
	protected Point preferencias;
	protected Point posicionObjetivo;
	protected Point ultimaDireccion;
	protected MenteEnemiga miMente;
	protected int movimientoOriginal;
	protected Point ubicacion;
	protected Boolean saliDeGate;
	protected StateFantasma miEstado;
	protected Point ultimoBloque;
	protected Boolean meMovi;
	
	
	public Enemigo(int mov, EntidadGraficaDinamica imagen) {
		super(imagen);
		ubicacion= new Point(0,0);
		movimientoOriginal=mov;
		ultimaDireccion= new Point(0,0);
		ultimoBloque= new Point(0,0);
		posicionObjetivo= new Point(0,0);
		saliDeGate=false;
		preferencias= new Point(0,0);
		this.meMovi=false;
    }
	
	public void setMenteEnemiga(MenteEnemiga megamind) {
		this.miMente=megamind;
		this.miEstado = new NormalState(this);
	}
	
	public int getMovimiento() {
		return this.movimientoOriginal;
	}

	public void changeState(StateFantasma estado) {
		this.miEstado=estado;
	}
	
	public void setUbicacion(Point ub) {
		this.ubicacion=ub;
	}
	
	public abstract void resetear();

	public Point getUltimoBloque() {
		return this.ultimoBloque;
	}
	public void setUltimoBloque(Point ult) {
		this.ultimoBloque=ult;
	}
	
	public void setUltimaDireccion(Point dir) {
		this.ultimaDireccion=dir;
	}

	@Override
	public void mover() {
		this.miEstado.mover();
	}
	
	public void setSaliDeGate(Boolean sali) {
		this.saliDeGate=sali;
	}
	public Boolean getSaliDeGate() {
		return this.saliDeGate;
	}

	
	public Boolean puedoAtravesarGate() {
		return miEstado.puedeAtravesarGate();
	}
	
	public void seMovio() {
		this.meMovi=true;
	}

	public void actualizarMiEntidadGrafica() {
		if(this.siguienteDireccion(this.miEstado.getIntentos()).x==0) {
			if(this.siguienteDireccion(this.miEstado.getIntentos()).y==1) {
				miImagen.setAdelante();
			}
			else {
				miImagen.setAtras();
			}
		}
		else {
			if(this.siguienteDireccion(this.miEstado.getIntentos()).x==1) {
				miImagen.setDerecha();
			}
			else {
				miImagen.setIzquierda();
			}
		}
		
	}
	
	public void setPreferencias(Point pref) {
		this.preferencias=pref;
	}
	public Point getPreferencias() {
		return this.preferencias;
	}
	
	
	public Point siguienteDireccion(int inte) {
			switch(inte) {
			case 0: if(ultimaDireccion.x==0) {
						return new Point(preferencias.x, 0);
					}
					else {
						return new Point(0, preferencias.y);
					}
			case 1: return ultimaDireccion;
			case 2: if(ultimaDireccion.y==0) {
						return new Point(0, -(preferencias.y));
					}
					else {
						return new Point(-(preferencias.x), 0);
					}
		}
		return new Point(0, preferencias.y);
		
	}
	
	public Point getUbicacion() {
		return this.ubicacion;
	}
	
	public void calcularDir(Point Pacman) {
		this.miEstado.calcularDir(Pacman);	
	}
	
	public void  calcularDirDirecta(Point ub) {
		posicionObjetivo.setLocation(ub);
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
	
	
	
	public String toString() {
		return "Enemigo";
	}
	public void setNoSeMovio() {
		this.meMovi=false;
	}
	
	public boolean estoyMuerto() {
		return this.miEstado.getMuerto();
	}


	public abstract void calcularDirNormal(Point Pacman);
	
	public EntidadGraficaDinamica getEntidadGrafica() {
		return miImagen;
		
	}
	
	public MenteEnemiga getMente() {
		return this.miMente;
	}
	
	public void setMovimiento(int mov) {
		this.movimientoOriginal=mov;
	}
	
	public Boolean getSeMovio() {
		return this.meMovi;
	}
	

}

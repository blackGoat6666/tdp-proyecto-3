package entidades;

import java.awt.Point;
import java.util.Random;

import logica.MenteEnemiga;
import visitor.Visitor;

public abstract class Enemigo extends EntidadDinamica {
    
	protected Point preferencias;
	protected Point posicionObjetivo;
	protected Point ultimaDireccion;
	protected int intentos;
	protected MenteEnemiga miMente;
	protected int movimiento;
	protected int movimientoOriginal;
	protected Boolean meMovi;
	protected Point ubicacion;
	protected Boolean muerto;
	protected Boolean huir;
	protected Boolean saliDeGate;
	protected int meAtore;
	protected Point ultimoBloque;
	protected Random random;
	
	public Enemigo(int mov, EntidadGraficaDinamica imagen, MenteEnemiga megamind) {
		super(imagen);
		movimiento=mov;
		movimientoOriginal=mov;
		intentos=0;
		ultimaDireccion= new Point(0,0);
		preferencias= new Point(0,0);
		ultimoBloque= new Point(0,0);
		meMovi=false;
		meAtore=4;
		miMente=megamind;
		ubicacion= new Point(0,0);
		posicionObjetivo= new Point(0,0);
		huir=false;
		muerto=false;
		saliDeGate=false;
		random= new Random();
	}


	
	public abstract void resetear();



	@Override
	public void mover() {
		  Point vectorMovimiento;
		  Point movimientoReal;
		  movimientoReal= new Point(0,0);
		  while(!meMovi && intentos<=2) {
			vectorMovimiento= this.siguienteDireccion();
			movimientoReal= new Point( ((vectorMovimiento.x)*30)+ ubicacion.x ,(vectorMovimiento.y*30)+ ubicacion.y);
			if((movimientoReal.x>=31) && (movimientoReal.y>=31) && (movimientoReal.x<=20*30)&& (movimientoReal.y<=20*30)) {
				if(intentos!=0 || miMente.cambioDeBloque(ultimoBloque, movimientoReal)) {
				miMente.chequearBloque(this, movimientoReal);
				}
            }
			intentos++;
		  }
		  intentos--;
		  vectorMovimiento=this.siguienteDireccion();
		  ultimaDireccion.setLocation(vectorMovimiento);
		  this.actualizarMiEntidadGrafica();
		  movimientoReal.setLocation(vectorMovimiento.x*movimiento, vectorMovimiento.y*movimiento);
		  ubicacion.setLocation(ubicacion.x+movimientoReal.x, ubicacion.y+movimientoReal.y);
		  ultimoBloque.setLocation(ubicacion);
		  miImagen.setLocation(miImagen.getLocation().x+movimientoReal.x, miImagen.getLocation().y+movimientoReal.y);
		  meMovi=false;
		  intentos=0;
		  if(muerto && miMente.llegueAGate(ubicacion)){
			  muerto=false;
			  saliDeGate=false;
			  movimiento=movimientoOriginal;
		  }
		  if(!saliDeGate && miMente.saliDeGate(ubicacion)) {
			  saliDeGate=true;
		  }
		  
	}
	public void volverModoNormal() {
		huir=false;
		if(!muerto) {
			this.miImagen.setModo("normal");
			this.movimiento=this.movimientoOriginal;
		}
	}
	
	public Boolean puedoAtravesarGate() {
		return(!saliDeGate || muerto);
	}
	
	public void seMovio() {
		meMovi=true;
	}

	@Override
	public void morir() {
		miImagen.setModo("invisibilidad");
		muerto=true;
		saliDeGate=false;
		huir=false;
		meAtore=0;
		intentos=0;
		movimiento=movimientoOriginal+3;
		
	}
	protected void actualizarMiEntidadGrafica() {
		if(this.siguienteDireccion().x==0) {
			if(this.siguienteDireccion().y==1) {
				miImagen.setAdelante();
			}
			else {
				miImagen.setAtras();
			}
		}
		else {
			if(this.siguienteDireccion().x==1) {
				miImagen.setDerecha();
			}
			else {
				miImagen.setIzquierda();
			}
		}
		
	}
	
	
	protected Point siguienteDireccion() {
			switch(intentos) {
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
		return ultimaDireccion;
		
	}
	
	public Point getUbicacion() {
		return ubicacion;
	}
	public void accept(Visitor v) {
	}

	public void calcularDir(Point Pacman) {
		if(!huir && !muerto && saliDeGate) {
			this.calcularDirNormal(Pacman);
		}
		else {
			if(huir) {
				this.calcularDirNormal(Pacman);
				preferencias.setLocation(-(preferencias.x), -(preferencias.y));
			}
			else if(muerto) {
			    this.calcularDirDirecta(new Point(320,320));	
			}
			else {
				this.calcularDirDirecta(new Point(300,240));
			}
		}
		
		
	}
	protected void  calcularDirDirecta(Point ubicacion) {
		posicionObjetivo.setLocation(ubicacion);
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
	
	public void setHuir() {
		if(!this.muerto) {
			huir=true;
			this.calcularDir(miMente.getPosicionPacman());
			movimiento=movimientoOriginal-1;
			this.miImagen.setModo("powerPellet");
		}
	}
	
	public String toString() {
		return "Enemigo";
	}
	public void setNoSeMovio() {
		meMovi=false;
	}
	
	public boolean estoyMuerto() {
		return this.muerto;
	}
	protected void resetearGeneral() {
		miImagen.setModo("normal");
		miImagen.setLocation(ubicacion.x-30, ubicacion.y-50);
		movimiento=this.movimientoOriginal;
		intentos=0;
		meMovi=false;
		huir=false;
		muerto=false;
		saliDeGate=false;
	}

	protected abstract void calcularDirNormal(Point Pacman);
	
	public EntidadGrafica getEntidadGrafica() {
		return miImagen;
		
	}
}

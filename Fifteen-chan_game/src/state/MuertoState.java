package state;

import java.awt.Point;

import entidadesDinamicas.Enemigo;
import entidadesDinamicas.EntidadGraficaDinamica;
import logica.MenteEnemiga;

public class MuertoState implements StateFantasma{
	protected Enemigo miFantasmita;
	protected Boolean meMovi;
	protected int intentos;
	protected int movimiento;
	protected EntidadGraficaDinamica miImagen;
	protected MenteEnemiga miMente;

	
	public MuertoState(Enemigo fantasmin) {
		miFantasmita=fantasmin;
		miImagen=miFantasmita.getEntidadGrafica();
		miImagen.setModo("huir");
		miMente=miFantasmita.getMente();
		miFantasmita.setSaliDeGate(false);
		intentos=0;
		this.movimiento=miFantasmita.getMovimiento()+3;
	    meMovi=false; 
	}
	
	
	public void calcularDir(Point Pacman) {
		miFantasmita.calcularDirDirecta(new Point(345,345));
	}

	@Override
	public void mover() {
		Point vectorMovimiento;
		Point movimientoReal;
		movimientoReal= new Point(0,0);
		while(!meMovi && intentos<=2) {
			vectorMovimiento= miFantasmita.siguienteDireccion(intentos);
			movimientoReal= new Point( ((vectorMovimiento.x)*30)+ miFantasmita.getUbicacion().x ,(vectorMovimiento.y*30)+ miFantasmita.getUbicacion().y);
			if((movimientoReal.x>=31) && (movimientoReal.y>=31) && (movimientoReal.x<=20*30)&& (movimientoReal.y<=20*30)) {
				if(intentos!=0 || miMente.cambioDeBloque( miFantasmita.getUltimoBloque(), movimientoReal)) {
					miMente.chequearBloque(miFantasmita, movimientoReal);
		        }
            }
			intentos++;
		 }
		 intentos--;
		 vectorMovimiento=miFantasmita.siguienteDireccion(intentos);
		 miFantasmita.setUltimaDireccion(vectorMovimiento);
		 miFantasmita.actualizarMiEntidadGrafica();
		 movimientoReal.setLocation(vectorMovimiento.x*movimiento, vectorMovimiento.y*movimiento);
		 miFantasmita.getUbicacion().setLocation(miFantasmita.getUbicacion().x+movimientoReal.x, miFantasmita.getUbicacion().y+movimientoReal.y);
		 miFantasmita.setUltimoBloque(miFantasmita.getUbicacion());
		 miImagen.setLocation(miImagen.getLocation().x+movimientoReal.x, miImagen.getLocation().y+movimientoReal.y);
		 meMovi=false;
		 intentos=0;
		 if(miMente.llegueAGate(miFantasmita.getUbicacion())) {
			miFantasmita.setSaliDeGate(false);
			miFantasmita.changeState(new NormalState(this.miFantasmita)); 
	     }
	}


	public void morir() {
	}


	@Override
	public void huir() {
	}


	@Override
	public void setMePuedoMover(Boolean puedo) {
		this.meMovi=puedo;
	}


	@Override
	public Boolean puedeAtravesarGate() {
		return true;
	}


	@Override
	public Boolean getMuerto() {
		return true;
	}


	public void modoNormal() {
	}


	@Override
	public void resetear() {
		miFantasmita.setSaliDeGate(false);
		this.miFantasmita.changeState(new NormalState(this.miFantasmita));
	}


	@Override
	public int getIntentos() {
		return intentos;
	}

}

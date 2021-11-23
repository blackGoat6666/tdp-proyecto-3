package state;

import java.awt.Point;

import entidades.Enemigo;
import entidades.EntidadGraficaDinamica;
import logica.MenteEnemiga;

public class HuirState implements StateFantasma{
	protected Enemigo miFantasmita;
	protected Boolean meMovi;
	protected int movimiento;
	protected int intentos;
	protected EntidadGraficaDinamica miImagen;
	protected MenteEnemiga miMente;
	
	public HuirState(Enemigo fantasmin) {
		miFantasmita=fantasmin;
		miImagen=miFantasmita.getEntidadGrafica();
		miMente=miFantasmita.getMente();
		this.calcularDir(this.miMente.getPosicionPacman());
		this.miImagen.setModo("powerPellet");
		this.movimiento=miFantasmita.getMovimiento()-2;
		intentos=0;
		meMovi=false;
		
	}
	
	public void calcularDir(Point Pacman) {
		miFantasmita.calcularDirNormal(Pacman);
		Point prefLocales= miFantasmita.getPreferencias();
		miFantasmita.setPreferencias(new Point(-(prefLocales.x), -(prefLocales.y)));
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
		
	}

	@Override
	public void morir() {
		this.miFantasmita.changeState(new MuertoState(this.miFantasmita));
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
		return false;
	}

	@Override
	public Boolean getMuerto() {
		return false;
	}

	@Override
	public void modoNormal() {
		miFantasmita.changeState(new NormalState(this.miFantasmita)); 
	}

	@Override
	public void resetear() {
		this.modoNormal();
	}

	@Override
	public int getIntentos() {
		// TODO Auto-generated method stub
		return intentos;
	}

}

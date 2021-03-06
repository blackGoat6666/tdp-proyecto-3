package state;

import java.awt.Point;

import entidadesDinamicas.Enemigo;
import entidadesDinamicas.EntidadGraficaDinamica;
import logica.MenteEnemiga;

public class NormalState implements StateFantasma{
	protected Enemigo miFantasmita;
	protected int movimiento;
	protected int intentos;
	protected EntidadGraficaDinamica miImagen;
	protected MenteEnemiga miMente;
	
	public NormalState(Enemigo fantasmin) {
		miFantasmita=fantasmin;
		miImagen=miFantasmita.getEntidadGrafica();
		miFantasmita.getEntidadGrafica().setModo("normal");
		miFantasmita.getEntidadGrafica().setLocation(miFantasmita.getUbicacion().x-30, miFantasmita.getUbicacion().y-50);
		movimiento=miFantasmita.getMovimiento();
		miMente=miFantasmita.getMente();
		intentos=0;
		this.movimiento=miFantasmita.getMovimiento();
	}
	
	public void calcularDir(Point Pacman) {
		if(miFantasmita.getSaliDeGate()) {
			miFantasmita.calcularDirNormal(Pacman);
		}
		else {
			miFantasmita.calcularDirDirecta(new Point(300,240));
		}
	}

	@Override
	public void mover() {
		Point vectorMovimiento;
		Point movimientoReal;
		movimientoReal= new Point(0,0);
		while(!this.miFantasmita.getSeMovio() && intentos<=2) {
			vectorMovimiento= miFantasmita.siguienteDireccion(intentos);
			movimientoReal= new Point( ( ((vectorMovimiento.x)*30)+ miFantasmita.getUbicacion().x ) ,((vectorMovimiento.y*30)+ miFantasmita.getUbicacion().y));
			if((movimientoReal.x>=31) && (movimientoReal.y>=31) && (movimientoReal.x<=20*30)&& (movimientoReal.y<=20*30)) {
				   miMente.chequearBloque(miFantasmita, movimientoReal);
		        
            }
			intentos++;
		 }
		intentos--;
		vectorMovimiento=miFantasmita.siguienteDireccion(intentos);
		miFantasmita.setUltimaDireccion(vectorMovimiento);
		miFantasmita.actualizarMiEntidadGrafica();
	    movimientoReal.setLocation(vectorMovimiento.x*movimiento, vectorMovimiento.y*movimiento);
		miFantasmita.setUbicacion( new Point(miFantasmita.getUbicacion().x+movimientoReal.x, miFantasmita.getUbicacion().y+movimientoReal.y));
		miFantasmita.setUltimoBloque(miFantasmita.getUbicacion());
		miImagen.setLocation(miImagen.getLocation().x+movimientoReal.x, miImagen.getLocation().y+movimientoReal.y);
		this.miFantasmita.setNoSeMovio();
		intentos=0;
		if(!(miFantasmita.getSaliDeGate()) && miMente.saliDeGate(miFantasmita.getUbicacion())) {
			miFantasmita.setSaliDeGate(true);
		}
		
	}
	
	public Boolean puedeAtravesarGate() {
		return !(miFantasmita.getSaliDeGate());
	}
	@Override
	public Boolean getMuerto() {
		return false;
	}

	@Override
	public int getIntentos() {
		return intentos;
	}


}

package grilla;

import java.awt.Point;

import Objetos.Consumible;
import bloque.Bloque;
import enemigos.MenteEnemiga;
import fabricas.FabricaEnemigos;
import logica.Logica;

public class Grilla {
	// atributos
	private Bloque[][] matriz;
	private int cantidadInicialDeConsumibles;
	private  int tamanioBloqueGrafico;
	private MenteEnemiga misEnemigos;
	private Logica miLogica;
	//constructor
	
	public Grilla(FabricaEnemigos modo) {
		matriz = new Bloque[20][20];
		cantidadInicialDeConsumibles = 244;
		tamanioBloqueGrafico =0;
	}
	//metodos
	public boolean hayPared(Point direccion) {
		int x = (int) direccion.getX();
		int y = (int) direccion.getY();
		return (matriz[x][y].esLadrillo());
	}
	public boolean hayGate(Point direccion) {
		int x = (int) direccion.getX();
		int y = (int) direccion.getY();
		return (matriz[x][y].esGate());
		
	}
	public boolean hayEnemigo(Point direccion) {
		Point[] ubicacionEnemigos = misEnemigos.getUbicacionEnemigos();
		boolean hayEnemigo=false;
		for(int i =0; i<ubicacionEnemigos.length && !hayEnemigo;i++) {
			if(ubicacionEnemigos[i]==direccion) {
				hayEnemigo=true;
			}
		}
		return hayEnemigo;
	}
	public boolean actualizarEnemigos() {
		return false;
		
	}
	public Consumible getConsumible(Point ubicacion) {
	  return null;	
	}
	public boolean grillaVacia() {
		return cantidadInicialDeConsumibles==0;
	}
	public void cambiarNivel(int nivel) {
		
	}
	public void enemigoComioPacman() {
		
	}
	public void resetearEnemigos() {
		
	}
	public void explotarBomba(Point ubicacion) {
		
	}
	public void pacmanComioPower() {
		
	}
	public void terminoPowerPellet() {
		
	}
}
package logica;

import Nivel.Niveles;
import entidades.Bloque;
import entidades.Personaje;
import gui.GUI;

public abstract class Logica {
	protected Boolean jugando;
	protected Personaje miPersonaje;
	protected Bloque[][] matriz;
	protected MenteEnemiga megamind;
	protected int vidas;
	protected GUI miGUI;
	protected Niveles niveles;
	
	
	//metodos
	public void reset() {
		megamind.resetearFantasmas();
    	miPersonaje.resetear();
    	miGUI.actualizar();
    	this.resetearLogicaPropia();
	}
	protected abstract void resetearLogicaPropia();
 }

package logica;

import Nivel.Nivel1;
import Nivel.NivelAbstracto;
import entidades.Personaje;
import fabricas.FabricaEntidades;
import fabricas.FabricaVampiro;
import gui.GUI;
import visitor.VisitorFantasma;
import visitor.VisitorPacman;

public class LogicaGeneral extends Logica {
	//atributos de instancia
	private int puntos;
	private int nivel;
	private GUI miGUI;
	protected FabricaEntidades miFabrica;
	protected LogicaColisiones miLogicaColisiones;

	
	//constructor
	
	public LogicaGeneral(GUI gui) {
	       vidas=3;
	       miGUI=gui;
	     }
	
	//metodos
	public void sumarPuntos(int i) {
    	puntos=puntos+i;
    	miGUI.actualizarPuntos(puntos);
    }
	public void setFabrica(String fab) {	
		this.getFabrica(fab);
	      
	}
	    
    private void getFabrica(String fab) {
    	switch(fab) {
    		case "vampiros": miFabrica=new FabricaVampiro();
	    }
    }
    
    public void cambiarNivel(int niv) {
    	
    }
    public void comenzarJuego() {
        this.nivel1();
    }
    private void nivel1() {
    	jugando=true;
    	miLogicaColisiones.jugando=true;
    	this.nivel=1;
        miPersonaje= new Personaje(miLogicaColisiones, miFabrica.getPersonaje());
        miLogicaColisiones.setPersonaje(miPersonaje);
        miGUI.addGrillaNivel1(miPersonaje.getEntidadGrafica());
        NivelAbstracto nivel1= new Nivel1(miLogicaColisiones);
        matriz=nivel1.getMatriz(miFabrica);
        miLogicaColisiones.setCantidadDots(221);
        miLogicaColisiones.setMatriz(matriz);
        megamind= new MenteEnemiga(this,miLogicaColisiones,  miFabrica.getBlinky(), miFabrica.getInky(), miFabrica.getPinky());
        miLogicaColisiones.setMenteEnemiga(megamind);
        megamind.start();  
        for(int i=1; i<=3; i++) {
        	miGUI.setVida(i, miFabrica.getVida());
        }
        miGUI.actualizar();	
    }
    public void setLogicaColisiones(LogicaColisiones logicaColisiones) {
    	miLogicaColisiones=logicaColisiones;
    }

    public void terminarJuego() {
    	
    }
    public int getNivel() {
    	return nivel;
    }
    public void reset() {
    	
    }
}

package logica;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Nivel.Niveles;
import entidades.Bomba;
import entidades.EntidadEstatica;
import entidades.Fruit;
import entidades.Invisibilidad;
import entidades.Personaje;
import entidades.Velocidad;
import fabricas.FabricaEntidades;
import fabricas.FabricaVampiro;
import gui.GUI;

public class LogicaGeneral extends Logica {
	//atributos de instancia
	private int puntos;
	private int nivel;
	protected FabricaEntidades miFabrica;
	protected LogicaColisiones miLogicaColisiones;
	private Clip musiquita;

	
	//constructor
	
	public LogicaGeneral(GUI gui) {
	       vidas=3;
	       miGUI=gui;
	       miLogicaColisiones= new LogicaColisiones(gui, this);
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
    
    public void cambiarNivel() {
    	miLogicaColisiones.reset();
    	nivel++;
    	if(nivel==4) {
    		
    	}
    	else {
    		miGUI.cambiarNivel(miFabrica.getFondo(nivel));
    		niveles.siguienteNivel(nivel);
    		matriz=niveles.getMatriz(miFabrica);
    		miLogicaColisiones.setMatriz(matriz);
    		miLogicaColisiones.graficarEntidadesDinamicas();
    		this.PararSonido();
            this.ReproducirSonido(miFabrica.getMusica(nivel));
            miGUI.actualizar();	
    	}
    	
    }
    public void comenzarJuego() {
        this.nivel1();
    }
    private void nivel1() {
    	//221
    	jugando=true;
    	miLogicaColisiones.jugando=true;
    	this.nivel=1;
    	miGUI.cambiarNivel(miFabrica.getFondo(nivel));
    	miPersonaje= new Personaje(miLogicaColisiones, miFabrica.getPersonaje());
        miLogicaColisiones.setPersonaje(miPersonaje);
        miGUI.addGrilla(miPersonaje.getEntidadGrafica());
        niveles = new Niveles(miLogicaColisiones);
        matriz=niveles.getMatriz(miFabrica);
        miLogicaColisiones.setCantidadDots(221);
        miLogicaColisiones.setMatriz(matriz);
        megamind= new MenteEnemiga(this,miLogicaColisiones,  miFabrica.getBlinky(), miFabrica.getInky(), miFabrica.getPinky());
        miLogicaColisiones.setMenteEnemiga(megamind);
        megamind.start();  
        for(int i=1; i<=3; i++) {
        	miGUI.setVida(i, miFabrica.getVida());
        }
        if(musiquita!=null) {
        	this.PararSonido();
        }
        this.ReproducirSonido(miFabrica.getMusica(1));
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
     public FabricaEntidades getFabrica() {
    	return this.miFabrica;
    }
    public void ReproducirSonido(String nombreSonido){
        try {
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
         musiquita = AudioSystem.getClip();
         musiquita.open(audioInputStream);
         musiquita.start();
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
          System.out.println("error "+ ex.getMessage());
        }
    }
    public void PararSonido() {
    	musiquita.stop();
    	musiquita=null;
    }
    public EntidadEstatica getPotion() {
 	   switch(this.nivel) {
 	   	case 1: return new Bomba(new Point((315), (375)), miFabrica.getBomba());
 	   	case 2: return new  Invisibilidad(new Point((315), (375)), miFabrica.getInvisibilidad());
 	   	case 3: return new Velocidad(new Point((315), (375)), miFabrica.getVelocidad());
 	   }
 	   return null;
    }
    public EntidadEstatica getFruit() {
  	   switch(this.nivel) {
  	   	case 1: return new Fruit(new Point((315), (375)), miFabrica.getFruit(nivel));
  	   	case 2: return new  Invisibilidad(new Point((315), (375)), miFabrica.getInvisibilidad());
  	   	case 3: return new Velocidad(new Point((315), (375)), miFabrica.getVelocidad());
  	   }
  	   return null;
     }
    protected void resetearLogicaPropia() {
    }
}

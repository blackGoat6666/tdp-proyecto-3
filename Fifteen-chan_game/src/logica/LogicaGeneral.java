package logica;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;

import entidades.EntidadEstatica;
import fabricas.FabricaEntidades;
import fabricas.FabricaMetaleros;
import fabricas.FabricaSCP;
import fabricas.FabricaVampiro;
import gui.GUI;

/**
 * La logica General es la clase encargada de controlar las cosas mas generales del juego,
 * como comenzarlo, guardar los puntos, vidas, inicializar las fabricas...
 * @author Iara
 *
 */
public class LogicaGeneral {
	//atributos de instancia
	private int puntos;
	private int nivel;
	protected FabricaEntidades miFabrica;
	protected LogicaColisiones miLogicaColisiones;
	private Clip musiquita;
	private Boolean musica;
	protected int vidas;
	protected GUI miGUI;
	protected String nombre;

	protected Boolean jugando;
    
	//constructor
	/**
	 * constructor
	 * @param gui la gui correspondiente de nuestro proyecto
	 */
	public LogicaGeneral(GUI gui) {
	       vidas=3;
	       miGUI=gui;
	       this.miLogicaColisiones= new LogicaColisiones(this);
	  }
	
	//metodos
	/**
	 * suma los puntos totales
	 * @param i entero
	 */
	public void sumarPuntos(int i) {
    	puntos=puntos+i;
    	miGUI.actualizarPuntos(puntos);
    }
	/**
	 * setea la fabrica segun el boton que se eligio
	 * @param fab String del tipo de fabrico
	 */
	public void setFabrica(String fab) {	
		this.getFabrica(fab);
	      
	}
	
	/**
	 * privado, devuelve la fabrica segun el string
	 * @param fab String
	 */
    private void getFabrica(String fab) {
    	switch(fab) {
    		case "vampiros": miFabrica=new FabricaVampiro(); break;
    		case "scp": miFabrica= new FabricaSCP(); break;
    		case "metaleros": miFabrica= new FabricaMetaleros(); break;
	    }
    }
    
    /**
     * se encarga de las cosas necesarias para cambiar de nivel.
     * (Si el nivel ya era el 3 ganamos)
     */
    public void cambiarNivel() {
    	miLogicaColisiones.reset();
    	nivel++;
    	if(nivel==4) {
    		miGUI.ganaste();
    	}
    	else {
    		miGUI.cambiarNivel(miFabrica.getFondo(nivel));
    		miLogicaColisiones.cambiarNivel(nivel);
    		
    		this.PararSonido();
            this.ReproducirSonido(miFabrica.getMusica(nivel));
            miGUI.actualizar();	
    	}
    	
    }
    /**
     * comienza el juego
     * @param jugador (string, es para el ranking)
     */
    public void comenzarJuego(String jugador) {
        nombre=jugador;
    	jugando=true;
    	this.nivel=1;
    	miGUI.cambiarNivel(miFabrica.getFondo(nivel));
    	miLogicaColisiones.nivel1();
    	
    	for(int i=1; i<=3; i++) {
        	miGUI.setVida(i, miFabrica.getVida());
        }
        if(musiquita!=null) {
        	this.PararSonido();
        }
        this.ReproducirSonido(miFabrica.getMusica(1));
        miGUI.actualizar();	
    	
    }
  
    
    /**
     * es el metodo que termina el juego 
     */

    public void terminarJuego() {
        miGUI.terminarJuego();
        this.PararSonido();

    }
    
    /**
     * nos sirve para graficar los cambios cada vez que nuestras entidades en el juego cambian 
     */
    public void actualizarGraficosJuego() {
        miGUI.actualizar();

    }
    /**
     * retorna el nivel
     * @return int
     */
    public int getNivel() {
    	return nivel;
    }
    /**
     * devuelve la fabrica (ya creada)
     * @return FabricaEntidades
     */
     public FabricaEntidades getFabrica() {
    	return this.miFabrica;
    }
    /**
     * Nos sirve para manipular el hilo del sonido, la musica indicada se comienza a reproducir
     * @param nombreSonido (String) path de la musica
     */
    public void ReproducirSonido(String nombreSonido){
        try {
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(FileSystems.getDefault().getPath("").toAbsolutePath() +nombreSonido));
         musiquita = AudioSystem.getClip();
         musiquita.open(audioInputStream);
         musiquita.start();
         this.miGUI.setIconMusiquita("/resources/Musica/musicola.png");
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
          System.out.println("error "+ ex.getMessage());
        }
        musica = true;
    }
    /**
     * le pone estop al sonido
     */
    public void PararSonido() {
    	if(musica) {
    		musiquita.stop();
    		this.miGUI.setIconMusiquita("/resources/Musica/musicolaPausada.png");
        	musiquita=null;
        	musica = false;
    	}
    	
    }
    /**
     * devuelve una entidad estatica potion
     * @return
     */
    public EntidadEstatica getPotion() {
 	   switch(this.nivel) {
 	   	case 1: return  miFabrica.getBomba( new Point( ((11)*30)+5, ((12)*30)+5 ) );
 	   	case 2:return miFabrica.getInvisibilidad(new Point( ((11)*30)+5, ((12)*30)+5 ));
 	   	case 3:return miFabrica.getVelocidad(new Point( ((11)*30)+5, ((12)*30)+5 ));
 	   }
 	   return null;
    }
    public EntidadEstatica getFruit() {
  	   return  miFabrica.getFruit(new Point( ((11)*30)+5, ((12)*30)+5 ), nivel);
  	 }
    
    public Boolean getBooleanMusica() {
    	return musica;
    }
    public void clean() {
    	this.jugando=false;
    	this.nivel=1;
    	this.puntos=0;
    	this.miGUI.actualizarPuntos(puntos);
    	this.vidas=3;
    	this.miLogicaColisiones=null;
    	this.miLogicaColisiones= new LogicaColisiones(this);
   
    }
    
    public void perderVida() {
    	miGUI.setVida(vidas, miFabrica.getVidaMuerta());
    	vidas--;
    	if(vidas==0) {
    		terminarJuego();
    	}
    	miLogicaColisiones.reset();
    }

	public void graficar(JLabel imagen) {
		miGUI.addGrilla(imagen);
		
	}
	public LogicaColisiones getLogicaColisiones() {
		return this.miLogicaColisiones;
	}
	
	public String getNombre() {
        return nombre;
    }
    public int getPuntos() {
        return puntos;
    }
}

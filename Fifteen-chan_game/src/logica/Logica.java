package logica;

import java.awt.Point;

import entidades.Bloque;
import entidades.Enemigo;
import entidades.Entidad;
import fabricas.FabricaEntidades;
import gui.GUI;
import personaje.Personaje;
import visitor.Visitor;
import visitor.VisitorFantasma;

public class Logica {
    //atributos de instancia
    private int nivel;
    private int vidas;
    private int tamanioBloqueGrafico;
    private boolean truncarPantalla;
    private String consumibleEnUso;
    private Personaje miPersonaje;
    private VisitorFantasma visitorFantasma;
    private Visitor visitorPacman;
    private Bloque[][] matriz;
    private Boolean huir;
    private GUI miGUI;
    //constructor

    //metodos
    public Logica(GUI gui, FabricaEntidades fabrica, Visitor fantasma, Visitor pacman) {
       visitorFantasma=(VisitorFantasma) fantasma;
       visitorPacman=pacman;
       huir=false;
       vidas=3;
       miGUI=gui;
    }

    public void visitarBloque(Enemigo visitante, Point direccion) {
      if(true) { //acá hay que escribir que si el ente es de clase enemigo
    	visitorFantasma.setVisitante(visitante);  
        this.obtenerBloque(direccion).accept(visitorFantasma);	  
      }
      else {
    	this.obtenerBloque(direccion).accept(visitorPacman);	  
      }
    }
    
    public void aumentarPuntos(int puntos) {

    }
    public void cambiarNivel() {

    }
    public void actualizarPantalla() {

    }
    public void comenzarJuego() {

    }
    public void terminarJuego() {

    }
    public void setModoDeJuego(String nombre) {

    }

    public void perderVida() {
    	miGUI.setVida(vidas, null);
    	
    }
   
    public void terminoTiempoConsumible() {

    }
    public void agarroBomba() {

    }
    public void agarroVelocidad() {

    }
    public void agarroPowerPellet() {
    	huir=true;

    }
    
    public boolean estoyAMitadBloque(Point ubicacion){
    	return (ubicacion.x %15==0 && ubicacion.x % 30!=0 && ubicacion.y % 15==0 && ubicacion.y % 30 !=0); 
    }
    
    public boolean huir() {
    	return huir;
    }
    
    public Personaje getPacman() {
    	return miPersonaje;
    }
    
    public Boolean colisionan() {
    	
    }
    
    private Bloque obtenerBloque(Point ubicacion) {
    	int x= (ubicacion.x -30)/30;
    	int y= (ubicacion.y-30) /30;
    	return(matriz[x][y]);
    }
    
    
}
package logica;

import java.awt.Point;

import entidades.Entidad;
import fabricas.FabricaEnemigos;
import fabricas.FabricaEntidades;
import grilla.Grilla;
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
    //constructor

    //metodos
    public Logica(FabricaEntidades fabrica, Visitor fantasma, Visitor pacman) {
       visitorFantasma=(VisitorFantasma) fantasma;
       visitorPacman=pacman;
    }

    public void visitarBloque(Entidad visitante, Point ubicacion, Point direccion) {
      if(true) { //acá hay que escribir que si el ente es de clase enemigo
    	visitorFantasma.setVisitante(visitante);  
        miGrilla.obtenerBloque(new Point(ubicacion.x+ direccion.x*(tamanioBloqueGrafico/2))).accept(visitorFantasma);	  
      }
      else {
    	miGrilla.obtenerBloque(ubicacion).accept(visitorPacman);	  
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

    }
   
    public void terminoTiempoConsumible() {

    }
    public void agarroBomba() {

    }
    public void agarroVelocidad() {

    }
    public void agarroPowerPellet() {

    }
    
    public boolean estoyAMitadBloque(Point ubicacion) {
    	return 
    }
}
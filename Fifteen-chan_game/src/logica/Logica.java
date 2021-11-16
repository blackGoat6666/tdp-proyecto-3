package logica;

import java.awt.Point;

import entidades.Bloque;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.EntidadDinamica;
import entidades.Personaje;
import fabricas.FabricaEntidades;
import fabricas.FabricaVampiro;
import gui.GUI;
import visitor.Visitor;
import visitor.VisitorFantasma;
import visitor.VisitorPacman;

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
    private int puntos;
    private MenteEnemiga megamind;
    private FabricaEntidades miFabrica;
    //constructor

    //metodos
    public Logica(GUI gui, String fabrica) {
       visitorFantasma= new VisitorFantasma();
       visitorPacman= new VisitorPacman(this);
       huir=false;
       vidas=3;
       miGUI=gui;
       megamind= new MenteEnemiga(this, null);
       this.getFabrica(fabrica);
       
    }
    
    private void getFabrica(String fab) {
    	switch(fab) {
    	 case "vampiros": miFabrica=new FabricaVampiro();
    	}
    }

    public void visitarBloque(EntidadDinamica visitante, Point direccion) {
      if(true) { //acá hay que escribir que si el ente es de clase enemigo
    	visitorFantasma.setVisitante((Enemigo) visitante);  
        this.obtenerBloque(direccion).accept(visitorFantasma);	  
      }
      else {
    	this.obtenerBloque(direccion).accept(visitorPacman);	  
      }
    }
    
    public void aumentarPuntos(int puntos) {

    }
    public void cambiarNivel(int niv) {
    	
    }
    public void actualizarPantalla() {
    	miGUI.actualizar();
    }
    public void comenzarJuego() {

    }
    public void terminarJuego() {

    }
    public void setModoDeJuego(String nombre) {

    }
    public void colisionan() {
        if(huir) {
          this.colisionanEnHuir();	  
        }
        else {
          if(this.colisionanNormal()){
          	this.perderVida();
          }
        }
      }

      private void colisionanEnHuir(){
        Bloque bloquePacman=obtenerBloque(miPersonaje.getPosicion());
        if(bloquePacman==obtenerBloque(megamind.getUbicacionBlinky())) {
      	  megamind.murioBlinky();
        }
      }

      private Boolean colisionanNormal(){
      	Bloque bloquePacman=obtenerBloque(miPersonaje.getPosicion());
      	return(bloquePacman==obtenerBloque(megamind.getUbicacionBlinky()));
      }

    public void perderVida() {
    	miGUI.setVida(vidas, null);
    	
    }
   
    public void terminoTiempoConsumible() {

    }
    public void agarroBomba() {

    }
    public void sumarPuntos(int i) {
    	puntos=puntos+1;
    }
    public void agarroVelocidad() {
    	miPersonaje.setMovimiento(15);
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
    

    
    public Bloque obtenerBloque(Point ubicacion) {
    	int x= (ubicacion.x -30)/30;
    	int y= (ubicacion.y-30) /30;
    	return(matriz[x][y]);
    }

	public void agarroInvisibilidad() {
		
		
	}

	public void pacmanPuedeMoverse() {
		miPersonaje.setMeMuevo(true);
		
	}
    
    
}
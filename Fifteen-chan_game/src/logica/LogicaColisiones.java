package logica;

import java.awt.Point;

import javax.swing.JLabel;

import entidades.Bloque;
import entidades.Bomba;
import entidades.Enemigo;
import entidades.EntidadDinamica;
import entidades.Ladrillo;
import entidades.Personaje;
import gui.GUI;
import visitor.Visitor;
import visitor.VisitorFantasma;
import visitor.VisitorPacman;

public class LogicaColisiones extends Logica {

    private VisitorFantasma visitorFantasma;
    private Visitor visitorPacman;
	protected int cantidadDots;
    private Timer miTimer;
    protected LogicaGeneral miLogicaGeneral;
    private Boolean bomba;
    private Point ubicacionBomba; 
    private boolean coloqueFruit;
    private boolean coloquePotion;

    public LogicaColisiones(GUI gui,LogicaGeneral logicaGeneral) {
       visitorFantasma= new VisitorFantasma();
       miLogicaGeneral = logicaGeneral;
       visitorPacman= new VisitorPacman(this, miLogicaGeneral);
       vidas=3;
       miGUI=gui;
       bomba=false;
       coloqueFruit=false;
       coloquePotion=false;
     }

    public void visitarBloque(EntidadDinamica visitante, Point direccion) {
      if(visitante.toString()=="Enemigo") { 
    	visitorFantasma.setVisitante((Enemigo) visitante);  
        this.obtenerBloque(direccion).accept(visitorFantasma);	  
      }
      else {
    	this.obtenerBloque(direccion).accept(visitorPacman);	  
      }
    }
    
   
    public void actualizarPantalla() {
    	miGUI.actualizar();
    }
   
    public Boolean colisionaConPacman(Point Ubicacion) {
    	return (this.obtenerBloque(Ubicacion)==this.obtenerBloque(miPersonaje.getPosicion()));
      }

    public void perderVida() {
    	miGUI.setVida(vidas, miLogicaGeneral.miFabrica.getVidaMuerta());
    	this.reset();
    	vidas--;
    	if(vidas==0) {
    		miLogicaGeneral.terminarJuego();
    	}
    }
   
    public void terminoTiempoConsumible() {

    }
    public void agarroBomba() {
    	this.bomba=true;
    }
    public void activarBomba() {
    	if(bomba){
    		this.ubicacionBomba.setLocation(getUbicacionPacman());
    		this.obtenerBloque(ubicacionBomba).setEntidadEstatica(new Bomba(ubicacionBomba,miLogicaGeneral.getFabrica().getBomba()));
    		miTimer= new Timer(this);
    		miTimer.timearBomba();
    	}
      }
      public void explotarBomba() {
    	  megamind.explotoBomba(ubicacionBomba);
    	  obtenerBloque(ubicacionBomba).eliminarEntidadEstatica();
    	  miGUI.actualizar();
      }
    
   
    public void agarroVelocidad() {
    	miPersonaje.setMovimiento(15);
    }
    public void agarroPowerPellet() {
    	megamind.setHuir();
        miTimer= new Timer(this);
    	miTimer.timearPowerPellet();
    	miTimer.start();
    }
    
    public void volverAModoNormal() {
    	megamind.fantasmasModoNormal();
    	miTimer.terminar();
    	miTimer=null;
    }
    
    public Personaje getPacman() {
    	return miPersonaje;
    }
    

    
    public Bloque obtenerBloque(Point ubicacion) {
    	int x=(ubicacion.x)/30;
    	int y=(ubicacion.y)/30;
    	if(x==0 || y==0 || x==21 || y==21) {
    		return new Bloque(new Ladrillo(null));
    	}
    	return(matriz[x-1][y-1]);
    }
    public Boolean mismoBloque(Point ubicacion1, Point ubicacion2) {
		return (obtenerBloque(ubicacion1)==obtenerBloque(ubicacion2));
	}

    public void agarroInvisibilidad() {
		megamind.setPacmanInvisible();
		miTimer.timearInvisibilidad();
		
	}
	
	public Boolean jugando() {
		return jugando;
	}

	public void pacmanPuedeMoverse() {
		miPersonaje.setMeMuevo(true);
		
	}
	
	public void moverPacman(Point direccion) {
		miPersonaje.setDireccion(direccion);
		miPersonaje.mover();
	}

	public void pacmanNoPuedeMoverse() {
		miPersonaje.setMeMuevo(false);
	}
   public void graficar(JLabel imagen) {
	   miGUI.addGrilla(imagen);
	   
   }
   public void graficarEntidadesDinamicas() {
	   megamind.graficarFantasmitas();
	   this.graficar(this.miPersonaje.getEntidadGrafica());
   }
   
   public Point getUbicacionPacman() {
	   return miPersonaje.getPosicion();
   }
   
   public Point getDireccionPacman() {
	   return miPersonaje.getDireccion();
   }
   
   public Boolean llegoAGate(Point Ubicacion) {
	   Bloque comparar=this.obtenerBloque(Ubicacion);
	   return  (comparar==matriz[10][10] ||comparar==matriz[9][10] ||comparar==matriz[11][10]);
   }
   public Boolean salioDeGate(Point Ubicacion) {
	   Bloque comparar=this.obtenerBloque(Ubicacion);
	   return  ( comparar==matriz[9][8] || comparar==matriz[11][8] ||  comparar==matriz[10][8]);
   }
   public void setLogicaGeneral(LogicaGeneral logicaGeneral) {
	   miLogicaGeneral = logicaGeneral;
   }
   public void setPersonaje(Personaje personaje) {
	   miPersonaje=personaje;
   }
   public void setMatriz(Bloque[][] matrizz) {
	   matriz=matrizz;
   }
   public void setMenteEnemiga(MenteEnemiga menteEnemiga) {
	   megamind=menteEnemiga;
   }
   public void setCantidadDots(int cantidad) {
	   cantidadDots=cantidad;
   }
   public void restarDots() {
	   cantidadDots--;
	   if(!coloquePotion && this.cantidadDots<=100 && !(matriz[10][12].tengoEntidadEstatica()) ) {
		   matriz[10][12].setEntidadEstatica(miLogicaGeneral.getPotion());
		   this.coloquePotion=true;
	   }
	   if(!coloqueFruit && this.cantidadDots<=30 && !(matriz[10][12].tengoEntidadEstatica())) {
		   matriz[10][12].setEntidadEstatica(miLogicaGeneral.getFruit());
		   this.coloqueFruit=true;
	   }
	   if(this.cantidadDots==0) {
			miLogicaGeneral.cambiarNivel();
	    }
   }
   
   protected void resetearLogicaPropia() {
	   bomba=false;
       coloqueFruit=false;
       coloquePotion=false;
   }
    
   
 
}
package logica;

import java.awt.Point;

import javax.swing.JLabel;

import Nivel.Niveles;
import entidades.Bloque;
import entidades.EntidadEstatica;
import entidades.EntidadGraficaEstatica;
import entidades.Ladrillo;
import entidadesDinamicas.Enemigo;
import entidadesDinamicas.EntidadDinamica;
import entidadesDinamicas.Personaje;
import visitor.Visitor;
import visitor.VisitorFantasma;
import visitor.VisitorPacman;

public class LogicaColisiones {

    protected int cantidadDots;
    private Timer miTimer;
    protected LogicaGeneral miLogicaGeneral;
    private Boolean bomba;
    private Point ubicacionBomba; 
    private boolean coloqueFruit;
    private boolean coloquePotion;
    private EntidadGraficaEstatica bombasticeo;
    protected Bloque[][] matriz;
	protected MenteEnemiga megamind;
	protected Niveles niveles;

	protected Personaje miPersonaje;
    

    public LogicaColisiones(LogicaGeneral logicaGeneral) {
       miLogicaGeneral = logicaGeneral;
       bomba=false;
       coloqueFruit=false;
       coloquePotion=false;
       ubicacionBomba=new Point(0,0);
     }

    public void visitarBloque(EntidadDinamica visitante, Point direccion) {
      this.obtenerBloque(direccion).accept(visitante.getVisitor());	  
    }
    
   
    public void actualizarPantalla() {
    	miLogicaGeneral.actualizarGraficosJuego();
    }
   
    public Boolean colisionaConPacman(Point Ubicacion) {
    	return (this.obtenerBloque(Ubicacion)==this.obtenerBloque(miPersonaje.getPosicion()));
      }

    
   
    
    public void agarroBomba() {
    	this.bomba=true;
    }
    public void activarBomba() {
    	if(bomba){
    		this.ubicacionBomba.setLocation(this.miPersonaje.getPosicion());
    		bombasticeo=miLogicaGeneral.getFabrica().getBomba(ubicacionBomba).getEntidadGrafica();
    		bombasticeo.setLocation(ubicacionBomba);
    		this.graficar(bombasticeo);
    		miLogicaGeneral.actualizarGraficosJuego();
    		bomba=false;
    		miTimer= new Timer(this);
    		miTimer.start();
    		miTimer.timearBomba();
         }
      }
      public void explotarBomba() {
    	  megamind.explotoBomba(ubicacionBomba);
    	  this.setModoPacman("normal");
    	  miTimer=null;
    	  bombasticeo.setIcon(null);
    	  bombasticeo=null;
    	  miLogicaGeneral.actualizarGraficosJuego();
    	  bomba=false;
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
    	miPersonaje.setModo("normal");
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
		miTimer= new Timer(this);
		miTimer.start();
		miTimer.timearInvisibilidad();
		
	}
	
	public Boolean jugando() {
		return miLogicaGeneral.jugando;
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
	   miLogicaGeneral.graficar(imagen);
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
	   return  (comparar==matriz[10][9] ||comparar==matriz[9][9] ||comparar==matriz[11][9]);
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
	   if(!coloquePotion && this.cantidadDots<=190 && !(matriz[10][11].tengoEntidadEstatica()) ) {
		   EntidadEstatica coloco=miLogicaGeneral.getPotion();
		   matriz[10][11].setEntidadEstatica(coloco);
		   coloco.getEntidadGrafica().setLocation(coloco.getPosicion().x, coloco.getPosicion().y);
		   this.graficar(coloco.getEntidadGrafica());
		   this.coloquePotion=true;
	   }
	   if(!coloqueFruit && this.cantidadDots<=30 && !(matriz[10][11].tengoEntidadEstatica())) {
		   EntidadEstatica coloco=miLogicaGeneral.getFruit();
		   matriz[10][11].setEntidadEstatica(coloco);
		   this.graficar(coloco.getEntidadGrafica());
		   this.coloqueFruit=true; 
	   }
	   if(this.cantidadDots==0) {
			miLogicaGeneral.cambiarNivel();
	    }
   }
   
   public void resetearLogicaPropia() {
	   bomba=false;
       coloqueFruit=false;
       coloquePotion=false;
   }
   
   public void setModoPacman(String mode) {
	   this.miPersonaje.setModo(mode);
   }
    

   
   public void reset() {
		megamind.resetearFantasmas();
		miPersonaje.resetear();
		miLogicaGeneral.actualizarGraficosJuego();
		this.resetearLogicaPropia();
	}

   public void pacmanMurio() {
	   miLogicaGeneral.perderVida();
   }
   public void cambiarVelocidad() {
	   megamind.cambiarVelocidad();
   }
   public void nivel1() {
	   miPersonaje= miLogicaGeneral.getFabrica().getPersonaje(this);
       miLogicaGeneral.graficar(miPersonaje.getEntidadGrafica());
	   megamind= new MenteEnemiga(this,  miLogicaGeneral.getFabrica().getBlinky(), miLogicaGeneral.getFabrica().getInky(), miLogicaGeneral.getFabrica().getPinky(), miLogicaGeneral.getFabrica().getClyde());
       niveles = new Niveles(this);
       matriz=niveles.getMatriz(miLogicaGeneral.getFabrica());
       cantidadDots=221;
       megamind.start();
   }

   public void sumarPuntos(int i) {
	   miLogicaGeneral.sumarPuntos(i);
   }
   public void cambiarNivel(int nivel) {
	   niveles.siguienteNivel(nivel);
	   matriz=niveles.getMatriz(miLogicaGeneral.getFabrica());
	   graficarEntidadesDinamicas();
	   resetearLogicaPropia();
	   megamind.cambiarVelocidad();
	   cantidadDots = niveles.getDots();
   }

 
 
}
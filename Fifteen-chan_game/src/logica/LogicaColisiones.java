package logica;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Nivel.Nivel1;
import Nivel.NivelAbstracto;
import entidades.Blinky;
import entidades.Bloque;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.EntidadDinamica;
import entidades.Ladrillo;
import entidades.Personaje;
import fabricas.FabricaEntidades;
import fabricas.FabricaVampiro;
import gui.GUI;
import visitor.Visitor;
import visitor.VisitorFantasma;
import visitor.VisitorPacman;

public class LogicaColisiones extends Logica {
    //atributos de instancia
    //private int nivel;
    
    private boolean truncarPantalla;
    
    private VisitorFantasma visitorFantasma;
    private Visitor visitorPacman;
	protected int cantidadDots;
    private GUI miGUI;
    //private int puntos;
    
    //private FabricaEntidades miFabrica;
    
    private Timer miTimer;
    protected LogicaGeneral miLogicaGeneral;
    //constructor

    //metodos
    public LogicaColisiones(GUI gui,LogicaGeneral logicaGeneral) {
       visitorFantasma= new VisitorFantasma();
       miLogicaGeneral = logicaGeneral;
       visitorPacman= new VisitorPacman(this, miLogicaGeneral);
       vidas=3;
       miGUI=gui;
      
     }
    
   /* public void setFabrica(String fab) {
    	this.getFabrica(fab);
      
    }
    
    private void getFabrica(String fab) {
    	switch(fab) {
    	 case "vampiros": miFabrica=new FabricaVampiro();
    	}
    }*/

    public void visitarBloque(EntidadDinamica visitante, Point direccion) {
      if(visitante.toString()=="Enemigo") { 
    	visitorFantasma.setVisitante((Enemigo) visitante);  
        this.obtenerBloque(direccion).accept(visitorFantasma);	  
      }
      else {
    	this.obtenerBloque(direccion).accept(visitorPacman);	  
      }
    }
    
    /*public void cambiarNivel(int niv) {
    	
    }*/
    public void actualizarPantalla() {
    	miGUI.actualizar();
    }
    /*public void comenzarJuego() {
        this.nivel1();
      }*/
    
    /*private void nivel1() {
    	jugando=true;
    	this.nivel=1;
        miPersonaje= new Personaje(this, miFabrica.getPersonaje());
        miGUI.addGrillaNivel1(miPersonaje.getEntidadGrafica());
        NivelAbstracto nivel1= new Nivel1(this);
        matriz=nivel1.getMatriz(miFabrica);
        megamind= new MenteEnemiga(this,  miFabrica.getBlinky(), miFabrica.getInky(), miFabrica.getPinky());
        megamind.start();  
        for(int i=1; i<=3; i++) {
        	miGUI.setVida(i, miFabrica.getVida());
        }
        miGUI.actualizar();	
    }*/
    /*public void terminarJuego() {

    }*/
    public Boolean colisionaConPacman(Point Ubicacion) {
    	return (this.obtenerBloque(Ubicacion)==this.obtenerBloque(miPersonaje.getPosicion()));
      }

      

    public void perderVida() {
    	miGUI.setVida(vidas, miLogicaGeneral.miFabrica.getVidaMuerta());
    	megamind.resetearFantasmas();
    	miPersonaje.resetear();
    	miGUI.actualizar();
    	vidas--;
    	if(vidas==0) {
    		miLogicaGeneral.terminarJuego();
    	}
    }
   
    public void terminoTiempoConsumible() {

    }
    public void agarroBomba() {

    }
    /*public void sumarPuntos(int i) {
    	puntos=puntos+i;
    	miGUI.actualizarPuntos(puntos);
    }*/
    
   
    public void agarroVelocidad() {
    	miPersonaje.setMovimiento(15);
    }
    public void agarroPowerPellet() {
    	megamind.setHuir(true);
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
	   miGUI.addGrillaNivel1(imagen);
	   
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
   }
   public int getCantidadDots() {
	   return cantidadDots;
   }
   public boolean noQuedanDots() {
	   return (this.getCantidadDots()==0);
   }
}
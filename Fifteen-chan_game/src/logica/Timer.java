package logica;

import logica.LogicaColisiones;

public class Timer extends Thread {
    // atributos
   
	private LogicaColisiones miLogicaColisiones;
    boolean correr;
    private String timear;
    private int vueltas;
    //constructor
    
    public Timer(LogicaColisiones log) {
      miLogicaColisiones=log;
      correr=true;
      timear=null;
      vueltas=0;
    }

    
    //metodos
    
    
    public void run() {
      while(correr) {
        try {
        	
         if(timear!=null && vueltas==1) {
          	  this.terminoElTiempo();	
          }
         vueltas++;
          Thread.sleep(this.getTiempoAMimir());
        }
        catch(InterruptedException e) {
             e.printStackTrace();
        }
      }
    }
    public void terminar(){
      correr=false;
    }

    //consultas

    
    private int getTiempoAMimir() {
    	if(timear!=null) {
    		switch(timear) {
    			case "Power Pellet": return 10000;
    			case "Bomba": return 3000;
    			case "Invisibilidad": return 10000;
    		}
    	}
    	return 1000;
    }
    
    public void timearBomba() {
    	timear="Bomba";
    }
    
    private void terminoElTiempo() {
    	if(timear=="Bomba") {
    		miLogicaColisiones.explotarBomba();
    		timear=null;
    		this.terminar();
    	}
    	else {
    		this.terminar();
    		miLogicaColisiones.volverAModoNormal();
    	}
     }


	public void timearPowerPellet() {
		this.timear="Power Pellet";
	}
	public void timearInvisibilidad() {
		this.timear="Invisibilidad";
	}

}
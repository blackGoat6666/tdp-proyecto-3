package logica;

import logica.Logica;

public class Timer extends Thread {
    // atributos
   
	private Logica miLogica;
    boolean correr;
    private String timear;
    private int vueltas;
    //constructor
    
    public Timer(Logica log) {
      miLogica=log;
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
    			case "Power Pellet": return 6000;
    	
    		}
    	}
    	return Thread.MIN_PRIORITY;
    }
   
    
    public void timearPowerPellet() {
    	timear="Power Pellet";
    }
    
    private void terminoElTiempo() {
    	if(timear=="Bomba") {
    		
    	}
    	else {
    		timear=null;
    		miLogica.volverAModoNormal();
    		this.terminar();
    	}
    }

}
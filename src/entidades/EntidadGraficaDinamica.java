package entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import gui.GUI;

public class EntidadGraficaDinamica extends EntidadGrafica{
	private String [] modoNormal;
	private String [] modoPowerPellet;
	private String [] modoVelocidad;
	private String [] modoInvisibilidad;
	private String modo;
	
	

	public EntidadGraficaDinamica(String url []) {
		super(url[0]);
		this.setSize(60,60);
		modoNormal= new String[4];
		modoPowerPellet= new String[4];
		modoVelocidad= new String[4];
		modoInvisibilidad= new String[4];
		for (int i = 0; i < 4; i++) {
			modoNormal [i] = url [i];
		}
		for (int i = 0; i < 4; i++) {
			modoPowerPellet [i] = url [i+4];
		}
		for (int i = 0; i < 4; i++) {
			modoVelocidad [i] = url [i+8];
		}
		for (int i = 0; i < 4; i++) {
			modoInvisibilidad [i] = url [i+12];
		}
		modo = "normal";
		this.setIcon(new ImageIcon(GUI.class.getResource(modoNormal[0])));
	}
	
	
	public void setAdelante() {
		switch (modo) {
		     case "normal":
		    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoNormal[0])));
		    	 break;
		     case "powerPellet":
		    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoPowerPellet[0])));
		    	 break;
		     case "velocidad":
		    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoVelocidad[0])));
		    	 break;
		     case "invisibilidad":
		    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoInvisibilidad[0])));
		    	 break;
		}
	}
	
    public void setAtras() {
    	switch (modo) {
	     case "normal":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoNormal[1])));
	    	 break;
	     case "powerPellet":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoPowerPellet[1])));
	    	 break;
	     case "velocidad":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoVelocidad[1])));
	    	 break;
	     case "invisibilidad":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoInvisibilidad[1])));
	    	 break;
	}
		
	}

    public void setIzquierda() {
    	switch (modo) {
	     case "normal":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoNormal[2])));
	    	 break;
	     case "powerPellet":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoPowerPellet[2])));
	    	 break;
	     case "velocidad":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoVelocidad[2])));
	    	 break;
	     case "invisibilidad":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoInvisibilidad[2])));
	    	 break;
	}
		
	}
    
    
    public void setDerecha() {
    	switch (modo) {
	     case "normal":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoNormal[3])));
	    	 break;
	     case "powerPellet":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoPowerPellet[3])));
	    	 break;
	     case "velocidad":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoVelocidad[3])));
	    	 break;
	     case "invisibilidad":
	    	 this.setIcon(new ImageIcon(GUI.class.getResource(modoInvisibilidad[3])));
	    	 break;
    	}
	}
    public void setModo(String estado) {
    	modo=estado;
    }
}


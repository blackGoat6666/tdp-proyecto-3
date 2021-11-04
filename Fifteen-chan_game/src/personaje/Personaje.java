package personaje;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logica.Logica;

public class Personaje extends JLabel {
	//atributos de instancia
	private String miImagen;
	private String conBomba;
	private String invisibilidad;
	//constructor
	public Personaje(String imagen,String bomba, String invisible) {
	  miImagen=imagen;
	  conBomba=bomba;
	  invisibilidad=invisible;
	  Point ubicacion=this.getLocation();
	  ubicacion.setLocation(306, 369);
	  this.setIcon(new ImageIcon(getClass().getResource(miImagen)));
	}
	public void volverModoNormal() {
	  this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(miImagen)));  	
	}
	public void setBomba() {
      this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(conBomba)));	
	}
		
	public void setInvisibilidad() {
	  this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(invisibilidad)));	
	}
	public Point getPosicion() {
	  return this.getLocation();
	}
}
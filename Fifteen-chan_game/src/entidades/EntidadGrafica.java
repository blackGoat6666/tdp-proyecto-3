package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.GUI;

public class EntidadGrafica extends JLabel {
	public EntidadGrafica (String url) {
		super(".");
		this.setText(null);
		ImageIcon imagen=new ImageIcon(getClass().getResource(url), "imagen de la entidad");
		this.setIcon(imagen);
	}

}

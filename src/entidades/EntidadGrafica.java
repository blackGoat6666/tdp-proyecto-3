package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.GUI;

public class EntidadGrafica extends JLabel {
	public EntidadGrafica (String url) {
		super(".");
		this.setText(null);
		this.setIcon(new ImageIcon(GUI.class.getResource(url)));
		this.setSize(30, 30);
	}

}

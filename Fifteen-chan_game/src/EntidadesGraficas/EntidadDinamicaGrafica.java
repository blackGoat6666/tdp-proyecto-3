package EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.GUI;

public class EntidadDinamicaGrafica extends JLabel {
	public EntidadDinamicaGrafica (String url) {
		super();
		this.setText(null);
		this.setIcon(new ImageIcon(GUI.class.getResource(url)));
	}

}

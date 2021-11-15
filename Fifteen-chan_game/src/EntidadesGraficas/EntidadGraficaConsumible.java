package EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.GUI;

public class EntidadGraficaConsumible extends JLabel {
	public EntidadGraficaConsumible (String url) {
		super();
		this.setText(null);
		this.setIcon(new ImageIcon(GUI.class.getResource(url)));
	}

}

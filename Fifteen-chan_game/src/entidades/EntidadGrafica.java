package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase que nos sirve para representar graficamente a una entidad, extiende a JLabel
 * @author Iara
 *
 */
public class EntidadGrafica extends JLabel {
	/**
	 * Contructor, crea un JLabel que tiene una imagen que pasamos por url
	 * @param url direccion de la imagen
	 */
	public EntidadGrafica (String url) {
		super(".");
		this.setText(null);
		ImageIcon imagen=new ImageIcon(getClass().getResource(url), "imagen de la entidad");
		this.setIcon(imagen);
	}

}

package entidades;
/**
 * Clase que representa a una entidad grafica de una entidad estatica
 * @author Iara
 *
 */
public class EntidadGraficaEstatica extends EntidadGrafica {

	/**
	 * constructor
	 * @param url de la imagen
	 */
	public EntidadGraficaEstatica(String url) {
		super(url);
		this.setSize(30,30);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * metodo que elimina el objeto
	 */
	public void borrar() {
		this.setIcon(null);
	}
	
	/**
	 * Metodo que retorna la imagen correspondiente
	 * @return EntidadGrafica
	 */
	public EntidadGrafica getEntidadGrafica() {
		return this;
	}

}

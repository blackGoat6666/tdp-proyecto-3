package entidades;

/**
 * La entidad estatica en una especificacion de las entidades que no cambian de posicion con
 * el tiempo
 * @author Iara
 *
 */

public abstract class EntidadEstatica extends Entidad{
	protected EntidadGraficaEstatica miImagen;
	
	/**
	 * Constructor de la entidadEstatica
	 * @param imagen representa a la entidad graficamente
	 */
	public EntidadEstatica(EntidadGraficaEstatica imagen) {
		this.miImagen=imagen;
		
	}
	
	/**
	 * metodo que nos sirve para indicar que este objeto de clase entidad ya no existe
	 * 
	 */
	public void morir() {
		miImagen.borrar();
	}
	
	/**
	 * metodo que devuelve la representacion grafica de la entidadEstatica
	 * @return EntidadGraficaEstatica miImagen
	 */
	public EntidadGraficaEstatica getEntidadGrafica() {
		return miImagen;
	}
}

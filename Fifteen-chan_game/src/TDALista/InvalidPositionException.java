package TDALista;
/**
 * Excepcion que lanza la lista al operar con una posicion invalida.
 * @author Dominguez,Chanqueo.
 *
 */
public class InvalidPositionException extends Exception {
	/**
	* Instancia una nueva InvalidPositionException, con un mensaje que recibe como parametro.
	* @param msg El mensaje que va a mostrar la excepcion.
	*/
	public InvalidPositionException (String msg) {
		super(msg);
	}
}

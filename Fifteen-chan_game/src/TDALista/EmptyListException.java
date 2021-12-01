package TDALista;
/**
 * Excepcion que lanza la lista al intentar operar con una lista vacia.
 * @author Dominguez,Chanqueo.
 *
 */
public class EmptyListException extends Exception {
	/**
	* Instancia una nueva EmptyListException, con un mensaje que recibe como parametro.
	* @param msg El mensaje que va a mostrar la excepcion.
	*/
	public EmptyListException (String msg) {
		super(msg);
	}
}

package TDALista;
/**
 * Excepcion que lanzan las estructuras de datos cuando se intenta violar una frontera. Como lo puede ser acceder a un nodo inexistente.
 * @author Dominguez,Chanqueo.
 *
 */
public class BoundaryViolationException extends Exception {
	/**
	* Instancia una nueva BoundaryViolationException, con un mensaje que recibe como parametro.
	* @param msg El mensaje que va a mostrar la excepcion.
	*/
	public BoundaryViolationException (String msg) {
		super(msg);
	}
}

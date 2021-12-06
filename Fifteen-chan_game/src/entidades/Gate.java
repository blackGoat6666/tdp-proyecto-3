package entidades;

import visitor.Visitor;

/**
 * Entidad que representa a una porcion de la matriz, la cual el personaje no puede pasar, y de donde pueden aparecer 
 * los enemigos.
 * @author Iara
 *
 */
public class Gate extends EntidadEstatica{

	/**
	 * Constructor del gate
	 * @param imagen representacion grafica de esta entidad 
	 */
	public Gate(EntidadGraficaEstatica imagen) {
		super(imagen);
	}
	
	
	/**
	 * Un metodo que acepta el visitor (patron de diseño)
	 */
	public void accept(Visitor v) {
		v.visitGate();
	}

}

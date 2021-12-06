package entidades;

import visitor.Visitor;

/**
 * entidad que representa una posicion de la matriz donde no puede pasar ni el personaje
 * ni los enemigos.
 * @author Iara
 *
 */
public class Ladrillo extends EntidadEstatica{

	/**
	 * Constructor del ladrillo
	 * @param imagen
	 */
	public Ladrillo(EntidadGraficaEstatica imagen) {
		super(imagen);
	}
	
	/**
	 * Un metodo que acepta el visitor (patron de diseño)
	 */
	public void accept(Visitor v) {
		v.visitLadrillo();
	}

}

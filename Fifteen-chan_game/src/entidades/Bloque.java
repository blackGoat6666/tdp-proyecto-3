package entidades;
import visitor.Visitor;

/**
 * Un bloque es una clase que nos sirve para representar una seccion de espacio, puede 
 * tener una entidad estatica o no.
 * @author Iara
 *
 */
public class Bloque{

	private EntidadEstatica miEntidadEstatica;
	
	/**
	 * Constructor
	 * @param ente, una entidad estatica
	 */
	public Bloque(EntidadEstatica ente) {
		miEntidadEstatica=ente;  	
	}
	
	
	/**
	 * Un metodo que acepta el visitor (patron de diseño)
	 */
	public void accept(Visitor visitante) {
		if(miEntidadEstatica!=null) {
			miEntidadEstatica.accept(visitante);
		}
		else {
			visitante.visitBloqueVacio();
		}
	}
	
	/**
	 * podemos setear una entidad estatica con este metodo
	 * @param ente entidad estatica
	 */
	public void setEntidadEstatica(EntidadEstatica ente) {
		miEntidadEstatica=ente;
	}
	
	/**
	 * Metodo que nos dice si en el bloque hay una entidad estatica o no
	 * @return boolean
	 */
	public Boolean tengoEntidadEstatica(){
		return (miEntidadEstatica!=null);	
	}

	/**
	 * metodo que nos sirve para eliminar la entidad estatica.
	 */
	public void eliminarEntidadEstatica() {
		if(miEntidadEstatica!=null) {
			miEntidadEstatica.morir();
			miEntidadEstatica=null;
		}
		
	}
	

	
}
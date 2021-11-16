package entidades;
import java.awt.Point;

import entidades.Entidad;
import entidades.EntidadDinamica;
import entidades.EntidadEstatica;
import visitor.Visitor;

public class Bloque{

	private Point ubicacion;
	private EntidadEstatica miEntidadEstatica;
	private EntidadDinamica miEntidadDinamica;
	
	public Bloque(EntidadEstatica ente) {
		miEntidadEstatica=ente;  	
	}
	
	public void accept(Visitor visitante) {
		if(miEntidadEstatica!=null) {
			miEntidadEstatica.accept(visitante);
		}
		else {
			visitante.visitBloqueVacio();
		}
		if(miEntidadDinamica!=null) {
			miEntidadDinamica.accept(visitante);
		}
	}
	
	public void setEntidadDinamica(Entidad ente) {
		miEntidadDinamica=(EntidadDinamica) ente;
	}
	public void eliminarEntidadEstatica() {
		miEntidadEstatica=null;
	}
	
	public Boolean tengoEntidadDinamica(){
	  return (miEntidadDinamica!=null);	
	}
	
	
	
}
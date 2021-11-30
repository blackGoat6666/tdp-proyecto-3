package entidades;
import java.awt.Point;

import javax.swing.JFrame;

import entidades.Entidad;
import entidades.EntidadEstatica;
import entidadesDinamicas.EntidadDinamica;
import visitor.Visitor;

public class Bloque{

	private EntidadEstatica miEntidadEstatica;
	
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
	}
	
	public void setEntidadEstatica(EntidadEstatica ente) {
		miEntidadEstatica=ente;
	}
	
	public Boolean tengoEntidadEstatica(){
		return (miEntidadEstatica!=null);	
	}

	public void eliminarEntidadEstatica() {
		if(miEntidadEstatica!=null) {
			miEntidadEstatica.morir();
			miEntidadEstatica=null;
		}
		
	}
	

	
}
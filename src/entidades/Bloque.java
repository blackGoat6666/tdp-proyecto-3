package entidades;
import java.awt.Point;

import javax.swing.JFrame;

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
	
	public Boolean tengoEntidadDinamica(){
	  return (miEntidadDinamica!=null);	
	}

	public void eliminarEntidadEstatica() {
		if(miEntidadEstatica!=null) {
			miEntidadEstatica.morir();
			miEntidadEstatica=null;
		}
		
	}
	
	public void graficar(JFrame juego) {
		if(miEntidadEstatica!=null) {
			juego.add(this.miEntidadEstatica.getEntidadGrafica());
		}
	}
	
	
	
}
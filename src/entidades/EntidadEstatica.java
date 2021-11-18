package entidades;

public abstract class EntidadEstatica extends Entidad{
	protected EntidadGraficaEstatica miImagen;
	
	public EntidadEstatica(EntidadGraficaEstatica imagen) {
		this.miImagen=imagen;
	}
	
	public void morir() {
		miImagen.borrar();
	}
	
	public EntidadGraficaEstatica getEntidadGrafica() {
		return miImagen;
	}
}

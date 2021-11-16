package entidades;

public abstract class EntidadEstatica extends Entidad{
	protected EntidadGraficaEstatica miImagen;
	
	public void morir() {
		miImagen.borrar();
	}
}

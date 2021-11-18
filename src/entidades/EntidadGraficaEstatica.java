package entidades;

public class EntidadGraficaEstatica extends EntidadGrafica {

	public EntidadGraficaEstatica(String url) {
		super(url);
		this.setSize(30,30);
		// TODO Auto-generated constructor stub
	}
	public void borrar() {
		this.setIcon(null);
	}
	public EntidadGrafica getEntidadGrafica() {
		return this;
	}

}

package entidades;

public class EntidadGraficaEstatica extends EntidadGrafica {

	public EntidadGraficaEstatica(String url) {
		super(url);
		// TODO Auto-generated constructor stub
	}
	public void borrar() {
		this.setIcon(null);
	}

}

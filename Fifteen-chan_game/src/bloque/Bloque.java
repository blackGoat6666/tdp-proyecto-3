package bloque;

public abstract class Bloque {
	//atributos de instancia
	protected int x;
	protected int y;
	protected String imagen;
	//constructor
	public Bloque(int miX, int miY) {
		x=miX;
		y=miY;
	}
	//metodos
	//comandos
	public void setImagen(String milcon) {
		imagen = milcon;
	}
	//consultas
	public abstract boolean esGate();
	public abstract boolean esLadrillo();
	public int getX(){
		return x;
	}
	public int getY() {
		return y;
	}
}

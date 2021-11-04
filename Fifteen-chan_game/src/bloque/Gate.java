package bloque;

public class Gate extends Bloque {
	public Gate(int miX, int miY) {
		super(miX, miY);
		imagen="ruta";
	}
	
	
	public boolean esGate() {
		Class<? extends Bloque> c = this.getClass();
		return (c.getName()=="Gate");
	}
	
	
	public boolean esLadrillo() {
		Class<? extends Bloque> c = this.getClass();
		return (c.getName()=="Ladrillo");
	}
}

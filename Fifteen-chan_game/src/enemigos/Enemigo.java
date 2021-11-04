package enemigos;
import java.awt.Point;
import javax.swing.JLabel;
public abstract class Enemigo extends JLabel {
  protected int preferenciaX;
  protected int preferenciaY;
  protected Point posicionObjetivo;
  protected int ultimaDireccion;
  protected int intentos;
  protected int tamanioBloqueGrafico;
  protected String imagenPrincipal;
  protected String imagenHuir;
  protected String imagenComido;
	
	
}
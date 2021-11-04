package fabricas;
import enemigos.Enemigo;
import personaje.Personaje;
public class FabricaVampiro implements FabricaEnemigos {
	private Personaje pacman;
	
	
	public FabricaVampiro(){
	  pacman=new Personaje("/Images/vampiroadelantemoviendose.gif", "/Images/vampiro.png", "/Images/vampiro.png");
	}
	public Enemigo getBlinky() {
		// TODO Auto-generated method stub
		return null;
	}
	public Enemigo getInky() {
		// TODO Auto-generated method stub
		return null;
	}
	public Enemigo getPinky() {
		// TODO Auto-generated method stub
		return null;
	}
	public Enemigo getClide() {
		// TODO Auto-generated method stub
		return null;
	}
	public Personaje getPacman() {
	  	
		return pacman;
	}
}

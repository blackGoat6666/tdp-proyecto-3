package visitor;

import entidades.Bloque;
import entidades.Dot;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.Fruit;
import entidades.Personaje;
import logica.Logica;

public class VisitorPacman implements Visitor {
	protected Personaje visitante ;
	protected Logica miLogica;
	
	public VisitorPacman(Logica logi) {
		miLogica=logi;
	}

	@Override
	public void visitBloque(Bloque casillero) {
		// TODO Auto-generated method stub
		
	}

	public void visitDot(Dot dot) {
		miLogica.sumarPuntos(dot.getPuntaje());
		
	}

	@Override
	public void visitFruit(Fruit fru) {
		miLogica.sumarPuntos(fru.getPuntaje());
		
	}

	@Override
	public void visitPowerPellet() {
		miLogica.agarroPowerPellet();
		
	}

	@Override
	public void visitBomba() {
		miLogica.agarroBomba();
		
	}

	@Override
	public void visitInvisibilidad() {
		miLogica.agarroInvisibilidad();
		
	}

	@Override
	public void visitVelocidad() {
		miLogica.agarroVelocidad();
		
	}

	
	@Override
	public void visitLadrillo() {
		miLogica.();
		
	}

	@Override
	public void visitGate() {
		miLogica.colisionan();
		
	}




	@Override
	public void visitBloqueVacio() {
		// TODO Auto-generated method stub
		
	}

}

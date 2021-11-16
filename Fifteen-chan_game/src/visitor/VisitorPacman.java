package visitor;

import entidades.Bloque;
import entidades.Enemigo;
import entidades.Entidad;
import logica.Logica;

public class VisitorPacman implements Visitor {
	protected Logica miLogica;
	
	public VisitorPacman(Logica logi) {
		miLogica=logi;
	}

	@Override
	public void visitBloque(Bloque casillero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitDot() {
	 
		
	}

	@Override
	public void visitFruit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitPowerPellet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitBomba() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitInvisibilidad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitVelocidad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitEnemigo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLadrillo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitGate() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void visitPacman() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitBloqueVacio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitFantasma(Enemigo fantasma) {
		if( miLogica.huir() ) {
			fantasma.morir();
		}
		else {
			miLogica.perderVida();
		}
		
	}

}
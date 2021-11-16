package visitor;

import entidades.Bloque;
import entidades.Enemigo;
import entidades.Entidad;
import logica.Logica;

public class VisitorFantasma implements Visitor{
	private Entidad visitante;
	protected Logica miLogica;
	
	
	public void setVisitante(Entidad ente) {
		visitante=ente;
	}
	
	public void visitPacman() {
		if(miLogica.huir()) {
			visitante.morir();
		}
		else {
			miLogica.perderVida();
		}
	}
		
    public void visitBloque(Bloque casillero) {
	  casillero.accept(this);
		
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
	public void visitBloqueVacio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitFantasma(Enemigo fantasma) {
		
	}

}

package visitor;

import entidades.Entidad;
import grilla.Bloque;

public class VisitorFantasma implements Visitor{
	private Entidad visitante;
	
	public void setVisitante(Entidad ente) {
		visitante=ente;
	}
	
	public void visitFantasma() {
		
	}
	 
	public void visitPacman() {
		
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

}

package visitor;

import entidades.Bloque;
import entidades.Enemigo;
import entidades.Entidad;
import logica.Logica;

public class VisitorFantasma implements Visitor{
	private Enemigo visitante;
	protected Logica miLogica;
	
	
	public void setVisitante(Enemigo ente) {
		visitante=ente;
	}
	
	public void visitBloque(Bloque casillero) {
	  casillero.accept(this);
		
	}

	@Override
	public void visitDot() {
		visitante.seMovio();
	}

	@Override
	public void visitFruit() {
		visitante.seMovio();
		
	}

	@Override
	public void visitPowerPellet() {
		visitante.seMovio();
		
	}

	@Override
	public void visitBomba() {
		visitante.seMovio();
		
	}

	@Override
	public void visitInvisibilidad() {
		visitante.seMovio();
		
	}

	@Override
	public void visitVelocidad() {
		visitante.seMovio();
		
	}


	@Override
	public void visitLadrillo() {
		
	}

	@Override
	public void visitGate() {
		visitante.seMovio();
		
	}

	@Override
	public void visitBloqueVacio() {
		visitante.seMovio();
		
	}






}

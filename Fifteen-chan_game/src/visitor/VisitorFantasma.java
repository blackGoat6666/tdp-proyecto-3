package visitor;

import entidades.Bloque;
import entidades.Dot;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.Fruit;
import entidades.PowerPellet;
import entidades.Velocidad;
import logica.LogicaColisiones;

public class VisitorFantasma implements Visitor{
	private Enemigo visitante;
	protected LogicaColisiones miLogica;
	
	
	public void setVisitante(Enemigo ente) {
		visitante=ente;
	}
	
	public void visitBloque(Bloque casillero) {
	  casillero.accept(this);
		
	}


	@Override
	public void visitPowerPellet(PowerPellet power) {
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
	public void visitVelocidad(Velocidad barry) {
		visitante.seMovio();
		
	}


	@Override
	public void visitLadrillo() {
		visitante.setNoSeMovio();
	}

	@Override
	public void visitGate() {
		if(visitante.puedoAtravesarGate()) {
			visitante.seMovio();
		}
		else {
			visitante.setNoSeMovio();
		}
		
	}

	@Override
	public void visitBloqueVacio() {
		visitante.seMovio();
		
	}

	@Override
	public void visitDot(Dot dot) {
		visitante.seMovio();
		
	}

	@Override
	public void visitFruit(Fruit fru) {
		visitante.seMovio();
		
	}






}

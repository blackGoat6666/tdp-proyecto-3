package visitor;

import entidades.Bloque;
import entidades.Bomba;
import entidades.Dot;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.Fruit;
import entidades.Invisibilidad;
import entidades.PowerPellet;
import entidades.Velocidad;
import logica.LogicaColisiones;

public class VisitorFantasma implements Visitor{
	private Enemigo visitante;
	protected LogicaColisiones miLogicaColisiones;
	
	
	public VisitorFantasma(LogicaColisiones miLog) {
		miLogicaColisiones=miLog;
	}
	
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
	public void visitBomba(Bomba bombastic) {
		Bloque eliminar=miLogicaColisiones.obtenerBloque(bombastic.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogicaColisiones.setModoPacman("normal");
		visitante.seMovio();
		
	}

	@Override
	public void visitInvisibilidad(Invisibilidad invi) {
		visitante.seMovio();
		Bloque eliminar=miLogicaColisiones.obtenerBloque(invi.getPosicion());
		eliminar.eliminarEntidadEstatica();
		
	}

	@Override
	public void visitVelocidad(Velocidad barry) {
		Bloque eliminar=miLogicaColisiones.obtenerBloque(barry.getPosicion());
		eliminar.eliminarEntidadEstatica();
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
		Bloque eliminar=miLogicaColisiones.obtenerBloque(fru.getPosicion());
		eliminar.eliminarEntidadEstatica();
	}






}

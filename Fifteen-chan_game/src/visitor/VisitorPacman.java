package visitor;

import entidades.Bloque;
import entidades.Bomba;
import entidades.Dot;
import entidades.Fruit;
import entidades.Invisibilidad;
import entidades.PowerPellet;
import entidades.Velocidad;
import entidadesDinamicas.Personaje;

public class VisitorPacman implements Visitor {
	protected Personaje pacman ;
	
	public VisitorPacman(Personaje wakawaka) {
		this.pacman=wakawaka;
	
	}

	public void visitBloque(Bloque casillero) {
		casillero.accept(this);
		
	}

	public void visitDot(Dot dot) {
		pacman.getLogicaColisiones().sumarPuntos(dot.getPuntaje());
		Bloque eliminar=pacman.getLogicaColisiones().obtenerBloque(dot.getPosicion());
		eliminar.eliminarEntidadEstatica();
		pacman.getLogicaColisiones().pacmanPuedeMoverse();
		pacman.getLogicaColisiones().restarDots();
		
	}

	@Override
	public void visitFruit(Fruit fru) {
		pacman.getLogicaColisiones().sumarPuntos(fru.getPuntaje());
		Bloque eliminar=pacman.getLogicaColisiones().obtenerBloque(fru.getPosicion());
		eliminar.eliminarEntidadEstatica();
		pacman.getLogicaColisiones().pacmanPuedeMoverse();
		
	}

	@Override
	public void visitPowerPellet(PowerPellet power) {
		pacman.getLogicaColisiones().agarroPowerPellet();
		Bloque eliminar=pacman.getLogicaColisiones().obtenerBloque(power.getPosicion());
		eliminar.eliminarEntidadEstatica();
		pacman.getLogicaColisiones().sumarPuntos(power.getPuntaje());
		pacman.getLogicaColisiones().pacmanPuedeMoverse();
		pacman.getLogicaColisiones().setModoPacman("powerPellet");
	}

	@Override
	public void visitBomba(Bomba bombastic) {
		pacman.getLogicaColisiones().agarroBomba();
		Bloque eliminar=pacman.getLogicaColisiones().obtenerBloque(bombastic.getPosicion());
		System.out.println(bombastic.getPosicion().x+ " "+bombastic.getPosicion().y);
		eliminar.eliminarEntidadEstatica();
		pacman.getLogicaColisiones().pacmanPuedeMoverse();
		pacman.getLogicaColisiones().setModoPacman("huir");
		
	}

	@Override
	public void visitInvisibilidad(Invisibilidad invi) {
		pacman.getLogicaColisiones().agarroInvisibilidad();
		Bloque eliminar=pacman.getLogicaColisiones().obtenerBloque(invi.getPosicion());
		eliminar.eliminarEntidadEstatica();
		pacman.getLogicaColisiones().pacmanPuedeMoverse();
		pacman.getLogicaColisiones().setModoPacman("invisibilidad");
		
	}

	public void visitBloqueVacio() {
		pacman.getLogicaColisiones().pacmanPuedeMoverse();
		pacman.getLogicaColisiones().pacmanPuedeMoverse();
	}

	
	public void visitVelocidad(Velocidad barry) {
		pacman.getLogicaColisiones().agarroVelocidad();
		Bloque eliminar=pacman.getLogicaColisiones().obtenerBloque(barry.getPosicion());
		eliminar.eliminarEntidadEstatica();
		pacman.getLogicaColisiones().pacmanPuedeMoverse();
	}


	public void visitLadrillo() {
		pacman.getLogicaColisiones().pacmanNoPuedeMoverse();
	}

	public void visitGate() {
		pacman.getLogicaColisiones().pacmanNoPuedeMoverse();
	}

	

}

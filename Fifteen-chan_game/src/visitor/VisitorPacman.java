package visitor;

import entidades.Bloque;
import entidades.Bomba;
import entidades.Dot;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.Fruit;
import entidades.Gate;
import entidades.Invisibilidad;
import entidades.Ladrillo;
import entidades.Personaje;
import entidades.PowerPellet;
import entidades.Velocidad;
import logica.LogicaColisiones;
import logica.LogicaGeneral;

public class VisitorPacman implements Visitor {
	protected Personaje visitante ;
	protected LogicaColisiones miLogicaColisiones;
	protected LogicaGeneral miLogicaGeneral;
	
	public VisitorPacman(LogicaColisiones logicaColisiones,LogicaGeneral logicaGeneral) {
		miLogicaColisiones=logicaColisiones;
		miLogicaGeneral= logicaGeneral;
	}

	public void visitBloque(Bloque casillero) {
		
		
	}

	public void visitDot(Dot dot) {
		miLogicaGeneral.sumarPuntos(dot.getPuntaje());
		Bloque eliminar=miLogicaColisiones.obtenerBloque(dot.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogicaColisiones.pacmanPuedeMoverse();
		miLogicaColisiones.restarDots();
		
	}

	@Override
	public void visitFruit(Fruit fru) {
		miLogicaGeneral.sumarPuntos(fru.getPuntaje());
		Bloque eliminar=miLogicaColisiones.obtenerBloque(fru.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogicaColisiones.pacmanPuedeMoverse();
		
	}

	@Override
	public void visitPowerPellet(PowerPellet power) {
		miLogicaColisiones.agarroPowerPellet();
		Bloque eliminar=miLogicaColisiones.obtenerBloque(power.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogicaGeneral.sumarPuntos(power.getPuntaje());
		miLogicaColisiones.pacmanPuedeMoverse();
	}

	@Override
	public void visitBomba(Bomba bombastic) {
		miLogicaColisiones.agarroBomba();
		Bloque eliminar=miLogicaColisiones.obtenerBloque(bombastic.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogicaColisiones.pacmanPuedeMoverse();
		
	}

	@Override
	public void visitInvisibilidad(Invisibilidad invi) {
		miLogicaColisiones.agarroInvisibilidad();
		Bloque eliminar=miLogicaColisiones.obtenerBloque(invi.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogicaColisiones.pacmanPuedeMoverse();
		
	}

	public void visitBloqueVacio() {
		miLogicaColisiones.pacmanPuedeMoverse();
		miLogicaColisiones.pacmanPuedeMoverse();
	}

	
	public void visitVelocidad(Velocidad barry) {
		miLogicaColisiones.agarroVelocidad();
		Bloque eliminar=miLogicaColisiones.obtenerBloque(barry.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogicaColisiones.pacmanPuedeMoverse();
	}


	public void visitLadrillo() {
		miLogicaColisiones.pacmanNoPuedeMoverse();
	}

	public void visitGate() {
		miLogicaColisiones.pacmanNoPuedeMoverse();
	}

	

}

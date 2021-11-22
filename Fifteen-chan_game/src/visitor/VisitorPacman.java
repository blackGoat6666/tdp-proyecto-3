package visitor;

import entidades.Bloque;
import entidades.Dot;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.Fruit;
import entidades.Gate;
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
		System.out.println(miLogicaColisiones.getCantidadDots());
		if(miLogicaColisiones.noQuedanDots()) {
			miLogicaGeneral.cambiarNivel(	);
		}
	}

	@Override
	public void visitFruit(Fruit fru) {
		miLogicaGeneral.sumarPuntos(fru.getPuntaje());
		fru.morir();
		Bloque eliminar=miLogicaColisiones.obtenerBloque(fru.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogicaColisiones.pacmanPuedeMoverse();
		
	}

	@Override
	public void visitPowerPellet(PowerPellet power) {
		miLogicaColisiones.agarroPowerPellet();
		power.morir();
		Bloque eliminar=miLogicaColisiones.obtenerBloque(power.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogicaColisiones.pacmanPuedeMoverse();
	}

	@Override
	public void visitBomba() {
		miLogicaColisiones.agarroBomba();
		miLogicaColisiones.pacmanPuedeMoverse();
		
	}

	@Override
	public void visitInvisibilidad() {
		miLogicaColisiones.agarroInvisibilidad();
		miLogicaColisiones.pacmanPuedeMoverse();
		
	}

	public void visitBloqueVacio() {
		miLogicaColisiones.pacmanPuedeMoverse();
		miLogicaColisiones.pacmanPuedeMoverse();
	}

	
	public void visitVelocidad(Velocidad barry) {
		miLogicaColisiones.agarroVelocidad();
		barry.morir();
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

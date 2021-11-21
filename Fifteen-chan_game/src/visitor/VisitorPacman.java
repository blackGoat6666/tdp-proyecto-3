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
import logica.Logica;

public class VisitorPacman implements Visitor {
	protected Personaje visitante ;
	protected Logica miLogica;
	
	public VisitorPacman(Logica logi) {
		miLogica=logi;
	}

	public void visitBloque(Bloque casillero) {
		
		
	}

	public void visitDot(Dot dot) {
		miLogica.sumarPuntos(dot.getPuntaje());
		Bloque eliminar=miLogica.obtenerBloque(dot.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogica.pacmanPuedeMoverse();
	}

	@Override
	public void visitFruit(Fruit fru) {
		miLogica.sumarPuntos(fru.getPuntaje());
		fru.morir();
		Bloque eliminar=miLogica.obtenerBloque(fru.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogica.pacmanPuedeMoverse();
		
	}

	@Override
	public void visitPowerPellet(PowerPellet power) {
		miLogica.agarroPowerPellet();
		power.morir();
		Bloque eliminar=miLogica.obtenerBloque(power.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogica.pacmanPuedeMoverse();
	}

	@Override
	public void visitBomba() {
		miLogica.agarroBomba();
		miLogica.pacmanPuedeMoverse();
		
	}

	@Override
	public void visitInvisibilidad() {
		miLogica.agarroInvisibilidad();
		miLogica.pacmanPuedeMoverse();
		
	}

	public void visitBloqueVacio() {
		miLogica.pacmanPuedeMoverse();
		miLogica.pacmanPuedeMoverse();
	}

	
	public void visitVelocidad(Velocidad barry) {
		miLogica.agarroVelocidad();
		barry.morir();
		Bloque eliminar=miLogica.obtenerBloque(barry.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogica.pacmanPuedeMoverse();
	}


	public void visitLadrillo() {
		miLogica.pacmanNoPuedeMoverse();
	}

	public void visitGate() {
		miLogica.pacmanNoPuedeMoverse();
	}

	

}

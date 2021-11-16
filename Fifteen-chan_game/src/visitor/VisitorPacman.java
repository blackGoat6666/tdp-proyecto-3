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

	@Override
	public void visitBloque(Bloque casillero) {
		// TODO Auto-generated method stub
		
	}

	public void visitDot(Dot dot) {
		miLogica.sumarPuntos(dot.getPuntaje());
		dot.eliminarImagen();
		Bloque eliminar=miLogica.obtenerBloque(dot.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogica.pacmanPuedeMoverse();
	}

	@Override
	public void visitFruit(Fruit fru) {
		miLogica.sumarPuntos(fru.getPuntaje());
		fru.eliminarImagen();
		Bloque eliminar=miLogica.obtenerBloque(fru.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogica.pacmanPuedeMoverse();
		
	}

	@Override
	public void visitPowerPellet(PowerPellet power) {
		miLogica.agarroPowerPellet();
		power.eliminarImagen();
		Bloque eliminar=miLogica.obtenerBloque(power.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogica.pacmanPuedeMoverse();
	}

	@Override
	public void visitBomba() {
		miLogica.agarroBomba();
		
	}

	@Override
	public void visitInvisibilidad() {
		miLogica.agarroInvisibilidad();
		
	}

	public void visitBloqueVacio() {
		
	}

	
	public void visitVelocidad(Velocidad barry) {
		miLogica.agarroVelocidad();
		barry.eliminarImagen();
		Bloque eliminar=miLogica.obtenerBloque(barry.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miLogica.pacmanPuedeMoverse();
	}


	public void visitLadrillo() {
		
	}

	public void visitGate() {
		
	}

	

}

package visitor;

import entidades.Bloque;
import entidades.Bomba;
import entidades.Dot;
import entidades.Fruit;
import entidades.Invisibilidad;
import entidades.PowerPellet;
import entidades.Velocidad;
import entidadesDinamicas.Enemigo;

public class VisitorFantasma implements Visitor{
	private Enemigo miFantasma;
	
	
	public VisitorFantasma(Enemigo fantasmin) {
		this.miFantasma= fantasmin;
	}

	public void visitBloque(Bloque casillero) {
	  casillero.accept(this);
		
	}


	@Override
	public void visitPowerPellet(PowerPellet power) {
		miFantasma.seMovio();
	}

	@Override
	public void visitBomba(Bomba bombastic) {
		Bloque eliminar=miFantasma.getBloque(bombastic.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miFantasma.seMovio();
		
	}

	@Override
	public void visitInvisibilidad(Invisibilidad invi) {
		miFantasma.seMovio();
		Bloque eliminar=miFantasma.getBloque(invi.getPosicion());
		eliminar.eliminarEntidadEstatica();
		
	}

	@Override
	public void visitVelocidad(Velocidad barry) {
		Bloque eliminar=miFantasma.getBloque(barry.getPosicion());
		eliminar.eliminarEntidadEstatica();
		miFantasma.seMovio();
		
	}


	@Override
	public void visitLadrillo() {
		miFantasma.setNoSeMovio();
	}

	@Override
	public void visitGate() {
		if(miFantasma.puedoAtravesarGate()) {
			miFantasma.seMovio();
		}
		else {
			miFantasma.setNoSeMovio();
		}
		
	}

	@Override
	public void visitBloqueVacio() {
		miFantasma.seMovio();
		
	}

	@Override
	public void visitDot(Dot dot) {
		miFantasma.seMovio();
		
	}

	@Override
	public void visitFruit(Fruit fru) {
		miFantasma.seMovio();
		Bloque eliminar=miFantasma.getBloque(fru.getPosicion());
		eliminar.eliminarEntidadEstatica();
	}






}

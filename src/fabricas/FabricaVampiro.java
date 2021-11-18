package fabricas;

import javax.swing.JLabel;

import entidades.EntidadGraficaDinamica;
import entidades.EntidadGraficaEstatica;


public class FabricaVampiro implements FabricaEntidades {

	public FabricaVampiro() {
		
	}
	
	
	public EntidadGraficaDinamica getBlinky() {
		// TODO Auto-generated method stub
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/resources/Vampiro/vampiroadelantemoviendose.gif";
		}
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getInky() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/Images/vampiroadelantemoviendose.gif";
		}
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getPinky() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/Images/vampiroadelantemoviendose.gif";
		}
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getClyde() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/Images/vampiroadelantemoviendose.gif";
		}
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getPersonaje() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/resources/Vampiro/vampiroadelantemoviendose.gif";
		}
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaEstatica getDot() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica("/resources/Vampiro/dotVampiro.png");
	}

	@Override
	public EntidadGraficaEstatica getPowerPellet() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica ("/resources/Vampiro/ppVampiro.png");
	}

	@Override
	public EntidadGraficaEstatica getFruit1() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaEstatica getFruit2() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaEstatica getFruit3() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaEstatica getBomba() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaEstatica getInvisibilidad() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaEstatica getVelocidad() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica ("/Images/vampiroadelantemoviendose.gif");
	}


	
}

package fabricas;

import entidades.EntidadGraficaDinamica;
import entidades.EntidadGraficaEstatica;


public class FabricaVampiro implements FabricaEntidades {

	public FabricaVampiro() {
		
	}
	
	
	public EntidadGraficaDinamica getBlinky() {
		String[] retorno= new String[16];
		retorno[0]="/resources/Vampiro/papa adelante.gif";
		retorno[1]="/resources/Vampiro/papa atras.gif";
		retorno[2]="/resources/Vampiro/papa adelante.gif";
		retorno[3]="/resources/Vampiro/papa adelante.gif";
		retorno[4]="/resources/Vampiro/papa power pellet adelante.gif";
		retorno[5]="/resources/Vampiro/papa power pellet atras.gif";
		retorno[6]="/resources/Vampiro/papa power pellet adelante.gif";
		retorno[7]="/resources/Vampiro/papa power pellet atras.gif";
		retorno[8]="/resources/Vampiro/papa bomba adelante.gif";
		retorno[9]="/resources/Vampiro/papa bomba atras.gif";
		retorno[10]="/resources/Vampiro/papa bomba adelante.gif";
		retorno[11]="/resources/Vampiro/papa bomba atras.gif";
		retorno[12]="/resources/Vampiro/papa adelante.gif";
		retorno[13]="/resources/Vampiro/papa atras.gif";
		retorno[14]="/resources/Vampiro/papa adelante.gif";
		retorno[15]="/resources/Vampiro/papa atras.gif";
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getInky() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/resources/Vampiro/vampiroadelantemoviendose.gif";
		}
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getPinky() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/resources/Vampiro/vampiroadelantemoviendose.gif";
		}
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getClyde() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/resources/Vampiro/vampiroadelantemoviendose.gif";
		}
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getPersonaje() {
		String[] retorno= new String[16];
		retorno[0]="/resources/Vampiro/vampiroadelantemoviendose.gif";
		retorno[1]="/resources/Vampiro/vampiro mirando atras.gif";
		retorno[2]="/resources/Vampiro/vampiroadelantemoviendose.gif";
		retorno[3]="/resources/Vampiro/vampiroadelantemoviendose.gif";
		retorno[4]="/resources/Vampiro/power pellet.gif";
		retorno[5]="/resources/Vampiro/power pellet atras.gif";
		retorno[6]="/resources/Vampiro/power pellet.gif";
		retorno[7]="/resources/Vampiro/power pellet atras.gif";
		retorno[8]="/resources/Vampiro/vampiro bomba adelante.gif";
		retorno[9]="/resources/Vampiro/vampiro bomba atras.gif";
		retorno[10]="/resources/Vampiro/vampiro bomba adelante.gif";
		retorno[11]="/resources/Vampiro/vampiro bomba atras.gif";
		retorno[12]="/resources/Vampiro/papa adelante.gif";
		retorno[13]="/resources/Vampiro/papa atras.gif";
		retorno[14]="/resources/Vampiro/papa adelante.gif";
		retorno[15]="/resources/Vampiro/papa atras.gif";
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
	public EntidadGraficaEstatica getFruit(int nivel) {
		switch(nivel) {
			case 1: return  new EntidadGraficaEstatica ("/resources/Vampiro/ppVampiro.png");
			case 2: return  new EntidadGraficaEstatica ("/resources/Vampiro/ppVampiro.png");
			case 3: return  new EntidadGraficaEstatica ("/resources/Vampiro/ppVampiro.png");
		}
		return null;
	}

	
	@Override
	public EntidadGraficaEstatica getBomba() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaEstatica getInvisibilidad() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica ("/resources/Vampiro/vampiroInvisibilidad.png");
	}

	@Override
	public EntidadGraficaEstatica getVelocidad() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica ("/Images/vampiroadelantemoviendose.gif");
	}


	@Override
	public String getVida() {
		
		return "/resources/Vampiro/vampiro.png";
	}


	@Override
	public String getVidaMuerta() {
		return "/resources/Vampiro/vampiro ripeado.png";
	}


	@Override
	public String getMusica(int nivel) {
		switch(nivel) {
			case 1: return "\\resources\\Musica\\Dragula8bit.wav";
			case 2: return "\\resources\\Musica\\Toccata 8 Bit.wav";
			case 3: return "\\resources\\Musica\\Dragula8bit.wav";
		}
		return null;
	}

	public String getFondo(int nivel) {
		switch(nivel) {
			case 1: return "/resources/Vampiro/nivelvampiro1.png";
			case 2: return "/resources/Vampiro/nivelvampiro2.png";
			case 3: return "/resources/Vampiro/nivelvampiro3.png";
		}
		return null;
	}


	
}

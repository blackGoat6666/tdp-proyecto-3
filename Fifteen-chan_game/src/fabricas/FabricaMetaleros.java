package fabricas;

import entidades.EntidadGraficaDinamica;
import entidades.EntidadGraficaEstatica;

public class FabricaMetaleros implements FabricaEntidades{

	public FabricaMetaleros() {
		
	}
	
	@Override
	public EntidadGraficaDinamica getBlinky() {
		String[] retorno= new String[16];
		retorno[0]="/resources/Metalero/iara.gif";
		retorno[1]="/resources/Metalero/iaraAtras.gif";
		retorno[2]="/resources/Metalero/iara.gif";
		retorno[3]="/resources/Metalero/iara.gif";
		retorno[4]="/resources/Metalero/iaraHuir.gif";
		retorno[5]="/resources/Metalero/iaraAtrasHuir.gif";
		retorno[6]="/resources/Metalero/iaraHuir.gif";
		retorno[7]="/resources/Metalero/iaraHuir.gif";
		retorno[8]="/resources/Metalero/iaraMuerta.gif";
		retorno[9]="/resources/Metalero/iaraAtrasMuerta.gif";
		retorno[10]="/resources/Metalero/iaraMuerta.gif";
		retorno[11]="/resources/Metalero/iaraMuerta.gif";
		retorno[12]="/resources/Metalero/iara.gif";
		retorno[13]="/resources/Metalero/iara.gif";
		retorno[14]="/resources/Metalero/iara.gif";
		retorno[15]="/resources/Metalero/iara.gif";
		return new EntidadGraficaDinamica(retorno);
	}

	public EntidadGraficaDinamica getInky() {
		String[] retorno= new String[16];
		retorno[0]="/resources/Metalero/Baz.gif";
		retorno[1]="/resources/Metalero/BazAtras.gif";
		retorno[2]="/resources/Metalero/Baz.gif";
		retorno[3]="/resources/Metalero/Baz.gif";
		retorno[4]="/resources/Metalero/BazMuerto.gif";
		retorno[5]="/resources/Metalero/BazAtrasHuir.gif";
		retorno[6]="/resources/Metalero/BazHuir.gif";
		retorno[7]="/resources/Metalero/BazHuir.gif";
		retorno[8]="/resources/Metalero/BazMuerto.gif";
		retorno[9]="/resources/Metalero/BazAtrasMuerta.gif";
		retorno[10]="/resources/Metalero/BazMuerto.gif";
		retorno[11]="/resources/Metalero/BazMuerto.gif";
		retorno[12]="/resources/Metalero/Baz.gif";
		retorno[13]="/resources/Metalero/Baz.gif";
		retorno[14]="/resources/Metalero/Baz.gif";
		retorno[15]="/resources/Metalero/Baz.gif";
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getPinky() {
		String[] retorno= new String[16];
		retorno[0]="/resources/Metalero/Baz.gif";
		retorno[1]="/resources/Metalero/BazAtras.gif";
		retorno[2]="/resources/Metalero/Baz.gif";
		retorno[3]="/resources/Metalero/Baz.gif";
		retorno[4]="/resources/Metalero/BazMuerto.gif";
		retorno[5]="/resources/Metalero/BazAtrasHuir.gif";
		retorno[6]="/resources/Metalero/BazHuir.gif";
		retorno[7]="/resources/Metalero/BazHuir.gif";
		retorno[8]="/resources/Metalero/BazMuerto.gif";
		retorno[9]="/resources/Metalero/BazAtrasMuerta.gif";
		retorno[10]="/resources/Metalero/BazMuerto.gif";
		retorno[11]="/resources/Metalero/BazMuerto.gif";
		retorno[12]="/resources/Metalero/Baz.gif";
		retorno[13]="/resources/Metalero/Baz.gif";
		retorno[14]="/resources/Metalero/Baz.gif";
		retorno[15]="/resources/Metalero/Baz.gif";
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getClyde() {
		String[] retorno= new String[16];
		retorno[0]="/resources/Metalero/viniloconpatas.gif";
		retorno[1]="/resources/Metalero/viniloconpatas.gif";
		retorno[2]="/resources/Metalero/viniloconpatas.gif";
		retorno[3]="/resources/Metalero/viniloconpatas.gif";
		retorno[4]="/resources/Metalero/viniloconpatasHuir.gif";
		retorno[5]="/resources/Metalero/viniloconpatasHuir.gif";
		retorno[6]="/resources/Metalero/viniloconpatasHuir.gif";
		retorno[7]="/resources/Metalero/viniloconpatasHuir.gif";
		retorno[8]="/resources/Metalero/viniloconpatasMuerto.gif";
		retorno[9]="/resources/Metalero/viniloconpatasMuerto.gif";
		retorno[10]="/resources/Metalero/viniloconpatasMuerto.gif";
		retorno[11]="/resources/Metalero/viniloconpatasMuerto.gif";
		retorno[12]="/resources/Metalero/viniloconpatas.gif";
		retorno[13]="/resources/Metalero/viniloconpatas.gif";
		retorno[14]="/resources/Metalero/viniloconpatas.gif";
		retorno[15]="/resources/Metalero/viniloconpatas.gif";
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getPersonaje() {
		String[] retorno= new String[16];
		retorno[0]="/resources/Metalero/metaleroavanzandoadelante.gif";
		retorno[1]="/resources/Metalero/metaleroavanzandoadelante.gif";
		retorno[2]="/resources/Metalero/metaleroavanzandoadelante.gif";
		retorno[3]="/resources/Metalero/metaleroavanzandoadelante.gif";
		retorno[4]="/resources/Metalero/metaleroPowerPellet.gif";
		retorno[5]="/resources/Metalero/metaleroPowerPellet.gif";
		retorno[6]="/resources/Metalero/metaleroPowerPellet.gif";
		retorno[7]="/resources/Metalero/metaleroPowerPellet.gif";
		retorno[8]="/resources/Metalero/metaleroBomba.gif";
		retorno[9]="/resources/Metalero/metaleroBomba.gif";
		retorno[10]="/resources/Metalero/metaleroBomba.gif";
		retorno[11]="/resources/Metalero/metaleroBomba.gif";
		retorno[12]="/resources/Metalero/metaleroBomba.gif";
		retorno[13]="/resources/Metalero/metaleroBomba.gif";
		retorno[14]="/resources/Metalero/metaleroBomba.gif";
		retorno[15]="/resources/Metalero/metaleroBomba.gif";
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaEstatica getDot() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica ("/resources/Metalero/cd.png");
	}

	@Override
	public EntidadGraficaEstatica getPowerPellet() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica ("/resources/Metalero/vinilo.png");
	}

	@Override
	public EntidadGraficaEstatica getFruit(int nivel) {
		switch(nivel) {
		case 1: return  new EntidadGraficaEstatica ("/resources/Metalero/birrita.png");
		case 2: return  new EntidadGraficaEstatica ("/resources/Metalero/boletito.png");
		case 3: return  new EntidadGraficaEstatica ("/resources/Metalero/birrita.png");
	}
	return null;
}

	@Override
	public EntidadGraficaEstatica getBomba() {
		// TODO Auto-generated method stub
		return new EntidadGraficaEstatica ("/resources/Metalero/jbl.gif");
	}

	@Override
	public EntidadGraficaEstatica getInvisibilidad() {
		return  new EntidadGraficaEstatica ("/resources/Metalero/birrita.png");
	}

	@Override
	public EntidadGraficaEstatica getVelocidad() {
		// TODO Auto-generated method stub
		return  new EntidadGraficaEstatica ("/resources/Metalero/pua.png");
	}
	@Override
	public String getVida() {
		return "/resources/Metalero/metalero.png";
	}

	@Override
	public String getVidaMuerta() {
		return "/resources/Metalero/metalero ripeado.png";
	}

	@Override
	public String getMusica(int nivel) {
		switch(nivel) {
        case 1: return "/resources/Musica/Dragula8bit.wav";
		case 2: return "/resources/Musica/Dragula8bit.wav";
		case 3: return "/resources/Musica/Dragula8bit.wav";
	}
	return null;
}

	@Override
	public String getFondo(int nivel) {
		switch(nivel) {
			case 1: return "/resources/Vampiro/nivelvampiro1.png";
			case 2: return "/resources/Vampiro/nivelvampiro2.png";
			case 3: return "/resources/Vampiro/nivelvampiro3.png";
		}
		return null;
	}

}

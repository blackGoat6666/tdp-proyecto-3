package fabricas;

import entidades.EntidadGraficaDinamica;
import entidades.EntidadGraficaEstatica;

public class FabricaSCP implements FabricaEntidades {

    public FabricaSCP() {
		
	}

	@Override
	public EntidadGraficaDinamica getBlinky() {
		String[] retorno= new String[16];
		retorno[0]="/resources/SCP/Chanqueo.gif";
		retorno[1]="/resources/SCP/Chanqueo.gif";
		retorno[2]="/resources/SCP/Chanqueo.gif";
		retorno[3]="/resources/SCP/Chanqueo.gif";
		retorno[4]="/resources/SCP/ChanqueoHuir.gif";
		retorno[5]="/resources/SCP/ChanqueoHuir.gif";
		retorno[6]="/resources/SCP/ChanqueoHuir.gif";
		retorno[7]="/resources/SCP/ChanqueoHuir.gif";
		retorno[8]="/resources/SCP/ChanqueoMuerta.gif";
		retorno[9]="/resources/SCP/ChanqueoMuerta.gif";
		retorno[10]="/resources/SCP/ChanqueoMuerta.gif";
		retorno[11]="/resources/SCP/ChanqueoMuerta.gif";
		retorno[12]="/resources/SCP/Chanqueo.gif";
		retorno[13]="/resources/SCP/Chanqueo.gif";
		retorno[14]="/resources/SCP/Chanqueo.gif";
		retorno[15]="/resources/SCP/Chanqueo.gif";
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getInky() {
		String[] retorno= new String[16];
		retorno[0]="/resources/SCP/kushi.png";
		retorno[1]="/resources/SCP/kushi.png";
		retorno[2]="/resources/SCP/kushi.png";
		retorno[3]="/resources/SCP/kushi.png";
		retorno[4]="/resources/SCP/kushiHuir.png";
		retorno[5]="/resources/SCP/kushiHuir.png";
		retorno[6]="/resources/SCP/kushiHuir.png";
		retorno[7]="/resources/SCP/kushiHuir.png";
		retorno[8]="/resources/SCP/kushiMuerto.png";
		retorno[9]="/resources/SCP/kushiMuerto.png";
		retorno[10]="/resources/SCP/kushiMuerto.png";
		retorno[11]="/resources/SCP/kushiMuerto.png";
		retorno[12]="/resources/SCP/kushi.png";
		retorno[13]="/resources/SCP/kushi.png";
		retorno[14]="/resources/SCP/kushi.png";
		retorno[15]="/resources/SCP/kushi.png";
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getPinky() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/resources/SCP/ojardo.png";
		}
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getClyde() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/resources/SCP/yello.png";
		}
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaDinamica getPersonaje() {
		String[] retorno= new String[16];
		retorno[0]="/resources/SCP/999.gif";
		retorno[1]="/resources/SCP/999.gif";
		retorno[2]="/resources/SCP/999.gif";
		retorno[3]="/resources/SCP/999.gif";
		retorno[4]="/resources/SCP/999bomba.gif";
		retorno[5]="/resources/SCP/999bomba.gif";
		retorno[6]="/resources/SCP/999bomba.gif";
		retorno[7]="/resources/SCP/999bomba.gif";
		retorno[8]="/resources/SCP/999Invisibilidad.gif";
		retorno[9]="/resources/SCP/999Invisibilidad.gif";
		retorno[10]="/resources/SCP/999Invisibilidad.gif";
		retorno[11]="/resources/SCP/999Invisibilidad.gif";
		retorno[12]="/resources/SCP/999Invisibilidad.gif";
		retorno[13]="/resources/SCP/999Invisibilidad.gif";
		retorno[14]="/resources/SCP/999Invisibilidad.gif";
		retorno[15]="/resources/SCP/999Invisibilidad.gif";
		return new EntidadGraficaDinamica(retorno);
	}

	@Override
	public EntidadGraficaEstatica getDot() {
		return new EntidadGraficaEstatica("/resources/SCP/caramelo.png");
	}


	@Override
	public EntidadGraficaEstatica getPowerPellet() {
		return new EntidadGraficaEstatica("/resources/SCP/paletita.png");
	}

	@Override
	public EntidadGraficaEstatica getFruit(int nivel) {
		switch(nivel) {
		case 1: return  new EntidadGraficaEstatica ("/resources/SCP/palito.png");
		case 2: return  new EntidadGraficaEstatica ("/resources/SCP/chocolate.png");
		case 3: return  new EntidadGraficaEstatica ("/resources/SCP/rocklets.png");
	}
	return null;
}

	@Override
	public EntidadGraficaEstatica getBomba() {
		return new EntidadGraficaEstatica("/resources/SCP/nose.png");
	}

	@Override
	public EntidadGraficaEstatica getInvisibilidad() {
		return new EntidadGraficaEstatica("/resources/SCP/invisibilidad.png");
	}

	@Override
	public EntidadGraficaEstatica getVelocidad() {
		// TODO Auto-generated method stub  
		return new EntidadGraficaEstatica("/resources/SCP/velocidad.png");
	}

	@Override
	public String getVida() {
		return "/resources/SCP/scp-999b.png";
	}

	@Override
	public String getVidaMuerta() {
		return "/resources/SCP/scp-999bbbt.png";
	}

	@Override
	public String getMusica(int nivel) {
		switch(nivel) {
        case 1: return "/resources/Musica/Two Time 8bit.wav";
		case 2: return "/resources/Musica/Dead Weight 8bit.wav";
		case 3: return "/resources/Musica/Two Time 8bit.wav";
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

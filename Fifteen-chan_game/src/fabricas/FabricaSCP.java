package fabricas;

import java.awt.Point;

import entidades.Bomba;
import entidades.Dot;
import entidades.EntidadEstatica;
import entidades.EntidadGraficaEstatica;
import entidades.Fruit;
import entidades.Invisibilidad;
import entidades.PowerPellet;
import entidades.Velocidad;
import entidadesDinamicas.Blinky;
import entidadesDinamicas.Clyde;
import entidadesDinamicas.Enemigo;
import entidadesDinamicas.EntidadGraficaDinamica;
import entidadesDinamicas.Inky;
import entidadesDinamicas.Personaje;
import entidadesDinamicas.Pinky;
import logica.LogicaColisiones;

public class FabricaSCP implements FabricaEntidades {

    public FabricaSCP() {
		
	}

	@Override
	public Enemigo getBlinky() {
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
		return new Blinky(5,new EntidadGraficaDinamica(retorno));
	}

	@Override
	public Enemigo getInky() {
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
		return new Inky(3,new EntidadGraficaDinamica(retorno));
	}

	@Override
	public Enemigo getPinky() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/resources/SCP/ojardo.png";
		}
		return new Pinky(3,new EntidadGraficaDinamica(retorno));
	}

	@Override
	public Enemigo getClyde() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/resources/SCP/yello.png";
		}
		return new Clyde(3,new EntidadGraficaDinamica(retorno));
	}

	public Personaje getPersonaje(LogicaColisiones log) {
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
		return new Personaje(log, new EntidadGraficaDinamica(retorno));
	}

	public EntidadEstatica getDot(Point ubicacion) {
		return new Dot(ubicacion, new EntidadGraficaEstatica("/resources/SCP/caramelo.png"));
	}


	@Override
	public EntidadEstatica getPowerPellet(Point ubicacion) {
		return new PowerPellet(ubicacion,new EntidadGraficaEstatica("/resources/SCP/paletita.png"));
	}

	@Override
	public EntidadEstatica getFruit(Point ubicacion,int nivel) {
		switch(nivel) {
		case 1: return new Fruit(ubicacion, new EntidadGraficaEstatica ("/resources/SCP/palito.png"));
		case 2: return new Fruit(ubicacion, new EntidadGraficaEstatica ("/resources/SCP/chocolate.png"));
		case 3: return new Fruit(ubicacion,  new EntidadGraficaEstatica ("/resources/SCP/rocklets.png"));
	}
	return null;
}

	@Override
	public EntidadEstatica getBomba(Point ubicacion) {
		return new Bomba(ubicacion,new  EntidadGraficaEstatica("/resources/SCP/nose.png"));
	}

	@Override
	public EntidadEstatica getInvisibilidad(Point ubicacion) {
		return new Invisibilidad(ubicacion, new EntidadGraficaEstatica("/resources/SCP/invisibilidad.png"));
	}

	@Override
	public EntidadEstatica getVelocidad(Point ubicacion) {
		// TODO Auto-generated method stub  
		return new Velocidad(ubicacion, new EntidadGraficaEstatica("/resources/SCP/velocidad.png"));
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
        case 1: return "/src/resources/Musica/Two Time 8bit.wav";
		case 2: return "/src/resources/Musica/XFiles.wav";
		case 3: return "/src/resources/Musica/Dead Weight 8bit.wav";
	}
	return null;
}

	@Override
	public String getFondo(int nivel) {
		switch(nivel) {
		case 1: return "/resources/SCP/nivelscp1.png";
		case 2: return "/resources/SCP/nivelscp2.png";
		case 3: return "/resources/SCP/nivelscp3.png";
	}
	return null;
}


}

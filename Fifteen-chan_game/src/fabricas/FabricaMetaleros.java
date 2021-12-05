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

public class FabricaMetaleros implements FabricaEntidades{

	public FabricaMetaleros() {
		
	}
	
	@Override
	public Enemigo getBlinky() {
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
		return new Blinky(5,new EntidadGraficaDinamica(retorno));
	}

	public Enemigo getInky() {
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
		return new Inky(3,new EntidadGraficaDinamica(retorno));
	}

	@Override
	public Enemigo getPinky() {
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
		return new Pinky(3,new EntidadGraficaDinamica(retorno));
	}

	@Override
	public Enemigo getClyde() {
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
		return new Clyde(3,new EntidadGraficaDinamica(retorno));
	}

	@Override
	public Personaje getPersonaje(LogicaColisiones log) {
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
		return new Personaje(log, new EntidadGraficaDinamica(retorno));
	}

	@Override
	public EntidadEstatica getDot(Point ubicacion) {
		// TODO Auto-generated method stub
		return new Dot(ubicacion, new EntidadGraficaEstatica("/resources/Metalero/cd.png"));
	}

	@Override
	public EntidadEstatica getPowerPellet(Point ubicacion) {
		// TODO Auto-generated method stub
		return new PowerPellet(ubicacion, new EntidadGraficaEstatica("/resources/Metalero/vinilo.png"));
	}

	@Override
	public EntidadEstatica getFruit(Point ubicacion,int nivel) {
		switch(nivel) {
		case 1: return new Fruit(ubicacion, new EntidadGraficaEstatica ("/resources/Metalero/birrita.png"));
		case 2: return new Fruit(ubicacion,  new EntidadGraficaEstatica ("/resources/Metalero/boletito.png"));
		case 3: return new Fruit(ubicacion,  new EntidadGraficaEstatica ("/resources/Metalero/birrita.png"));
	}
	return null;
}

	@Override
	public EntidadEstatica getBomba(Point ubicacion) {
		// TODO Auto-generated method stub
		return new Bomba(ubicacion,  new EntidadGraficaEstatica ("/resources/Metalero/jbl.gif"));
	}

	@Override
	public EntidadEstatica getInvisibilidad(Point ubicacion) {
		return new Invisibilidad(ubicacion, new EntidadGraficaEstatica ("/resources/Metalero/birrita.png"));
	}

	@Override
	public EntidadEstatica getVelocidad(Point ubicacion) {
		// TODO Auto-generated method stub
		return  new Velocidad(ubicacion,new EntidadGraficaEstatica ("/resources/Metalero/pua.png"));
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
        case 1: return "/src/resources/Musica/Painkiller.wav";
		case 2: return "/src/resources/Musica/Breaking The Law8bit.wav";
		case 3: return "/src/resources/Musica/Master Of Puppets8bit.wav";
	}
	return null;
}

	@Override
	public String getFondo(int nivel) {
		switch(nivel) {
			case 1: return "/resources/Metalero/nivel1.jpg";
			case 2: return "/resources/Metalero/nivel2jpg.jpg";
			case 3: return "/resources/Metaleros/nivel3.jpg";
		}
		return null;
	}

}

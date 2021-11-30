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


public class FabricaVampiro implements FabricaEntidades {

	public FabricaVampiro() {
		
	}
	
	
	public Enemigo getBlinky() {
		String[] retorno= new String[16];
		retorno[0]="/resources/Vampiro/papa adelante.gif";
		retorno[1]="/resources/Vampiro/papa atras.gif";
		retorno[2]="/resources/Vampiro/papa adelante.gif";
		retorno[3]="/resources/Vampiro/papa adelante.gif";
		retorno[4]="/resources/Vampiro/papa power pellet adelante.gif";
		retorno[5]="/resources/Vampiro/papa power pellet atras.gif";
		retorno[6]="/resources/Vampiro/papa power pellet adelante.gif";
		retorno[7]="/resources/Vampiro/papa power pellet adelante.gif";
		retorno[8]="/resources/Vampiro/papaMuerto.gif";
		retorno[9]="/resources/Vampiro/papaMuertoAtras.gif";
		retorno[10]="/resources/Vampiro/papaMuerto.gif";
		retorno[11]="/resources/Vampiro/papaMuerto.gif";
		retorno[12]="/resources/Vampiro/papa adelante.gif";
		retorno[13]="/resources/Vampiro/papa atras.gif";
		retorno[14]="/resources/Vampiro/papa adelante.gif";
		retorno[15]="/resources/Vampiro/papa atras.gif";
		return new Blinky(5,new EntidadGraficaDinamica(retorno));
	}

	@Override
	public Enemigo getInky() {
		String[] retorno= new String[16];
		retorno[0]="/resources/Vampiro/angy.png";
		retorno[1]="/resources/Vampiro/angy.png";
		retorno[2]="/resources/Vampiro/angy.png";
		retorno[3]="/resources/Vampiro/angy.png";
		retorno[4]="/resources/Vampiro/angy.png";
		retorno[5]="/resources/Vampiro/angy.png";
		retorno[6]="/resources/Vampiro/angy.png";
		retorno[7]="/resources/Vampiro/angy.png";
		retorno[8]="/resources/Vampiro/angy.png";
		retorno[9]="/resources/Vampiro/angy.png";
		retorno[10]="/resources/Vampiro/angy.png";
		retorno[11]="/resources/Vampiro/angy.png";
		retorno[12]="/resources/Vampiro/angy.png";
		retorno[13]="/resources/Vampiro/angy.png";
		retorno[14]="/resources/Vampiro/angy.png";
		retorno[15]="/resources/Vampiro/angy.png";
		return new Inky(5,new EntidadGraficaDinamica(retorno));
	}

	@Override
	public Enemigo getPinky() {
		String[] retorno= new String[16];
		for(int i=0; i<16; i++) {
			retorno[i]="/resources/Vampiro/vampiro power pellet maybe.gif";
		}
		return new Pinky(3,new EntidadGraficaDinamica(retorno));
	}

	@Override
	public Enemigo getClyde() {
		String[] retorno= new String[16];
		retorno[0]="/resources/Vampiro/JosephCheaterJoestar.gif";
		retorno[1]="/resources/Vampiro/JosephCheaterJoestar.gif";
		retorno[2]="/resources/Vampiro/JosephCheaterJoestar.gif";
		retorno[3]="/resources/Vampiro/JosephCheaterJoestar.gif";
		retorno[4]="/resources/Vampiro/JosephCheaterJoestarPowerPellet.gif";
		retorno[5]="/resources/Vampiro/JosephCheaterJoestarPowerPellet.gif";
		retorno[6]="/resources/Vampiro/JosephCheaterJoestarPowerPellet.gif";
		retorno[7]="/resources/Vampiro/JosephCheaterJoestarPowerPellet.gif";
		retorno[8]="/resources/Vampiro/JosephCheaterJoestar.gif";
		retorno[9]="/resources/Vampiro/JosephCheaterJoestar.gif";
		retorno[10]="/resources/Vampiro/JosephCheaterJoestar.gif";
		retorno[11]="/resources/Vampiro/JosephCheaterJoestar.gif";
		retorno[12]="/resources/Vampiro/JosephCheaterJoestar.gif";
		retorno[13]="/resources/Vampiro/JosephCheaterJoestar.gif";
		retorno[14]="/resources/Vampiro/JosephCheaterJoestar.gif";
		retorno[15]="/resources/Vampiro/JosephCheaterJoestar.gif";
		return new Clyde(3,new EntidadGraficaDinamica(retorno));
	}

	@Override
	public Personaje getPersonaje(LogicaColisiones log) {
		String[] retorno= new String[16];
		retorno[0]="/resources/Vampiro/vampiroadelantemoviendose.gif";
		retorno[1]="/resources/Vampiro/vampiro mirando atras.gif";
		retorno[2]="/resources/Vampiro/vampiroIzquierda.png";
		retorno[3]="/resources/Vampiro/vampiroderecha.png";
		retorno[4]="/resources/Vampiro/power pellet.gif";
		retorno[5]="/resources/Vampiro/power pellet atras.gif";
		retorno[6]="/resources/Vampiro/power pellet.gif";
		retorno[7]="/resources/Vampiro/power pellet.gif";
		retorno[8]="/resources/Vampiro/vampiro bomba adelante.gif";
		retorno[9]="/resources/Vampiro/vampiro bomba atras.gif";
		retorno[10]="/resources/Vampiro/vampiro bomba adelante.gif";
		retorno[11]="/resources/Vampiro/vampiro mirando derecha bomba.png";
		retorno[12]="/resources/Vampiro/power pellet atras.gif";
		retorno[13]="/resources/Vampiro/power pellet atras.gif";
		retorno[14]="/resources/Vampiro/power pellet atras.gif";
		retorno[15]="/resources/Vampiro/power pellet atras.gif";
		return new Personaje(log, new EntidadGraficaDinamica(retorno));
	}

	@Override
	public EntidadEstatica getDot(Point ubicacion) {
		// TODO Auto-generated method stub
		return new Dot(ubicacion, new EntidadGraficaEstatica("/resources/Vampiro/dotVampiro.png"));
	}

	@Override
	public EntidadEstatica getPowerPellet(Point ubicacion) {
		// TODO Auto-generated method stub
		return new PowerPellet(ubicacion, new EntidadGraficaEstatica ("/resources/Vampiro/ppVampiro.png"));
	}

	@Override
	public EntidadEstatica getFruit(Point ubicacion,int nivel) {
		switch(nivel) {
			case 1: return new Fruit(ubicacion,  new EntidadGraficaEstatica ("/resources/Vampiro/crepusculoEnLlamas.png"));
			case 2: return new Fruit(ubicacion,  new EntidadGraficaEstatica ("/resources/Vampiro/dracula.png"));
			case 3: return new Fruit(ubicacion,  new EntidadGraficaEstatica ("/resources/Vampiro/collarHermoso.png"));
		}
		return null;
	}

	
	@Override
	public EntidadEstatica getBomba(Point ubicacion) {
		// TODO Auto-generated method stub
		return new Bomba(ubicacion, new EntidadGraficaEstatica ("/resources/Vampiro/bomba.gif"));
	}

	@Override
	public EntidadEstatica getInvisibilidad(Point ubicacion) {
		// TODO Auto-generated method stub
		return new Invisibilidad(ubicacion,  new EntidadGraficaEstatica ("/resources/Vampiro/vampiroInvisibilidad.png"));
	}

	@Override
	public EntidadEstatica getVelocidad(Point ubicacion) {
		// TODO Auto-generated method stub
		return new Velocidad(ubicacion, new EntidadGraficaEstatica ("/resources/Vampiro/botellitaDeSangreOP.gif"));
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
            case 1: return "/src/resources/Musica/Dragula8bit.wav";
			case 2: return "/src/resources/Musica/Toccata 8 Bit.wav";
			case 3: return "/src/resources/Musica/Toccata 8 Bit.wav";
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

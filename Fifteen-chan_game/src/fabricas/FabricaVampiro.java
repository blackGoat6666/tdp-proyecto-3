package fabricas;

import EntidadesGraficas.EntidadDinamicaGrafica;
import EntidadesGraficas.EntidadGraficaConsumible;

public class FabricaVampiro implements FabricaEntidades {

	@Override
	public EntidadDinamicaGrafica getBlinky() {
		// TODO Auto-generated method stub
		return new EntidadDinamicaGrafica ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadDinamicaGrafica getInky() {
		// TODO Auto-generated method stub
		return new EntidadDinamicaGrafica ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadDinamicaGrafica getPinky() {
		// TODO Auto-generated method stub
		return new EntidadDinamicaGrafica ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadDinamicaGrafica getClyde() {
		// TODO Auto-generated method stub
		return new EntidadDinamicaGrafica ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadDinamicaGrafica getPersonaje() {
		// TODO Auto-generated method stub
		return new EntidadDinamicaGrafica ("/Images/vampiroadelantemoviendose.gif");
		
	}

	@Override
	public EntidadGraficaConsumible getDot() {
		// TODO Auto-generated method stub
		return new EntidadGraficaConsumible ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaConsumible getPowerPellet() {
		// TODO Auto-generated method stub
		return new EntidadGraficaConsumible ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaConsumible getFruit1() {
		// TODO Auto-generated method stub
		return new EntidadGraficaConsumible ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaConsumible getFruit2() {
		// TODO Auto-generated method stub
		return new EntidadGraficaConsumible ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaConsumible getFruit3() {
		// TODO Auto-generated method stub
		return new EntidadGraficaConsumible ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaConsumible getBomba() {
		// TODO Auto-generated method stub
		return new EntidadGraficaConsumible ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaConsumible getInvisibilidad() {
		// TODO Auto-generated method stub
		return new EntidadGraficaConsumible ("/Images/vampiroadelantemoviendose.gif");
	}

	@Override
	public EntidadGraficaConsumible getVelocidad() {
		// TODO Auto-generated method stub
		return new EntidadGraficaConsumible ("/Images/vampiroadelantemoviendose.gif");
	}
	
}

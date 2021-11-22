package Nivel;

import java.awt.Point;

import entidades.Bloque;
import entidades.Dot;
import entidades.EntidadGraficaEstatica;
import entidades.Gate;
import entidades.Ladrillo;
import entidades.PowerPellet;
import fabricas.FabricaEntidades;
import logica.LogicaColisiones;

public class Nivel1 extends NivelAbstracto{
	private int[][] matrizNivel;
	private LogicaColisiones miLogica;
	private int cantidadDots;
	
	public Nivel1 (LogicaColisiones log) {
		miLogica=log;
		matrizNivel = new int[][] {{2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2},
			{1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 1, 0, 1, 0, 0, 3, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 1, 1, 0, 3, 3, 3, 3, 0, 1, 1, 1, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
			{1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
			{0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
			{1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}};
	}
	
	public Bloque[][] getMatriz(FabricaEntidades fab) {
		Bloque [][] matriz = new Bloque [20][20];
		EntidadGraficaEstatica imagen;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				switch (matrizNivel[i][j]) {
				case 0:
					matriz[j][i] = new Bloque(new Ladrillo(null));
					break;
				case 1:
					cantidadDots++;
					imagen= fab.getDot();
					matriz[j][i] = new Bloque(new Dot(new Point( ((j+1)*30)+5, ((i+1)*30)+5 ), imagen));
					miLogica.graficar(imagen);
					break;
				case 2:
					imagen= fab.getPowerPellet();
					matriz[j][i] = new Bloque(new PowerPellet(new Point( ((j+1)*30)+5, ((i+1)*30) +5 ),imagen));
					miLogica.graficar(imagen);
					
					break;
				case 3:
					matriz[j][i] = new Bloque(new Gate(null));
					break;
				}
			}
	    }
		return matriz;
		
	}
	public int getDots() {
		return cantidadDots;
	}

}

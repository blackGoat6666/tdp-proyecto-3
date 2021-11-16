package Nivel;

import entidades.Bloque;
import entidades.Dot;
import entidades.Gate;
import entidades.Ladrillo;
import entidades.PowerPellet;

public class Nivel1 extends NivelAbstracto{
	private int [][] matrizNivel;
	
	public Nivel1 () {
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
	
	public Bloque [][] getMatriz () {
		Bloque [][] matriz = new Bloque [20][20];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				switch (matrizNivel[i][j]) {
				case 0:
					matriz[i][j] = new Bloque(new Ladrillo());
					break;
				case 1:
					matriz[i][j] = new Bloque(new Dot());
					break;
				case 2:
					matriz[i][j] = new Bloque(new PowerPellet());
					break;
				case 3:
					matriz[i][j] = new Bloque(new Gate());
					break;
				}
			}
	    }
		
		return matriz;
		
	}

}

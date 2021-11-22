package Nivel;

import entidades.Bloque;
import fabricas.FabricaEntidades;

public abstract class NivelAbstracto {
	public abstract Bloque[][] getMatriz(FabricaEntidades fab);
}

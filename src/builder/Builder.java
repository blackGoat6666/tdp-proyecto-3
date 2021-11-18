package builder;

import Nivel.Nivel;

public interface Builder {
	public void reset();
	public void setDots();
	public void setColisiones();
	public void setPowerPellets();
	public void setZonas();
	public void setFruits();
	public void setPotions();
	public Nivel getProduct();
}

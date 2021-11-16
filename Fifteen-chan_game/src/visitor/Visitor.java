package visitor;

import entidades.Bloque;
import entidades.Enemigo;
import entidades.Entidad;

public interface Visitor {

public void visitFantasma(Enemigo fantasma);	
 
public void visitPacman();
	
public void visitBloque(Bloque casillero);

public void visitDot();

public void visitFruit();

public void visitPowerPellet();

public void visitBomba();

public void visitInvisibilidad();

public void visitVelocidad();

public void visitEnemigo();

public void visitLadrillo();

public void visitGate();

public void visitBloqueVacio();
}

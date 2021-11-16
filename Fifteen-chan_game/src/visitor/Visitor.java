package visitor;

import entidades.Bloque;
import entidades.Dot;
import entidades.Enemigo;
import entidades.Entidad;

public interface Visitor {

public void visitBloque(Bloque casillero);

public void visitDot(Dot dot);

public void visitFruit();

public void visitPowerPellet();

public void visitBomba();

public void visitInvisibilidad();

public void visitVelocidad();

public void visitLadrillo();

public void visitGate();

public void visitBloqueVacio();

}

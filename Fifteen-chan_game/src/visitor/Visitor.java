package visitor;

import entidades.Bloque;
import entidades.Dot;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.Fruit;

public interface Visitor {

public void visitBloque(Bloque casillero);

public void visitDot(Dot dot);

public void visitFruit(Fruit fru);

public void visitFruit();

public void visitDot();

public void visitPowerPellet();

public void visitBomba();

public void visitInvisibilidad();

public void visitVelocidad();

public void visitLadrillo();

public void visitGate();

public void visitBloqueVacio();

}

package visitor;

import entidades.Bloque;
import entidades.Dot;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.Fruit;
import entidades.Gate;
import entidades.Ladrillo;
import entidades.PowerPellet;
import entidades.Velocidad;

public interface Visitor {

public void visitBloque(Bloque casillero);

public void visitDot(Dot dot);

public void visitFruit(Fruit fru);

public void visitPowerPellet(PowerPellet power);

public void visitBomba();

public void visitInvisibilidad();

public void visitVelocidad(Velocidad barry);

public void visitLadrillo();

public void visitGate();

public void visitBloqueVacio();

}

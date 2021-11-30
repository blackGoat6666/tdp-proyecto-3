package visitor;

import entidades.Bloque;
import entidades.Bomba;
import entidades.Dot;
import entidades.Entidad;
import entidades.Fruit;
import entidades.Gate;
import entidades.Invisibilidad;
import entidades.Ladrillo;
import entidades.PowerPellet;
import entidades.Velocidad;
import entidadesDinamicas.Enemigo;

public interface Visitor {

public void visitBloque(Bloque casillero);

public void visitDot(Dot dot);

public void visitFruit(Fruit fru);

public void visitPowerPellet(PowerPellet power);

public void visitBomba(Bomba bombastic);

public void visitInvisibilidad(Invisibilidad invi);

public void visitVelocidad(Velocidad barry);

public void visitLadrillo();

public void visitGate();

public void visitBloqueVacio();

}

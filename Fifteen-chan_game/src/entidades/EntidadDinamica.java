<<<<<<< Updated upstream
package entidades;

import java.awt.Point;

public abstract class EntidadDinamica extends Entidad {

public abstract Boolean colisiona(Point ubicacion);

public abstract void resetear();

public abstract void comido();

public abstract void mover();


	
}
=======
package entidades;

import java.awt.Point;

public abstract class EntidadDinamica extends Entidad {

public abstract void resetear();

public abstract void comido();

public abstract void mover();

public abstract void morir();
	
}
>>>>>>> Stashed changes

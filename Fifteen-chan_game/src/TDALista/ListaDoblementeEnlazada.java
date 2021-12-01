package TDALista;

import java.util.Iterator;

/**
 * Implementacion de la interfaz PositionList utilizando nodos doblemente enlazados, y sin nodos centinelas.
 * @author Dominguez,Chanqueo.
 *
 * @param <E> Tipo genérico de los elementos de la lista.
 */
public class ListaDoblementeEnlazada<E> implements PositionList<E> {
	/**
	 *  Clase auxiliar que permite el funcionamiento de la lista doblemente enlazada
	 * @author Dominguez,Chanqueo.
	 *
	 * @param <E> Tipo generico del dato que se almacena en los nodos.
	 */
	private class DNodo<E> implements  Position<E> {
		private E elemento;
		private DNodo<E> siguiente;
		private DNodo<E> anterior;
		 
		/**
		 * instancia un nuevo nodo.
		 * @param e elemento del nodo.
		 * @param sig nodo siguiente al nodo construido.
		 * @param ant nodo anterior al nodo construido.
		 */
		 public DNodo(E element, DNodo<E> ant, DNodo<E> sig) {
			elemento=element;
			siguiente=sig;
			anterior=ant;
		   }
		 /**
		  * Constructor. Crea un nodo sin nodo previo ni posterior.
		  * @param element elemento que guarda el nodo.
		  */
		  public DNodo(E element) {
			 this(element, null,null);  	
		   }
		 
		  /**
		   * Cambia el elemento que guarda el nodo en su interior.
		   * @param ele: elemento a guardar.
		   */
		 public void setElemento(E elem) {
			this.elemento=elem;
		  }
		 /**
		  * Establece el nodo siguiente.
		  * @param sig nodo siguiente.
		  */
		 public void setSiguiente(DNodo<E> sig) {
			this.siguiente=sig; 
		  }
		 /**
		  * Establece el nodo anterior.
		  * @param ant nodo anterior.
		  */
		 public void setAnterior(DNodo<E> ant) {
			this.anterior=ant; 
		 }
		 /**
		  * Consulta cual es el nodo siguiente.
		  * @return nodo siguiente.
		  */
		 public DNodo<E> getSiguiente(){
			return this.siguiente; 
		  }
		 /**
		  * Consulta cual es el nodo anterior.
		  * @return nodo anterior.
		  */
		
		 public DNodo<E> getAnterior(){
			 return this.anterior;
		 }
		 /**
		  * Consulta cual es el elemento que guarda el nodo.
		  * @return elemento del nodo.
		  */
		 public E element() {
		    return elemento; 
		  }
		}

	
	protected DNodo<E> cabeza;
	protected DNodo<E> cola;
	protected int tamaño;
	/**
	 * instancia una nueva lista doblemente enlazada de tamaño 0.
	 */
	public ListaDoblementeEnlazada() {
		tamaño=0;
	}
	
	public int size() {
		
		return tamaño;
	}

	
	public boolean isEmpty() {
		
		return (tamaño==0);
	}

	
	public Position<E> first() throws EmptyListException {
		if(this.isEmpty()) {
			 throw new EmptyListException("La lista esta vacia");	
		}
		return cabeza;
	}
	
	public Position<E> last() throws EmptyListException {
		if(this.isEmpty()) {
			 throw new EmptyListException("La lista esta vacia");	
		}
		return cola;	
	}
	
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		
		DNodo<E> n=checkPosition(p);
		if(n.getSiguiente()==null) {
			throw new BoundaryViolationException("no tiene siguiente");
		}
		return n.getSiguiente();
	}

	
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> n=checkPosition(p);
		if(n.getAnterior()==null) {
			throw new BoundaryViolationException("No tiene anterior");
		}
		return n.getAnterior();
	}

	
	public void addFirst(E element) {
		if(this.isEmpty()) {
			DNodo<E> aux=new DNodo<E>(element);
			cabeza=aux;
			cola=aux;
		}
		else {
			DNodo<E> aux= new DNodo<E>(element,null,cabeza);
			cabeza.setAnterior(aux);
			cabeza=aux;
		}
		tamaño++;
	}

	
	public void addLast(E element) {
		if(this.isEmpty()) {
			DNodo<E> aux=new DNodo<E>(element);
			cabeza=aux;
			cola=aux;
		}
		else {
			DNodo<E> aux= new DNodo<E>(element,cola,null);
			cola.setSiguiente(aux);
			cola=aux;
		}
		tamaño++;
	}
	
	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> busco= checkPosition(p);
		if(busco==cola) {
		  this.addLast(element);
		}
		else {
		  DNodo<E> aux= new DNodo<E>(element,busco,busco.getSiguiente());
		  (busco.getSiguiente()).setAnterior(aux);
		  busco.setSiguiente(aux);
		}
		tamaño++;
	}

	
	public void addBefore(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> busco= checkPosition(p);
		if(busco==cabeza) {
		  this.addFirst(element);
		}
		else {
		  DNodo<E> aux= new DNodo<E>(element,busco.getAnterior(),busco);
		  (busco.getAnterior()).setSiguiente(aux);
		  busco.setAnterior(aux);
		}
	    tamaño++;
	}
	
	public E remove(Position<E> p) throws InvalidPositionException {
		if(this.isEmpty()) {
	      throw new InvalidPositionException("La lista esta vacia.");
		}
		DNodo<E> busco= checkPosition(p);
		if(busco!=cola || busco!=cabeza) {
		  if(busco==cola) {
		       (busco.getAnterior()).setSiguiente(null);
		       cola=busco.getAnterior();
		   }
		  else {
			if (busco==cabeza) {
				busco.getSiguiente().setAnterior(busco.getAnterior());  
				cabeza=busco.getSiguiente();
			}
		    else {
	         busco.getAnterior().setSiguiente(busco.getSiguiente());
		     busco.getSiguiente().setAnterior(busco.getAnterior());
		    }
		  }
		}
		else {
		  cabeza=null;
		  cola=null;
		}
		busco.setAnterior(null);
		busco.setSiguiente(null);
		tamaño--;
		return (E) busco.element();
	}
	
	public E set(Position<E> p, E element) throws InvalidPositionException {
		if(this.isEmpty()) {
		  throw new InvalidPositionException("La lista esta vacia.");	
		}
		DNodo<E> busco= checkPosition(p);
		E retorno= busco.element();
		busco.setElemento(element);
		return retorno;
	}

	
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}

	
	public Iterable<Position<E>> positions() {
		Iterable<Position<E>> retorno= new ListaDoblementeEnlazada();
		if(this.isEmpty()) {
		  return retorno;	
		}
		DNodo<E> cursor=this.cabeza;
		while(cursor!=cola) {
		  ((PositionList<Position<E>>) retorno).addLast(cursor);
		  cursor=cursor.getSiguiente();
		}
		((PositionList<Position<E>>) retorno).addLast(cursor); 
		return retorno;
	}
	/**
	 * utiliza un try-catch para asegurarse de que p pertenece a la lista o no
	 * @return un DNodo<E> de la posición pasada por parametro.
	 * @param p posición la cual se fija si pertenece a la lista.
	 * @throws InvalidPositionException en caso de que p sea nulo, haya sido eliminado de la lista, o que nunca haya pertenecido a la misma.
	 * 
	 */
	private DNodo<E> checkPosition( Position<E> p )throws InvalidPositionException {
		try {
			if( p == null ) {
				throw new InvalidPositionException("Posición nula");
			}
			if (p.element() == null) { 
				throw new InvalidPositionException("p eliminada previamente");
			}
			return (DNodo<E>) p;
		} 
		catch( ClassCastException e ) {
		throw new InvalidPositionException( "p no es un nodo de lista");
		}
	}
   
}

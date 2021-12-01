package TDALista;
import java.lang.*;
import java.util.*;
/**
 * Crea un iterador a partir de una lista.
 * @author Dominguez,Chanqueo.
 *
 * @param <E> Parametro generico del iterador.
 */
public class ElementIterator<E> implements java.util.Iterator<E> {
 protected PositionList<E> list;
 protected Position<E> cursor;
 /**
  * Instancia un nuevo ElementIterator a partir de una PositionList.
  * @param l lista a partir de la cual se construira el iterador.
  */
 public ElementIterator (PositionList<E> l) {
	list=l;
	if(list.isEmpty()) {
	   cursor=null;	
	 }
	else {
	   try {
		cursor=list.first();
	} catch (EmptyListException e) {
		
		e.printStackTrace();
	  }
	}
  }
 
 public boolean hasNext() {
   return (cursor!=null);
 }
 
 public E next(){
	  if(cursor==null) {
		  return null;  
	   }
	  E toReturn=cursor.element();
	  try {
		cursor= (cursor==list.last())? null: list.next(cursor);
	} catch (EmptyListException| InvalidPositionException| BoundaryViolationException e) {
	
		e.printStackTrace();
	} 
	 return toReturn;
 }
}
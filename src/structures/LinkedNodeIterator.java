package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedNodeIterator<T> implements Iterator<T>{

	private Node<T> next;
	
	// Constructors
	  public LinkedNodeIterator(Node<T> link) {
		  next = link;
	  }
	  
	@Override
	public boolean hasNext() {
		return (next!=null);
	}

	@Override
	public T next() throws NoSuchElementException{
		//Taken directly from my code used in the project SETS
		if (hasNext()) {
			T curr = next.getData();
			next = next.getNext();
			return curr;
		}
		else throw new NoSuchElementException();
		
	}
	
	@Override
	  public void remove() {
	    throw new UnsupportedOperationException();
	  }

}

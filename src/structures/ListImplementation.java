package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImplementation<T> implements ListInterface<T>{

	int size = 0;
	Node<T> head = null;
	Node<T> tail = null;
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head==null);
	}

	@Override
	public T get(int n) throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(n >= size() || n < 0)
			throw new NoSuchElementException();
		Node<T> curr = head;
		int stop = 0;
		while(curr != null){
			if(stop == n)
				return curr.getData();
			stop++;
			curr = curr.getNext();
		}
		return null;
	}

	@Override
	public ListInterface<T> append(T elem) throws NullPointerException{
		// TODO Auto-generated method stub
		Node<T> append = new Node<T>(elem, null);
		if(elem == null)
			throw new NullPointerException();
		if(head == null){
			head = append;
			tail = append;
		} 
		else {
			tail.setNext(append);
			tail = tail.getNext();
		}
		size++;
		return this;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedNodeIterator<T>(this.head);
	}
}

package generics;

public class TurnNode<T> {
	//Attributes
	private T date;
	private int nTimePassed;
	private TurnNode<T> next, prev;
	
	
	public TurnNode(T date) {
		this.date = date;
		nTimePassed = 0;
	}
	
	//
	// GETTERS AND SETTERS
	//
	
	public T getDate() {
		return date;
	}

	public int getNTimePassed() {
		return nTimePassed;
	}
	
	public void plusDate() {
		nTimePassed = nTimePassed+1;
	}

	public TurnNode<T> getNext() {
		return next;
	}

	public void setNext(TurnNode<T> next) {
		this.next = next;
	}

	public TurnNode<T> getPrev() {
		return prev;
	}

	public void setPrev(TurnNode<T> prev) {
		this.prev = prev;
	}
		

	public String toStringNode(TurnNode<T> first) {
		String out = "";
		if(next != first) {
			out += date+","+next.toStringNode(first);			
		}
		else {
			out += date;
		}
		return out;
	}

}

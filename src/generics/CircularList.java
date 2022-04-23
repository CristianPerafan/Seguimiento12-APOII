package generics;

public class CircularList<T> {
	//Attributes
	@SuppressWarnings("unused")
	private TurnNode<T> first,last;
	
	public CircularList() {
		
	}
	
	public void add(T date) {
		if(first == null) {
			first = new TurnNode<T>(date);
			last = first;
			first.setNext(last);
			first.setPrev(last);
			last.setNext(first);
			last.setPrev(first);
		}
		else {
			TurnNode<T> temp = new TurnNode<T>(date);
			last.setNext(temp);
			temp.setPrev(last);
			temp.setNext(first);
			first.setPrev(temp);
			last = temp;
		}
	}
	
	public int moveFirstToEnd() {
		int out = 1;
		
		if(!(first == last)) {
			if(first.getNTimePassed() == 2) {
				if(deleteFirst()) {
					out = 2;
				}
			}else {
				first.plusDate();
				last.setNext(first);
				last.getNext().setPrev(last);
				last = first;
				first = first.getNext();
				last.setNext(first);
				first.setPrev(last);
				out = 3;
			}
			
			
		}
		
		return out;
	}
	
	public boolean deleteFirst() {
		boolean out = false;
		
		if(first != null) {
			if(first == last) {
				first = null;
				last = null;
				out = true;
			}
			else{
				
				first.getNext().setPrev(last);
				last.setNext(first.getNext());
				first = first.getNext();	
				out = true;
			}
		
		}
		
		
		return out;
		
	}


	//
	// GETTERS AND SETTERS
	//
	public TurnNode<T> getFirst() {
		return first;
	}

	public void setFirst(TurnNode<T> first) {
		this.first = first;
	}

	public TurnNode<T> getLast() {
		return last;
	}

	public void setLast(TurnNode<T> last) {
		this.last = last;
	}
	
	public String toShowList() {
		String out = "";
		if(first == null) {
			out = "There are no turns";
		}else {
			out += "["+first.toStringNode(first)+"]";
			
		}
		
		
		return out;
	}
	
	
}


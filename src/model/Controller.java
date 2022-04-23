package model;

import generics.CircularList;

public class Controller {
	//Attributes
	private int counter;
	private CircularList<Integer> list;
	private int currentTurn;
	
	public Controller() {
		list = new CircularList<Integer>();
		counter = 1;
	}
	
	public void setUpCounterTurn() {
		if(list.getFirst() != null) {
			counter++;
		}
	}
	
	public void addAnElement(Integer value) {
		list.add(value);
	}
	
	public String deleteCurrentTurn() {
		String out = "";
		if(list.deleteFirst()) {
			out = "The turn has been deleted";
		}
		else {
			out = "There are no turns to delete";
		}
		
		return out;
		
	}
	
	public String showMap() {
		return list.toShowList();
	}
	
	public String showCurrenTurn() {
		
		String out = "";
		

		currentTurn = list.getFirst().getDate();
		if(list.getFirst() == null) {
			out = "The are no turns";
		}
		else {
			out = "The current turn is:"+currentTurn;
		}
		
		
		
		
		
		return out;
	}
	
	
	public String passTurn() {
		String out = "";
		int ans = list.moveFirstToEnd();
		
		switch(ans) {
		case 1: 
			out = "There is only one turn";
			break;
		case 2:
			out = "The turn was deleted because it was passed more of two times";
			break;
		case 3:
			out = "The turn has been passed";
			break;
		}
		
		return out;
		
	}
	//
	// === GETTERS AND SETTERS ===
	//
	
	public int getCurrentTurn() {
		return counter;
	}
}


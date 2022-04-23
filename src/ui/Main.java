package ui;

import java.util.Scanner;

import model.Controller;

public class Main {
	
	//Attributes
	private Scanner sc;
	private Controller controller;
	@SuppressWarnings("unused")
	private int counter;
	
	public Main() {
		sc = new Scanner(System.in);
		controller = new Controller();
	}
	
	public static void main(String [] args) {
		Main pc = new Main();
		
		System.out.println("***BANCOLOMBIA***");
		
		int option = 0;
		do {
			option = pc.ShowMenu();
			pc.executeOperation(option);
			
		}while(option != 0);
	}
	
	public int ShowMenu() {
		
		int option = 0;
		System.out.println("Menu:\n"+
				"(1) Give turn\n"+
				"(2) Show turn\n"+
				"(3) Pass turn\n"+
				"(4) Delete current turn\n"+
				"(5) Show line of people\n"+
				"(0) Exit");
		
		option = sc.nextInt();
		sc.nextLine();
		
		return option;
	}
	
	public void executeOperation(int option) {
		switch(option) {
		case 0:
			System.out.println("Bye see you soon....");
			break;
		case 1:
			toGiveTurn();
			break;
		case 2:
			toShowCurrentTurn();
			break;
		case 3:
			toPassTurn();
			break;
		case 4:
			toDeleteCurrentTurn();
			break;
		case 5:
			System.out.println(controller.showMap());
			break;
		default:
			System.out.println("No valid option!!!");
			break;
		}
	}
	
	public void toGiveTurn() {
		controller.setUpCounterTurn();
		int turn = controller.getCurrentTurn();
		controller.addAnElement(turn);
		
	}
	
	public void toShowCurrentTurn() {
		System.out.println(controller.showCurrenTurn());
	}
	
	public void toDeleteCurrentTurn() {
		System.out.println(controller.deleteCurrentTurn());
	}
	
	public void toPassTurn() {
		System.out.println(controller.passTurn());
	}
	
}

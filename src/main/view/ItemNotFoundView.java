package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class ItemNotFoundView implements View {

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOptions() {
		System.out.println("Item non trovato, premere invio per tornare al menù");
		
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();		
	}

	@Override
	public void submit() {
		Request request= new Request();
		request.put("mode", "ItemMenu");
		MainDispatcher.getInstance().callAction("Menu", "doControl", request);
	}

}

package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class DeleteFormView implements View {
	
	int id;

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOptions() {
		System.out.println("inserisci l'id del item da cancellare");
		id=Integer.parseInt(getInput());
		
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		Request request = new Request();
		request.put("id", id);
		request.put("mode", "DeleteItem");
    	MainDispatcher.getInstance().callAction("Item", "doControl", request);

		
	}

}

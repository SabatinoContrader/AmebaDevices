package main.view;

import main.controller.Request;

import java.util.Scanner;

import main.MainDispatcher;
import main.model.Item;

public class ItemUpdateFormView implements View {

	Item item;
	int id;
	String categoria,marca,modello;
	
	@Override
	public void showResults(Request request) {
		
		if(request != null) {
			item=(Item) request.get("item");
		}	
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci id dell'item da modificare");
		id=Integer.parseInt(getInput());
		System.out.println("inserisci nuova categoria o invio per non modificare: ");
		this.categoria=getInput();
		System.out.println("inserisci nuova marca o invio per non modificare: ");
		this.marca=getInput();
		System.out.println("inserisci nuovo modello o invio per non modificare: ");
		this.modello=getInput();
		item = new Item(categoria, modello, marca);
		item.setId(id);
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		Request request = new Request();
		request.put("mode", "UpdateForm");
		request.put("item", item);
		MainDispatcher.getInstance().callAction("Item", "doControl", request);
	}

}

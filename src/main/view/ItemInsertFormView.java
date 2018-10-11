package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Item;
import main.dao.ItemDao;
import main.service.ItemService;

public class ItemInsertFormView implements View {
	int id;
	String categoria,marca,modello;
	Item item;
	List<Item> items;
	String mode="";
	Item item1;
	
	@Override
	public void showResults(Request request) {
		
		}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci i dati del nuovo item");
		System.out.println("Categoria:");
		this.categoria = getInput();
		System.out.println("Marca:");
		this.marca = getInput();
		System.out.println("Modello");
		this.modello = getInput();
		item = new Item(categoria, marca, modello);
		
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();	
	}

	@Override
	public void submit() {
		Request request= new Request();
		request.put("item", item);
		request.put("mode", "InsertForm");
		MainDispatcher.getInstance().callAction("Item", "doControl", request);
	}

}

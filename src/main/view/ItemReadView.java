package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Item;

public class ItemReadView implements View {
	List<Item> items;
	
	@Override
	public void showResults(Request request) {
		items = (List<Item>) request.get("items");
		System.out.println("------ Item Disponibili -----");
		
	}

	@Override
	public void showOptions() {
		items.forEach(c-> System.out.println(c.getId()+"-"+c.getCategoria()+"-"+c.getModello()+"-"+c.getMarca()));
				
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		Request request= new Request();
		request.put("mode", "Return");
		MainDispatcher.getInstance().callAction("Item", "doControl", request);
	}

}

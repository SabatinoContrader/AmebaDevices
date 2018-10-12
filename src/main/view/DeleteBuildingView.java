package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Building;

public class DeleteBuildingView implements View {

	private Request request;
	private List<Building> buildings;
	private String username;
	
	@Override
	public void showResults(Request request) {
		username=request.get("username").toString();
		buildings= (List<Building>) request.get("buildings");
		
		System.out.println("----------ciao, " + username + " questi sono i tuoi buildings ----------");
		if (buildings.size() == 0)
			System.out.println(" ");
		for (int i = 0; i < buildings.size(); i++) {
			System.out.println(i + 1 + ") " + buildings.get(i).getIndirizzo() + " " + buildings.get(i).getCap()
					+ " " + buildings.get(i).getCitta() + " " + buildings.get(i).getInterno());
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Quale building vuoi eliminare?");
		int pos = Integer.parseInt(this.getInput());
		pos--;
		while (pos < 0 || pos > buildings.size()) {
			System.out.println("Posizione non valida");
			pos = Integer.parseInt(this.getInput());
			pos--;
		}
		request = new Request();
		request.put("toDeleteBuilding", buildings.get(pos));
		request.put("username", username);
		
	}
	
	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}


	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("DeleteBuilding", "doControl", request);
	}

}

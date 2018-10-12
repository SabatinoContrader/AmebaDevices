package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Building;

public class UpdateBuildingView implements View {

	private Request request;
	private String username;
	private Building newValues;
	private List<Building> buildings;
	
	@Override
	public void showResults(Request request) {
		this.request=request;
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
		System.out.println("Quale building vuoi modificare?");
		System.out.println("");
		int pos = Integer.parseInt(this.getInput());
		pos--;
		while (pos < 0 || pos > buildings.size()) {
			System.out.println("Posizione non valida");
			pos = Integer.parseInt(this.getInput());
			pos--;
		}
		 request = new Request();
		newValues=new Building();
		System.out.println("Inserisci indirizzo del building (attuale "+buildings.get(pos).getIndirizzo()+") : ");
		newValues.setIndirizzo(this.getInput());
		System.out.println("Inserisci interno del building (attuale "+buildings.get(pos).getInterno()+") : ");
		newValues.setInterno(this.getInput());
		System.out.println("Inserisci citta' del building: (attuale "+buildings.get(pos).getCitta()+") : ");
		newValues.setCitta(this.getInput());
		System.out.println("Inserisci cap del building:  (attuale "+buildings.get(pos).getCap()+") : ");
		newValues.setCap(this.getInput());
		request.put("toUp", buildings.get(pos));
		request.put("newValues", newValues);
		request.put("username", username);
		MainDispatcher.getInstance().callAction("UpdateBuilding", "doControl", request);
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}


	@Override
	public void submit() {
		// TODO Auto-generated method stub

	}

}

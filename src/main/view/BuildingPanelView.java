package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Building;

public class BuildingPanelView implements View {

	private String mode;
	private String username;
	private List<Building> buildings;

	@Override
	public void showResults(Request request) {

		this.mode = request.get("mode").toString();
		this.username = request.get("username").toString();
		this.buildings = (List<Building>) request.get("buildings");
		if (buildings != null) {
			System.out.println("----------ciao, " + username + " questi sono i tuoi buildings ----------");
			if (buildings.size() == 0)
				System.out.println(" ");
			for (int i = 0; i < buildings.size(); i++) {
				System.out.println(i + 1 + ") " + buildings.get(i).getIndirizzo() + " " + buildings.get(i).getCap()
						+ " " + buildings.get(i).getCitta() + " " + buildings.get(i).getInterno());
			}
		} else
			System.out.println("Non hai ancora nessuna building");

	}

	@Override
	public void showOptions() {
		if (mode.equals("create")) {
			System.out.println("Stai creando un nuovo building");
		} else if (mode.equals("update")) {
			System.out.println("Scegli building da modificare:");
		} else if (mode.equals("delete")) {
			System.out.println("Scegli building da cancellare:");
		} else { // caso read (o casi erroneamente arrivati sbagliati)
			System.out.println("Opzioni: ");
			System.out.println("1) TORNA ALLA HOME");
			System.out.println("2) LOGOUT");

		}

	}

	@Override
	public void submit() {

		if (mode.equals("create")) {
			System.out.println("Inserisci indirizzo del building: ");
			String address = this.getInput();
			System.out.println("Inserisci interno del building");
			String interno = this.getInput();
			System.out.println("Inserisci citta' del building: ");
			String city = this.getInput();
			System.out.println("Inserisci cap del building: ");
			String cap = this.getInput();
			Request myNewBuildingrequest = new Request();
			myNewBuildingrequest.put("address", address);
			myNewBuildingrequest.put("city", city);
			myNewBuildingrequest.put("cap", cap);
			myNewBuildingrequest.put("username", username);
			myNewBuildingrequest.put("interno", interno);
			MainDispatcher.getInstance().callAction("CreateBuilding", "doControl", myNewBuildingrequest);
		} else if (mode.equals("update")) {
			int pos = Integer.parseInt(this.getInput());
			pos--;
			while (pos < 0 || pos > buildings.size()) {
				System.out.println("Posizione non valida");
				pos = Integer.parseInt(this.getInput());
				pos--;
			}
			Request updateRequest = new Request();
			Building newValues = new Building();
			System.out.println("Inserisci indirizzo del building (attuale "+buildings.get(pos).getIndirizzo()+") : ");
			newValues.setIndirizzo(this.getInput());
			System.out.println("Inserisci interno del building (attuale "+buildings.get(pos).getInterno()+") : ");
			newValues.setInterno(this.getInput());
			System.out.println("Inserisci citta' del building: (attuale "+buildings.get(pos).getCitta()+") : ");
			newValues.setCitta(this.getInput());
			System.out.println("Inserisci cap del building:  (attuale "+buildings.get(pos).getCap()+") : ");
			newValues.setCap(this.getInput());
			updateRequest.put("toUp", buildings.get(pos));
			updateRequest.put("newValues", newValues);
			updateRequest.put("username", username);
			MainDispatcher.getInstance().callAction("UpdateBuilding", "doControl", updateRequest);

		} else if (mode.equals("delete")) {
			int pos = Integer.parseInt(this.getInput());
			pos--;
			System.err.println(pos+ " buildings.size = "+buildings.size());
			while (pos < 0 || pos > buildings.size()) {
				System.out.println("Posizione non valida");
				pos = Integer.parseInt(this.getInput());
				pos--;
			}
			Request deleteRequest = new Request();
			deleteRequest.put("toDeleteBuilding", buildings.get(pos));
			deleteRequest.put("username", username);
			MainDispatcher.getInstance().callAction("DeleteBuilding", "doControl", deleteRequest);
		} else // caso read (o casi erroneamente arrivati sbagliati)
		{
			int fromUser = Integer.parseInt(this.getInput());
			while (fromUser != 1 && fromUser != 2) {
				System.out.println("Scelta sbagliata, prego reinserire: ");
				fromUser = Integer.parseInt(this.getInput());
			}
			Request homeRequest = new Request();
			switch (fromUser) {
			case 1:
				homeRequest.put("nomeUtente", username);
				homeRequest.put("alreadyLogged", "y");
				homeRequest.put("choice", 2);
				MainDispatcher.getInstance().callAction("Home", "doControl", homeRequest);
				break;
			case 2:
				MainDispatcher.getInstance().callAction("Login", "doControl", null);
				break;
			default:
				homeRequest = new Request();
				homeRequest.put("nomeUtente", username);
				homeRequest.put("alreadyLogged", "y");
				homeRequest.put("choice", 2);
				MainDispatcher.getInstance().callAction("Home", "doControl", homeRequest);
				break;
			}
		}

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}

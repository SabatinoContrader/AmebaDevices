package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class LoginView implements View {

    private String nomeUtente;
    private String password;
    private String choice;

    public void showResults (Request request) {

    }


    public void showOptions () {
        System.out.println("-----LOGIN----");
        System.out.println("1) SuperUser");
        System.out.println("2) Customer");
        choice= getInput();
        System.out.println("Nome utente:");
        nomeUtente = getInput();
        System.out.println("Password:");
        password = getInput();
    }

    public void submit() {
        Request request = new Request();
        request.put("nomeUtente", nomeUtente);
        request.put("password", password);
        request.put("choice", choice);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);
    }


    public String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    protected void send () {
    }


}

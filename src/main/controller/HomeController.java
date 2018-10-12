package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class HomeController implements Controller {

    private LoginService loginService;

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            int choice= Integer.parseInt(request.get("choice").toString());
            if (loginService.login(nomeUtente, password,choice)) {
            	if(choice==1)
            		MainDispatcher.getInstance().callView("SuperUserHome", request);
            	else
            	{
            		request.put("username", nomeUtente);
            		MainDispatcher.getInstance().callView("CustomerHome", request);
            	}
             }
            else
                MainDispatcher.getInstance().callAction("Login", "doControl", request);

    }
}

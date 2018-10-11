package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class HomeController implements Controller {

    private LoginService loginService;

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
        if (request != null &&  request.get("alreadyLogged") == null ) {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            int choice= Integer.parseInt(request.get("choice").toString());
            if (loginService.login(nomeUtente, password,choice)) 
                MainDispatcher.getInstance().callView("Home", request);
            else
                MainDispatcher.getInstance().callAction("Login", "doControl", request);
        } else if (request != null && request.get("alreadyLogged")!= null && request.get("alreadyLogged").equals("y")) 
        				MainDispatcher.getInstance().callView("Home", request); 
        
        else MainDispatcher.getInstance().callView("Home", null);

    }
}

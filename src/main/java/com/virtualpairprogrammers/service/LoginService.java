package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.LoginDAO;

public class LoginService {

    private LoginDAO loginDAO;

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public boolean login (String username, String password,int choice) {
        return this.loginDAO.login(username, password,choice);
    }
}

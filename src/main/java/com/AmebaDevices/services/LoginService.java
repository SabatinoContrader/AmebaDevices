package com.AmebaDevices.services;

import com.AmebaDevices.dao.LoginDAO;

public class LoginService {

    private LoginDAO loginDAO;

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public int login (String username, String password) {
        return this.loginDAO.login(username, password);
    }
}

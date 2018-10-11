package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDAO {

    private final String QUERY_LOGIN_CUSTOMER = "select * from customer where username = ? and password = ?";
    private final String QUERY_LOGIN_SUPERUSER = "select * from superuser where username = ? and password = ?";
    
    public boolean login (String username, String password, int choice) {
    	PreparedStatement statement=null;
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	if(choice==1) {
             statement = connection.prepareStatement(QUERY_LOGIN_SUPERUSER);
            }else if(choice==2) {
             statement = connection.prepareStatement(QUERY_LOGIN_CUSTOMER);
            }
            statement.setString(1, username);
            statement.setString(2, password);
            return statement.executeQuery().next();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
}

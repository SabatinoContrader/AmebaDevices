package com.AmebaDevices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.AmebaDevices.utils.ConnectionSingleton;
import com.AmebaDevices.utils.GestoreEccezioni;


public class LoginDAO {

    private final String QUERY_LOGIN = "select * from user where username = ? and password = ?";
    public int login (String username, String password) {
    	PreparedStatement statement=null;
        Connection connection = ConnectionSingleton.getInstance();
        try {
        	
             statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
            	return rs.getInt("user_role");
            }
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return 0;
        }
        return 0;
    }
}
<<<<<<< Updated upstream
package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

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
=======
package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class LoginDAO {

    private final String QUERY_LOGIN_CUSTOMER = "select * from user where username = ? and password = ?";
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
>>>>>>> Stashed changes

package com.pCarpet.dao;
import com.pCarpet.utils.ConnectionSingleton;
import com.pCarpet.utils.GestoreEccezioni;
import com.pCarpet.model.Badge;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;
@Repository
public class BadgeRepository {
	String param="";
	
	private final String QUERY_ALL = "select * from badge";
    private final String QUERY_INSERT = "insert into badge (idbadge,tipologia,descrizione) values (?,?,?)";
    private final String QUERY_DEL = "delete from badge where idbadge = ?";
private final String QUERY_ALLBADGEN ="select idbadge,descrizione,tipologia from badge where badge.idbadge NOT IN (SELECT b.idbadge from badge AS b,assegnazione as a where a.idbadge=b.idbadge)";
    /* query ALL_BADGE_SSN da modificare in base alla relazione movimento
   // private final String QUERY_ALLBADGEASSN = "select b.idbadge,tipologia,descrizione from userasset as o right join asset as b on o.idasset=b.idasset where o.idasset is null";
	*/
    public BadgeRepository() {
    	
    }
	
    public List<Badge> getAllBadges () {
        List<Badge> badges = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
        	   int idBadge = resultSet.getInt("idbadge");
        	   String tipologia = resultSet.getString("tipologia");
               String descrizione = resultSet.getString("descrizione");
               badges.add(new Badge(idBadge,tipologia,descrizione));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return badges;
    }
    
    public Badge getBadge (int id) {
        Badge badges=null;
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select * from badge where idbadge="+id);
           while (resultSet.next()) {
        	   int idBadge = resultSet.getInt("idbadge");
        	   String tipologia = resultSet.getString("tipologia");
               String descrizione = resultSet.getString("descrizione");
               badges =new Badge(idBadge,tipologia,descrizione);
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return badges;
    }

   public List<Badge> getAllBadgesN () {
        List<Badge> badges = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLBADGEN);
           while (resultSet.next()) {
        	   int idBadge = resultSet.getInt("idbadge");
        	   String tipologia = resultSet.getString("tipologia");
               String descrizione = resultSet.getString("descrizione");
               badges.add(new Badge(idBadge,tipologia,descrizione));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return badges;
    }

    /*
    //query ALLBADGEASSN da verificare in base a movimento
    public List<Badge> getAllBadgesN () {
        List<Badge> badges = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLBADGEASSN);
           while (resultSet.next()) {
        	   int idBadge = resultSet.getInt("idbadge");
        	   String tipologia = resultSet.getString("tipologia");
               String descrizione = resultSet.getString("descrizione");
               badges.add(new Badge(idBadge,tipologia,descrizione));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return badges;
    }
    */
    public boolean insertBadge(Badge badge) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, "0");
            preparedStatement.setString(2, badge.getTipologia());
            preparedStatement.setString(3, badge.getDescrizione());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean DeleteBadge(int idBadge) {
    	Connection connection = ConnectionSingleton.getInstance();
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DEL);
            preparedStatement.setInt(1,idBadge);
            preparedStatement.execute();
            return true;
    }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }	
    }
    
    public boolean UpdateBadge(HttpServletRequest request) {
   	 Connection connection = ConnectionSingleton.getInstance();
        try {
        	
        	param=(String)request.getParameter("campo");
       	 int id=Integer.parseInt(request.getParameter("id1"));
       	//System.out.println(id);
        	PreparedStatement preparedStatement = connection.prepareStatement("update badge set "+param+"=? where idbadge=?");
            
        	preparedStatement.setString(1, request.getParameter("nuovoCampo"));
        	preparedStatement.setInt(2,id);
       //     preparedStatement.setInt(2, Integer.parseInt(request.getParameter("id")));
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
   	
   }
}
package main.dao;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ItemDao {
	//private final String QUERY_UPDATE="update item set categoria=?,marca=?,modello=? where id=?";
	private final String QUERY_INSERT="insert into amebadevicesdb.item(categoria,marca,modello) values(?,?,?)";
	private final String QUERY_READ = "select * from amebadevicesdb.item";
	private final String QUERY_SEARCH="select * from amebadevicesdb.item where id=?";
	private final String QUERY_UPDATE="update amebadevicesdb.item set categoria=?,marca=?,modello=? where id=?";
	private final String QUERY_DELETE="delete from amebadevicesdb.item where id=?";
	public ItemDao() {
		
	}
	
	public List<Item> getAllItem () {
        List<Item> items = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_READ);
           while (resultSet.next()) {
        	   int id= resultSet.getInt("id");
               String categoria = resultSet.getString("categoria");
               String marca = resultSet.getString("marca");
               String modello = resultSet.getString("modello");
               Item item= new Item(categoria,marca,modello);
               item.setId(id);
               items.add(item);
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
	
	public boolean insertItem(Item item) {
		Connection connection= ConnectionSingleton.getInstance();
        try {
      
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            
            preparedStatement.setString(1, item.getCategoria());

            preparedStatement.setString(2, item.getMarca());
            
            preparedStatement.setString(3, item.getModello());
           

            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
	
	public Item searchItem (int id) {
		Connection connection= ConnectionSingleton.getInstance();
		Item item=null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SEARCH);
            
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            if(resultSet.next()) {
            	String categoria= resultSet.getString("categoria");
            	String marca= resultSet.getString("marca");
            	String modello= resultSet.getString("modello");
            	item= new Item(categoria,marca,modello);
            	item.setId(id);
            } else {
            	//System.out.println("abcd");
            	item = null;
            }
		} catch(SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
            
		}
		return item;
	}

	
	public void updateItem(Item item) {
		Connection connection= ConnectionSingleton.getInstance();
        try {
      
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            
            preparedStatement.setString(1, item.getCategoria());

            preparedStatement.setString(2, item.getMarca());
            
            preparedStatement.setString(3, item.getModello());
            preparedStatement.setInt(4, item.getId());

            preparedStatement.execute();
            
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            
        }

	}
	
	public void deleteItem(int id) {
		Connection connection= ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            
            preparedStatement.setInt(1,id);
            preparedStatement.execute();

		} catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
	}
}
	

package main.dao;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ItemDao {
	private final String QUERY_INSERT="insert into amebadevicesdb.item(categoria,marca,modello) values(?,?,?)";
	private final String QUERY_READ = "select * from amebadevicesdb.item";
	private final String QUERY_SEARCH="select * from amebadevicesdb.item where id=?";
	private final String QUERY_UPDATE="update amebadevicesdb.item set categoria=?,marca=?,modello=? where id=?";
	private final String QUERY_DELETE="delete from amebadevicesdb.item where id=?";
	private String QUERY_PROVA = "update amebadevicesdb.item set ";
	private final String QUERY_SELECT_ITEM_ID = "select id from amebadevicesdb.item where categoria=? and marca=? and modello=?";
	private final String QUERY_INSERT_COLLEGAMENTO = "insert into amebadevicesdb.collegamento(item, building) values(?,?)";
	
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
	
	public boolean insertItem(Item item, int buildingId) {
		Connection connection= ConnectionSingleton.getInstance();
        try {
        	
        	String categoria = item.getCategoria();
        	String marca = item.getMarca();
        	String modello = item.getModello();
        	boolean result = false;
      
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            
            preparedStatement.setString(1, categoria);

            preparedStatement.setString(2, marca);
            
            preparedStatement.setString(3, modello);
            
            if(!preparedStatement.execute()) {
            	PreparedStatement getItemIdStatement = connection.prepareStatement(QUERY_SELECT_ITEM_ID);
            	
            	getItemIdStatement.setString(1, categoria);
            	getItemIdStatement.setString(2, marca);
                getItemIdStatement.setString(3, modello);
                
                ResultSet idResult = getItemIdStatement.executeQuery();
                int itemId = 0;
                if(idResult.next()) {
                	itemId = idResult.getInt(1);
                	
                	if(itemId != 0) {
                		PreparedStatement insertCollegamentoStatement = connection.prepareStatement(QUERY_INSERT_COLLEGAMENTO);
                		
                		insertCollegamentoStatement.setInt(1, itemId);
                		insertCollegamentoStatement.setInt(2, buildingId);
                		
                		insertCollegamentoStatement.execute();
                		result = true;
                	}
                }
            }
            
            return result;
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
      
        	int i = 1;
        	
            String categoria = item.getCategoria();
            String marca = item.getMarca();
            String modello = item.getModello();
            
            
            if(!categoria.isEmpty()) {
            	//QUERY_PROVA.concat("categoria=?,");
            	QUERY_PROVA += "categoria=?";
            	if(!marca.isEmpty() || !modello.isEmpty()) {
                	//QUERY_PROVA.concat("marca=?,");
                	QUERY_PROVA += ",";
                	//preparedStatement.setString(2, marca);
                }
            	//preparedStatement.setString(1, categoria);
            }
            
            if(!marca.isEmpty()) {
            	//QUERY_PROVA.concat("marca=?,");
            	QUERY_PROVA += "marca=?";
            	//preparedStatement.setString(2, marca);
            	if(!modello.isEmpty()) {
                	//QUERY_PROVA.concat("modello=? ");
                	QUERY_PROVA += ",";
                	//preparedStatement.setString(3, modello);
                }
            }
            
            if(!modello.isEmpty()) {
            	//QUERY_PROVA.concat("modello=? ");
            	QUERY_PROVA += "modello=?";
            	//preparedStatement.setString(3, modello);
            }
            
            //QUERY_PROVA.concat("where id=?");
            QUERY_PROVA += "where id=?";
            
            
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_PROVA);
            
            if(!categoria.isEmpty()) {
            	preparedStatement.setString(i, categoria);
            	i++;
            }
            
            if(!marca.isEmpty()) {
            	preparedStatement.setString(i, marca);
            	i++;
            }
            
            if(!modello.isEmpty()) {
            	preparedStatement.setString(i, modello);
            	i++;
            }
            
            
            
            preparedStatement.setInt(i, Integer.parseInt(item.getId()));

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
	

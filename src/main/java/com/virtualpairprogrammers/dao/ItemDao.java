package com.virtualpairprogrammers.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Item;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class ItemDao {
	private final String QUERY_INSERT="insert into amebadevicesdb.itemtype(categoria,marca,modello, descrizione) values(?,?,?,?)";
	private final String QUERY_READ = "select * from amebadevicesdb.item";
	private final String QUERY_SEARCH="select * from amebadevicesdb.item where id=?";
	private final String QUERY_UPDATE="update amebadevicesdb.item set categoria=?,marca=?,modello=? where id=?";
	private final String QUERY_DELETE="delete from amebadevicesdb.item where id=?";
	private final String QUERY_SELECT_ITEM_ID = "select id from amebadevicesdb.item where categoria=? and marca=? and modello=?";
	private final String QUERY_INSERT_COLLEGAMENTO = "insert into amebadevicesdb.collegamento(item, building) values(?,?)";
	private final String QUERY_SELECT_COLLEGAMENTO = "select item from collegamento where building = ?";
	
	public ItemDao() {
		
	}
	
	/*public List<Item> getAllItem () {
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
    }*/
	
	public boolean insertItem(Item item) {
		Connection connection= ConnectionSingleton.getInstance();
        try {
        	
        	String categoria = item.getCategoria();
        	String marca = item.getMarca();
        	String modello = item.getModello();
        	String descrizione = item.getDescrizione();
      
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            
            preparedStatement.setString(1, categoria);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modello);
            preparedStatement.setString(4, descrizione);
            
            return preparedStatement.execute();            
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
	
	/*public Item searchItem (int id) {
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
	}*/
	
	/*private String prapareUpdateQuery(List<String> itemFields) {
		StringJoiner joiner = new StringJoiner(", ", "update amebadevicesdb.item set ", " where id=?");
		List<String> fields = Arrays.asList("categoria=?", "marca=?", "modello=?");
		
		int i = 0;
		while (i < itemFields.size()) {
			if(!itemFields.get(i).isEmpty()) {
				joiner.add(fields.get(i));
			}
		i++;
		}
		
        return joiner.toString();        
	}*/
	
	/*private PreparedStatement prepareUpdateStatement
	(
			PreparedStatement preparedStatement,
			List<String> fields,
			int id
	) {
		Iterator<String> fieldsIterator = fields.iterator();
		
		int i = 0;
		while (fieldsIterator.hasNext()) {
			try {
				String field = fieldsIterator.next();
				if(!field.isEmpty()) {
					preparedStatement.setString(i + 1, field);
					i++;
				}	
			} catch (SQLException e) {
				GestoreEccezioni.getInstance().gestisciEccezione(e);
			}
		}
		
		try {
			preparedStatement.setInt(++i, id);
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
		return preparedStatement;
	}

	
	public void updateItem(Item item) {
		Connection connection= ConnectionSingleton.getInstance();
        try {
        	List<String> ItemFields = Arrays.asList(item.getCategoria(), item.getMarca(), item.getModello());
        	int itemId = Integer.parseInt(item.getId());
      
            String updateQuery = this.prapareUpdateQuery(ItemFields);
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement = this.prepareUpdateStatement(preparedStatement, ItemFields, itemId);
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

	public List<Item> getByBuilding(int buildingId) {
		Connection connection = ConnectionSingleton.getInstance();
		List <Item> toReturn = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(QUERY_SELECT_COLLEGAMENTO);
			ps.setInt(1, buildingId);
			ResultSet rs = ps.executeQuery();
			List <Integer> ids = new ArrayList<>();
			while(rs.next()) {
				ids.add(rs.getInt(1));
			}
			PreparedStatement secondStep = connection.prepareStatement(QUERY_SEARCH);
			ResultSet secondResult = secondStep.executeQuery();
					while(secondResult.next()) {
						Item tmp = new Item();
						tmp.setId(secondResult.getInt(1));
						tmp.setMarca(secondResult.getString(2));
						tmp.setModello(secondResult.getString(3));
						tmp.setCategoria(secondResult.getString(4));
						toReturn.add(tmp);
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
		
	}*/
}
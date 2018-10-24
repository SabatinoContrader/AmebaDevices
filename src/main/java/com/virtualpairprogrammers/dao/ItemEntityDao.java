package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.virtualpairprogrammers.model.ItemEntity;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class ItemEntityDao {
	private final String QUERY_READ = "select * from amebadevicesdb.item";

	
	public ItemEntityDao() {}
	
	public List<ItemEntity> getAll() {
		List<ItemEntity> itemEntities = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_READ);
            
            while(resultSet.next()) {
            	String id = Integer.toString(resultSet.getInt("id"));
            	String seriale = resultSet.getString("seriale");
            	String consumoEnergetico = resultSet.getString("consumo_energetico");
            	String roomId = Integer.toString(resultSet.getInt("idroom"));
            	String itemTypeId = Integer.toString(resultSet.getInt("iditemtype"));
            	String thing = Integer.toString(resultSet.getInt("thing"));
            	
            	ItemEntity itemEntity = new ItemEntity(
            			id, seriale, consumoEnergetico, 
            			roomId, itemTypeId, thing);
            	
            	itemEntities.add(itemEntity);
            }
        } 
        catch(SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);

        }
        return itemEntities;
	}
	
	public boolean insert(ItemEntity itemEntity) {
		Connection connection = ConnectionSingleton.getInstance();
		private final Map<String, String> pippo = new HashMap<>();
		
		try {
			String seriale = itemEntity.getSeriale();
			String consumoEnergetico = itemEntity.getConsumoEnergetico();
			String roomId = itemEntity.getIdRoom();
			String itemTypeId = itemEntity.getItemType();
			String thing = itemEntity.getThing();
		}
		catch(SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);

        }

	}
}

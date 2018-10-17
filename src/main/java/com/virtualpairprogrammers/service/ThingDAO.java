package com.virtualpairprogrammers.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.virtualpairprogrammers.model.Building;
import com.virtualpairprogrammers.model.Thing;
import com.virtualpairprogrammers.utils.ConnectionSingleton;

public class ThingDAO {
	private static final String INSERT_QUERY = "insert into thing (nome, numUscite) values (?,?)";
	private static final String DELETE_QUERY = "delete from thing where id = ?";
	
	
	
	public List<Thing> getAllByBuilding(Building b) {
		// TODO Auto-generated method stub
		return null;
	}

	public Thing searchThing(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Thing t) {
		Connection c = ConnectionSingleton.getInstance();
		try {
			PreparedStatement ps = c.prepareStatement(INSERT_QUERY);
			ps.setString(1, t.getNome());
			ps.setInt(2, t.getNumUscite());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void delete(Thing t) {
		Connection c = ConnectionSingleton.getInstance();
		try {
			PreparedStatement ps = c.prepareStatement(DELETE_QUERY);
			ps.setInt(1, Integer.parseInt(t.getId()));
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

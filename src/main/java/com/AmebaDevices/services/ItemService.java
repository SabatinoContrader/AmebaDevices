package com.AmebaDevices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.ItemDao;
import com.AmebaDevices.model.Item;

@Service
public class ItemService {
	
	private ItemDao itemDao;
	@Autowired
	public ItemService() {
		this.itemDao=new ItemDao();
	}
	
	public List<Item> getAllItem () {
        return this.itemDao.getAllItem();
    }
	
	public boolean insertItem(Item item) {
		return this.itemDao.insertItem(item);
	}
	
	public Item searchItem(String id) {
		return this.itemDao.searchItem(id);
	}
	
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}
	
	public void deleteItem(String id) {
		itemDao.deleteItem(id);
	}

	/*
	public List<Item> getByBuilding(int buildingId) {
		return itemDao.getByBuilding(buildingId);
	}

	public List<Item> getAllByRoom(int id) {
		return itemDao.getAllByRoom(id);
	}
	*/

}

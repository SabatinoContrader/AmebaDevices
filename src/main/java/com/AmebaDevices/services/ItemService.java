package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.ItemDAO;
import com.AmebaDevices.model.Item;
import com.AmebaDevices.model.Room;
@Service
public class ItemService {

	private ItemDAO itemEntityDao;
	@Autowired
	public ItemService(ItemDAO itemEntityDao) {
		this.itemEntityDao=itemEntityDao;
	}
	
	public void insertItem(Item item) {
		 this.itemEntityDao.save(item);
	}
	
	public void deleteItem(Long id) {
		Item item = itemEntityDao.findOne(id);
		itemEntityDao.delete(item);
	}
	
	public void updateItem(Item item) {
		if (itemEntityDao.findOne(item.getId())!=null)
		this.itemEntityDao.save(item);
	}
	
	public Item searchItem(Long id) {
		return this.itemEntityDao.findOne(id);
	}
	
	public List<Item> getAllByRoom(Room room) {
		List<Item> items = (List<Item>) itemEntityDao.findByRoom(room);
		return items;

	}
}

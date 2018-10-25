package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.ItemTypeDao;
import com.AmebaDevices.model.Customer;
import com.AmebaDevices.model.ItemType;

@Service
public class ItemTypeService {
	
	private ItemTypeDao itemTypeDao;
	@Autowired
	public ItemTypeService(ItemTypeDao itemTypeDao) {
		this.itemTypeDao=itemTypeDao;
	}
	
	public List<ItemType> getAllItemType () {
		List<ItemType> items = new ArrayList<>();
		itemTypeDao.findAll().forEach(c -> {
			items.add(c);	});
		return items;
	}
    
	
	public void insertItemType(ItemType item) {
		 this.itemTypeDao.save(item);
	}
	
	public ItemType searchItemType(Long id) {
		return this.itemTypeDao.findOne(id);
	}
	
	public void updateItemType(ItemType item) {
		if (itemTypeDao.findOne(item.getId())!=null)
		this.itemTypeDao.save(item);
	}
	
	public void deleteItemType(Long id) {
		this.itemTypeDao.delete(id);
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

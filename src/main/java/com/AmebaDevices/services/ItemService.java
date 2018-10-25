package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import com.AmebaDevices.dao.ItemEntityDAO;
import com.AmebaDevices.model.Item;

public class ItemService {

	private ItemEntityDAO itemEntityDao;
	
	public ItemService(ItemEntityDAO itemEntityDao) {
		this.itemEntityDao=itemEntityDao;
	}
	
	public Item insertItem(Item f) {
		return this.itemEntityDao.save(f);
	}
	
	public void deleteItem(Long id) {
		this.itemEntityDao.delete(id);
	}
	
	public void updateItem(Item item) {
		if (itemEntityDao.findOne(item.getId())!=null)
		this.itemEntityDao.save(item);
	}
	
	public Item searchItem(Long id) {
		return this.itemEntityDao.findOne(id);
	}
	
	public List<Item> getAllItemType () {
		List<Item> items = new ArrayList<>();
		itemEntityDao.findAll().forEach(c -> {items.add(c);	});
		return items;
	}
}

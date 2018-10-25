package com.AmebaDevices.services;

import com.AmebaDevices.dao.ItemEntityDAO;
import com.AmebaDevices.model.ItemEntity;
import com.AmebaDevices.model.Room;

public class ItemEntityService {

	private ItemEntityDAO itemEntityDao;
	
	public ItemEntityService(ItemEntityDAO itemEntityDao) {
		this.itemEntityDao=itemEntityDao;
	}
	
	public ItemEntity insertItem(ItemEntity f) {
		return this.itemEntityDao.save(f);
	}
	
	
}

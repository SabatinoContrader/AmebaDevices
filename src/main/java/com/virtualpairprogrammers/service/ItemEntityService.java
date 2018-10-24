package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.model.ItemEntity;

public class ItemEntityService {
	
	private ItemEntityDao itemEntityDao;
	
	public ItemEntityService() {
		this.itemEntityDao = new ItemIdentityDao();
	}
	
	public List<ItemEntity> getAll() {
		return this.itemEntityDao.getAll();
	}
	
	public boolean insert(ItemEntity itemEntity) {
		return this.itemEntityDao.insert(itemEntity);
	}
	
	public ItemEntity searchItemEntity(String id) {
		return this.itemEntityDao.search(id);
	}
	
	public void update(ItemEntity itemEntity) {
		this.itemEntityDao.update(itemEntity);
	}
	
	public void delete(String id) {
		this.itemEntityDao.delete();
	}
}

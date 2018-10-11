package main.service;
import java.util.List;

import main.dao.ItemDao;
import main.model.Item;
public class ItemService {
	
	private ItemDao itemDao;
	
	public ItemService() {
		this.itemDao=new ItemDao();
	}
	
	public List<Item> getAllItem () {
        return this.itemDao.getAllItem();
    }
	
	public boolean insertItem(Item item) {
		return this.itemDao.insertItem(item);
	}
	
	public Item searchItem(int id) {
		return this.itemDao.searchItem(id);
	}
	
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}
	
	public void deleteItem(int id) {
		itemDao.deleteItem(id);
	}
	

}

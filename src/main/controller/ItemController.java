package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Item;
import main.service.ItemService;

public class ItemController implements Controller {
	ItemService itemService;
	Item item;
	
	public ItemController() {
		itemService= new ItemService();
	}
	
	String mode="";
	
	@Override
	public void doControl(Request request) {
		
		//int choice= (int) request.get("choice");
		//System.out.println(choice);
		mode= request.get("mode").toString();
		//System.out.println("mode ha "+mode);
		switch(mode) {
		case "InsertForm":
			item=(Item) request.get("item");
			if(item==null) {
				MainDispatcher.getInstance().callView("ItemInsertForm", null);
			}
			else {
				if(itemService.insertItem(item)) {
					MainDispatcher.getInstance().callView("ItemMenu", null);
				}
				else {
					//TODO
					//request.put("mode", "showerr");
					//MainDispatcher.getInstance().callView("ItemInsertForm", request);
				}
			}
			
			
			break;
		
		
		case "InsertDb":
			item=(Item) request.get("item");
			if(itemService.insertItem(item)) {
				request= new Request();
				MainDispatcher.getInstance().callView("Home", request);
			}
			else {
				System.out.println("Dati mancanti o utente già registrato");
				request= new Request();
				//request.put("choice", "InsertForm");
				MainDispatcher.getInstance().callView("Item", request);
			}
			break;
			
			
		case "Read":
         	List<Item> items = itemService.getAllItem();
         	request= new Request();
         	request.put("items",items);
         	request.put("mode", "Read");
         	MainDispatcher.getInstance().callView("Item", request);
             break;
			
		case "Return":
		request= new Request();
		MainDispatcher.getInstance().callView("Home", request);
		break;
		
		case "UpdateForm":
			request= new Request();
			request.put("mode", "UpdateForm");
			MainDispatcher.getInstance().callView("Item", request);
			break;
			
		case "UpdateItem":
		int id=Integer.parseInt(request.get("id").toString());
		item= itemService.searchItem(id);
		//System.out.println(item.getId()+"-"+item.getCategoria());
		request=new Request();
		
		if(item != null) {
			request.put("mode", "UpdateItem");
			request.put("item", item);
			MainDispatcher.getInstance().callView("Item", request);
		} else {
			request.put("mode", "ItemNotFound");
			MainDispatcher.getInstance().callView("Item", request);
			//MainDispatcher.getInstance().callView("Home", null);
		}
		
		break;
		
		case "SaveUpdate":
			Item item1=(Item) request.get("item");
			itemService.updateItem(item1);
			MainDispatcher.getInstance().callView("Home", request);
		break;
		
		case "DeleteForm":
		request= new Request();
		request.put("mode", "DeleteForm");
		MainDispatcher.getInstance().callView("Item", request);
		break;
		
		case "DeleteItem":
		//request= new Request();
		int id1=Integer.parseInt(request.get("id").toString());
		//request.get("id").toString();
		//System.out.println("request è" +request);
		itemService.deleteItem(id1);
		
		MainDispatcher.getInstance().callView("Home", request);
			break;
		}
		
		
		 
	}
}


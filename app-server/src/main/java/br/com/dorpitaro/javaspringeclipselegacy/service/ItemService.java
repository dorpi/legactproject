package br.com.dorpitaro.javaspringeclipselegacy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dorpitaro.javaspringeclipselegacy.model.Item;
import br.com.dorpitaro.javaspringeclipselegacy.repository.ItemRepo;


@Component
public class ItemService implements IItemService {

	 @Autowired
	    private ItemRepo itemRepo;

	
	


	@Override
	public Item createItem(Item item) throws Exception {
		try {
		 return itemRepo.save(item);}
		catch(Exception e) {
			throw new Exception("Can't save item inventory number are in use");
		}
	}

	@Override
	public Item updateItem(Item item) throws Exception {
		try {
			Optional <Item> itemDb = this.itemRepo.findById(item.getId());
			if (itemDb.isPresent()) {
				Item itemUpdate = itemDb.get();
				itemUpdate.setInventory_no(item.getInventory_no());
				itemUpdate.setAmount(item.getAmount());
				itemUpdate.setName(item.getName());      
   				itemRepo.save(itemUpdate);
   				return itemUpdate;
			} 
			else {
            throw new Exception("Record not found with id : " + item.getId());
			}
		} catch (Exception e) {
			 throw new Exception("Inventory number already in use");		
		}
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return (List<Item>) this.itemRepo.findAll();
	}

	@Override
	public Item getItemById(long itemId) throws Exception {
		 Optional < Item > itemDb = this.itemRepo.findById(itemId);
		 if (itemDb.isPresent()) {
	            return itemDb.get();
	        } else {
	            throw new Exception("Record not found with id : " + itemId);
	        }
	    }

	

	@Override
	public void deleteItem(long itemId) throws Exception {
		 Optional < Item > itemDb = this.itemRepo.findById(itemId);
		 if (itemDb.isPresent()) {
	            this.itemRepo.delete(itemDb.get());
	        } else {
	            throw new Exception("Record not found with id : " + itemId);
	        }
	    }

	@Override
	public Item increaseAmount(Long id, int amount) throws Exception {
		Optional <Item> itemDb = this.itemRepo.findById(id);

        if (itemDb.isPresent()) {
            Item itemUpdate = itemDb.get();
            itemUpdate.increaseAmount(amount);
            itemRepo.save(itemUpdate);
            return itemUpdate;
        } else {
            throw new Exception("Record not found with id : " + id);
        }
	}
	
	@Override
	public Item decreaseAmount(Long id, int amount) throws Exception {
		Optional <Item> itemDb = this.itemRepo.findById(id);

        if (itemDb.isPresent()) {
            Item itemUpdate = itemDb.get();
            itemUpdate.decreaseAmount(amount);
            itemRepo.save(itemUpdate);
            return itemUpdate;
        } else {
            throw new Exception("Record not found with id : " + id);
        }
	}
	
	

}

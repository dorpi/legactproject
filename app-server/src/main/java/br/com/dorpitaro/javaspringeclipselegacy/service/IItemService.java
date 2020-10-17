package br.com.dorpitaro.javaspringeclipselegacy.service;



import br.com.dorpitaro.javaspringeclipselegacy.model.Item;
import java.util.List;

public interface IItemService {

	Item createItem(Item item) throws Exception;

	Item updateItem(Item item) throws Exception;

    List < Item > getAllItems();

    Item getItemById(long itemId) throws Exception;

    void deleteItem(long id) throws Exception ;
    
    Item increaseAmount(Long id,int amount ) throws Exception;
    
    Item decreaseAmount(Long id,int amount ) throws Exception;
    
	  
}

package br.com.dorpitaro.javaspringeclipselegacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dorpitaro.javaspringeclipselegacy.model.Item;
import br.com.dorpitaro.javaspringeclipselegacy.service.ItemService;


@RestController
public class ItemController {
	
	@Autowired
	private ItemService service;
	

    @GetMapping("/items")
    @CrossOrigin()
    public ResponseEntity < List < Item >> getAllItems() {
        return ResponseEntity.ok().body(service.getAllItems());
    }
	
	
	
    @GetMapping("/items/{id}")
    @CrossOrigin()
    public ResponseEntity < Item > getItemById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok().body(service.getItemById(id));
    }
    
    @PostMapping("/items")
    @CrossOrigin()
    public ResponseEntity < Item > createProduct(@RequestBody Item item) throws Exception {
        return ResponseEntity.ok().body(this.service.createItem(item));
    }
    
    
    @PutMapping("/items/{id}")
    @CrossOrigin()
    public ResponseEntity <Item> updateItems(@PathVariable long id, @RequestBody Item item) throws Exception {
        return ResponseEntity.ok().body(this.service.updateItem(item));
    }
		
    @DeleteMapping("/items/{id}")
    @CrossOrigin()
    public HttpStatus deleteItem(@PathVariable long id) throws Exception {
        this.service.deleteItem(id);
        return HttpStatus.OK;
    }
	
    

    @PutMapping("/items/{id}/inc/{amount}")
    @CrossOrigin()
    public ResponseEntity <Item> IncreaseItemAmount(@PathVariable long id,@PathVariable int amount) throws Exception {
    	   return ResponseEntity.ok().body(this.service.increaseAmount(id, amount));   
 
    }
    
    @PutMapping("/items/{id}/dec/{amount}")
    @CrossOrigin()
    public ResponseEntity <Item> decreaseItemAmount(@PathVariable long id,@PathVariable int amount) throws Exception {
    	 return ResponseEntity.ok().body(this.service.decreaseAmount(id, amount));
    }
}

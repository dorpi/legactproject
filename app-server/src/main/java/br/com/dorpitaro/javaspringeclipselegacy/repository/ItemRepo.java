package br.com.dorpitaro.javaspringeclipselegacy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import br.com.dorpitaro.javaspringeclipselegacy.model.Item;



@Repository
public interface ItemRepo extends CrudRepository<Item,Long> {

}

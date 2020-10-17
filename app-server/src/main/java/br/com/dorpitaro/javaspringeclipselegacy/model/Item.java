package br.com.dorpitaro.javaspringeclipselegacy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Items")
public class Item {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name="amount")
	private int amount;
	
	@Column(unique=true)
	private Long inventory_no;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Long getInventory_no() {
		return inventory_no;
	}

	public void setInventory_no(Long inventory_no) {
		this.inventory_no = inventory_no;
	}
	
	public void increaseAmount(int amount) {
		this.amount+=amount;
	}
	
	public void decreaseAmount(int amount) {
		if (this.amount - amount <0)
			this.amount=0;
		else
			this.amount-=amount;
	}
	

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", amount=" + amount + ", inventory_no=" + inventory_no + "]";
	}

	
	


}
package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "beverages")
public class Beverage extends Item implements Serializable{
	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	private Size size;
	@Column(name = "supplier_name")
	private String supplierName;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Item item;

//	public Beverage(String id, String name, double price, String description, boolean onSpecial, Beverage beverage,
//			Food food, Set<Ingredient> ingredients, Size size, String supplierName, Item item) {
//		super(id, name, price, description, onSpecial, beverage, food, ingredients);
//		this.size = size;
//		this.supplierName = supplierName;
//		this.item = item;
//	}

	public Beverage(String id, String name, Size size, String supplierName, Item item) {
		super(id, name);
		this.size = size;
		this.supplierName = supplierName;
		this.item = item;
	}	
	
	public Beverage(Size size, String supplierName) {
		super();
		this.size = size;
		this.supplierName = supplierName;
	}

	public Beverage(Size size, String supplierName, Item item) {
		super();
		this.size = size;
		this.supplierName = supplierName;
		this.item = item;
	}

	public Beverage() {
		
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Beverage [size=" + size + ", supplierName=" + supplierName + ", item=" + item + "]";
	}

}

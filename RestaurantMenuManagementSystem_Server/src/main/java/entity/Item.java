package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	protected String id;
	protected String name;
	protected double price;
	protected String description;
	@Column(name = "on_special")
	protected boolean onSpecial;
	
	@OneToOne(mappedBy = "item")
	protected Beverage beverage;
	
	@OneToOne(mappedBy = "item")
	protected Food food;
	
	@ManyToMany(mappedBy = "items")
//	@JoinTable(name = "items_ingredients",
//        joinColumns = @JoinColumn(name = "ingredient_id"),
//        inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Ingredient> ingredients;

	public Item(String id, String name, double price, String description, boolean onSpecial, Beverage beverage,
			Food food, List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.onSpecial = onSpecial;
		this.beverage = beverage;
		this.food = food;
		this.ingredients = ingredients;
	}
	
	
	public Item(String id, String name, double price, String description, boolean onSpecial) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.onSpecial = onSpecial;
	}

	

	public Item(String id, String name, double price, String description, boolean onSpecial, Food food) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.onSpecial = onSpecial;
		this.food = food;
	}


	public Item(String id, String name, double price, String description, boolean onSpecial, Beverage beverage,
			Food food) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.onSpecial = onSpecial;
		this.beverage = beverage;
		this.food = food;
	}



	public Item() {
		
	}

	public Item(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isOnSpecial() {
		return onSpecial;
	}

	public void setOnSpecial(boolean onSpecial) {
		this.onSpecial = onSpecial;
	}

	public Beverage getBeverage() {
		return beverage;
	}

	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", onSpecial=" + onSpecial + ", ingredients=" + ingredients + "]";
	}

}

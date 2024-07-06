package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "foods")
public class Food extends Item implements Serializable{
	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	private Type type;
	@Column(name = "preparation_time")
	private int preparationTime;
	@Column(name = "serving_time")
	private int servingTime;

	@OneToOne
	@JoinColumn(name = "id")
	private Item item;

//	public Food(String id, String name, double price, String description, boolean onSpecial, Beverage beverage,
//			Food food, Set<Ingredient> ingredients, Type type, int preparationTime, int servingTime, Item item) {
//		super(id, name, price, description, onSpecial, beverage, food, ingredients);
//		this.type = type;
//		this.preparationTime = preparationTime;
//		this.servingTime = servingTime;
//		this.item = item;
//	}
	
	
	public Food(String id, String name, double price, String description, boolean onSpecial, Type type,
			int preparationTime, int servingTime) {
		super(id, name, price, description, onSpecial);
		this.type = type;
		this.preparationTime = preparationTime;
		this.servingTime = servingTime;
	}
	

	public Food(String id, String name, double price, String description, boolean onSpecial, Type type,
			int preparationTime, int servingTime, Item item) {
		super(id, name, price, description, onSpecial);
		this.type = type;
		this.preparationTime = preparationTime;
		this.servingTime = servingTime;
		this.item = item;
	}


	public Food(String id, String name, Type type, int preparationTime, int servingTime, Item item) {
		super(id, name);
		this.type = type;
		this.preparationTime = preparationTime;
		this.servingTime = servingTime;
		this.item = item;
	}
	
	public Food(Type type, int preparationTime, int servingTime) {
		super();
		this.type = type;
		this.preparationTime = preparationTime;
		this.servingTime = servingTime;
	}

	public Food(Type type, int preparationTime, int servingTime, Item item) {
		super();
		this.type = type;
		this.preparationTime = preparationTime;
		this.servingTime = servingTime;
		this.item = item;
	}
	
	public Food() {
		
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}

	public int getServingTime() {
		return servingTime;
	}

	public void setServingTime(int servingTime) {
		this.servingTime = servingTime;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Food [type=" + type + ", preparationTime=" + preparationTime + ", servingTime=" + servingTime
				+ ", item=" + item + "]";
	}
}

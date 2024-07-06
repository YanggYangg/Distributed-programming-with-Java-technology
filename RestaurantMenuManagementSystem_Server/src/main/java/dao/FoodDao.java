package dao;

import java.util.Map;

import entity.Food;

public interface FoodDao {
	Boolean addFood(Food food);
	public Map<Food, Double> listFoodAndCost();
	public void close();

}

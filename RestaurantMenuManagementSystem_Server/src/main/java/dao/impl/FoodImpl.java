package dao.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import dao.FoodDao;
import entity.Food;
import entity.Ingredient;
import entity.Item;
import entity.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FoodImpl implements FoodDao {
	private static final String PERSISTENCE_UNIT_NAME = "RestaurantMenuManagementSystem_Server MSSQL";
	private EntityManagerFactory entityManager;
	private EntityManager em;
	
	public FoodImpl() {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityManager.createEntityManager();
	}
	

	@Override
	public Boolean addFood(Food food) {
		/**
		 * Them mot mon an moi. Trong do, ma so cua mon an phai bat dau bang F
		 * va theo sau it nhat 3 ky so
		 */
		if (food == null || !food.getId().matches("^F\\d{3,}$")) {
			System.out.println("Invalid food");
			return false;
		}
		    em.getTransaction().begin();
		try {
			em.persist(food);
			em.getTransaction().commit();
			System.out.println("Add food successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	@Override
	public void close() {
		em.close();
		
	}

	public static void main(String[] args) {
		FoodImpl foodImpl = new FoodImpl();
		//Food food = new Food("F112", "Pho", 50000, "Pho bo", false, null, null, null, null, 10, 5, null);
		/**
		 * Food(String id, String name, double price, String description, boolean onSpecial, Type type,
			int preparationTime, int servingTime)
		 */
		Food food = new Food("F113", "Com ga", 50000, "Com ga xoi mo", false, Type.MAIN_COURSE, 10, 5);
		foodImpl.addFood(food);
		foodImpl.close();
		
	}

	/**
	 * Tinh gia goc cua tung mon an sau khi che bien thanh pham 
	 * Ket qua giam dan theo don gia goc
	 * Trong do:
	 * Gia goc mon an  = Tong (So luong nguyen lieu * don gia nguyen lieu) + (thoi gian cbi + thoi gian pvu) *0.2$
	 * 
	 */

	@Override
	public Map<Food, Double> listFoodAndCost() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

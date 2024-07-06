package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.ItemDao;
import entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ItemImpl implements ItemDao{
	private static final String PERSISTENCE_UNIT_NAME = "RestaurantMenuManagementSystem_Server MSSQL";
	private EntityManagerFactory entityManager;
	private EntityManager em;
	
	public ItemImpl() {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityManager.createEntityManager();
	}
	
	/**
	 * Liet ke danh sach mat hang la mon dat biet cua nha hang co su dung 
	 * nguyen lieu duoc nhap tu nha hang cung cap nao do khi biet ten cua nha cung cap
	 * (tim tuong doi, khong phan biet chu hoa chu thuong)
	 */
	
	/**
	 * Viet cau query
	 * SELECT i.*
       FROM items i
       JOIN items_ingredients ii ON i.id = ii.item_id
       JOIN ingredients ing ON ii.ingredient_id = ing.ingredient_id
       WHERE i.on_special = 1
       AND LOWER(ing.supplier_name) LIKE LOWER('%S%');
	 */
    
//	@Override
//	public List<Item> listItems(String supplierName) {
//		//em.getTransaction().begin();
////		List<Item> items = em.createQuery(
////				"SELECT i FROM Item i JOIN i.ingredients ing WHERE i.onSpecial = true AND LOWER(ing.supplierName) LIKE LOWER(CONCAT('%', :supplierName ,'%'))"
////				,
////				Item.class).setParameter("supplierName", supplierName).getResultList();
//		
//		/**
//		 * SELECT i.*
//		FROM items i
//		JOIN items_ingredients ii ON i.id = ii.item_id
//		JOIN ingredients ing ON ii.ingredient_id = ing.ingredient_id
//		WHERE i.on_special = 1
//		  AND LOWER(ing.supplier_name) LIKE LOWER('%anna%');
//		 */
//		
//		List<Item> items = null;
//		items = em.createQuery(
//		        "SELECT DISTINCT i " +
//		        "FROM Item i " +
//		        "JOIN i.ingredients ing " +
//		        "WHERE i.onSpecial = TRUE " +
//		        "AND LOWER(ing.supplierName) LIKE LOWER(CONCAT('%', :supplierName, '%'))",
//		        Item.class)
//		        .setParameter("supplierName", supplierName)
//		        .getResultList();
//
//		    return items;
//		//em.getTransaction().commit();
//		
////		List<Item> items = new ArrayList<>();
////		return items;
//	}
	
//	public static void main(String[] args) {
//		ItemImpl itemImpl = new ItemImpl();
//		List<Item> items = itemImpl.listItems("S114");
//		System.out.println(items);
//		//System.out.println(items.get(0).getName());
//	}
	
	/*
	 * Liệt kê danh sách mặt hàng là món đặt biệt của nhà hàng mà có sử dụng nguyên
	 * liệu được nhập từ nhà cung cấp nào đó khi biết tên nhà cung cấp (tìm tương
	 * đối, không phân biệt chữ thường hoa).
	 */
	@Override
	public List<Item> listItems(String supplierName) {
		String supplierNameLower = supplierName.toLowerCase();
		String jpql = "SELECT i FROM Item i INNER JOIN i.ingredients ig WHERE ig.supplierName = :supplierName AND i.onSpecial = true";
		return em.createQuery(jpql, Item.class)
				.setParameter("supplierName", supplierNameLower)
				.getResultList();
	}

	public static void main(String[] args) {
		ItemDao itemDao = new ItemImpl();
		itemDao.listItems("Charlie's Meats").forEach(System.out::println);
	}
	


	@Override
	public void close() {
		if (em != null && em.isOpen()) {
			em.close();
		}
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.close();
		}
	}


}

package dao;

import java.util.List;

import entity.Item;

public interface ItemDao {
	List<Item> listItems(String supplierName);
	public void close();

}

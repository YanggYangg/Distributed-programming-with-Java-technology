package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import dao.ItemDao;
import dao.impl.ItemImpl;

class Test {
	private ItemDao itemDao;
	
	@BeforeEach
	public void setUp() {
		itemDao = new ItemImpl();
	}
	
	@org.junit.jupiter.api.Test
	void testListItem() {
		assertTrue(itemDao.listItems("Anna Food Distributors") != null);
    
	}
	
	@AfterEach
	public void tearDown() {
		if (itemDao != null) {
			itemDao.close();
		}
	}
	

}

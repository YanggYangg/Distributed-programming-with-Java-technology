package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.ChiTietMuonSachDao;
import dao.DocGiaDao;
import dao.SachDao;
import dao.impl.ChiTietMuonSachImpl;
import dao.impl.DocGiaImpl;
import dao.impl.SachImpl;
import entity.DocGia;
import entity.Sach;

class TestCase {
	
	private SachDao sachDao;
	private DocGiaDao docGiaDao;
	private ChiTietMuonSachDao chiTietMuonSachDao;
	
	@BeforeEach
	public void setUp() {
		sachDao = new SachImpl();
		docGiaDao = new DocGiaImpl();
		chiTietMuonSachDao = new ChiTietMuonSachImpl();
	}
	
	@org.junit.jupiter.api.Test
	void testAddCTMS() {
		DocGia docGia = new DocGia("DG0021", "John", "12345678910", "@gmail.com");
		Sach sach = new Sach("S021", "AV", "Harper Lee1", 2024, 300000);
		assertTrue(chiTietMuonSachDao.themChiTietMuonSach(docGia, sach));
		
	}
	@org.junit.jupiter.api.Test
	//@Test
	void testUpdateSach() {
        Sach sach = new Sach("S021", "Java", "Programming", 2024, 600000);
        assertTrue(sachDao.updateSach(sach));
	}
	
	@org.junit.jupiter.api.Test
	void getDsDocGiaSachMuonTheoTenSach() {
		String tenSach = "AV";
	    assertTrue(docGiaDao.getDSDocGia1(tenSach) != null);

	}
	
	@AfterEach
	public void tearDown() {
		if (sachDao != null) {
            sachDao.close();
        }
        if (docGiaDao != null) {
            docGiaDao.close();
        }
        if (chiTietMuonSachDao != null) {
            chiTietMuonSachDao.close();
        }
	}
	
//	@Test
//	public void testUpdateSach() {
//		  Sach sach = new Sach("S001", "Java", "Nguyen A", 2020, 2000000);
//	      Boolean result = sachDao.updateSach(sach);
//	        assertEquals(1, result, "Updating the book should return 1 if successful");
//    }
//	
//	 @Test
//	    public void testGetDSDocGia1() {
//	        List<DocGia> docGias = docGiaDao.getDSDocGia1("Cho tôi xin một vé đi tuổi thơ");
//	        assertNotNull(docGias, "The result should not be null");
//	        assertFalse(docGias.isEmpty(), "The result should contain at least one DocGia");
//	    }
		
}


package dao.impl;

import dao.ChiTietMuonSachDao;
import entity.DocGia;
import entity.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ChiTietMuonSachImpl implements ChiTietMuonSachDao {

	private static final String PERSISTENCE_UNIT_NAME = "Library_Server MSSQL";
	private EntityManagerFactory entityManager;
	private EntityManager em;
	
	public ChiTietMuonSachImpl() {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityManager.createEntityManager();
	}
	@Override
	public Boolean themChiTietMuonSach(DocGia docGia, Sach sach) {
		/**
		 * Them moi mọt thong tin chi tiet muon sach cua doc gia
		 * Trong do: 
		 * + Ngay muon la ngay hien tai
		 * + Ngay tra la null
		 * + Tien coc bang gia bia neu sach xuat ban sau nam 2015, nguoc lai bang 50% gia bia
		 */
		
		
		//Kiem tra dau vao khong null
		if (docGia == null || sach == null) {
			return false;
		}
		em.getTransaction().begin();
		
		try {
			entity.ChiTietMuonSach ctms = new entity.ChiTietMuonSach();
			ctms.setDocGia(docGia);
			ctms.setSach(sach);
			ctms.setNgayMuon(new java.util.Date());
			ctms.setNgayTra(null);
			
			if(sach.getNamXB() > 2015) {
				ctms.setTienCoc(sach.getGiaBia());
			}else {
                ctms.setTienCoc(sach.getGiaBia()/2);
            }
			
			em.persist(docGia);
			em.persist(sach);
			em.persist(ctms);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
		finally {
			em.close();
		}

	}
	
	public static void main(String[] args) {
		ChiTietMuonSachImpl ctms = new ChiTietMuonSachImpl();
		DocGia docGia = new DocGia("DG012", "Quynh Nhu", "quynhNhu123@gmail.com", "0909333444");
		Sach sach = new Sach("S012","JavaScript", "Nguyen C", 2014, 2000000);
		System.out.println(ctms.themChiTietMuonSach(docGia, sach));
		
	}
	@Override
	public void close() {
		em.close();
		
	}

}

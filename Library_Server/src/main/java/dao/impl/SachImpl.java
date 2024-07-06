package dao.impl;

import java.util.Calendar;

import dao.SachDao;
import entity.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SachImpl implements SachDao {

	private static final String PERSISTENCE_UNIT_NAME = "Library_Server MSSQL";
	private EntityManagerFactory entityManager;
	private EntityManager em;
	
	public SachImpl() {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityManager.createEntityManager();
	}
	
	/**
	 * Cap nhat thong tin cua mot cuon sach
	 * Trong do:
	 * + Nam xuat ban phai truoc hoac bang nam hien tai
	 * + Gia bia phai la so duong
	 */
	@Override
	public Boolean updateSach(Sach sach) {
		//Lay nam hien tai
		int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
		try {
			if (sach.getNamXB() > namHienTai || sach.getNamXB() < 0 || sach.getGiaBia() <= 0) {
				return false;
			}
			em.getTransaction().begin();
			em.merge(sach);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		SachImpl sachImpl = new SachImpl();
		Sach sach = new Sach("S012","JavaScript nang cao", "Nguyen Cuong", 2023, 2000000);
		System.out.println(sachImpl.updateSach(sach));
	}

	@Override
	public void close() {
		em.close();
		
	}

}

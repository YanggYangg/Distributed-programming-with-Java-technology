package dao.impl;

import java.util.ArrayList;
import java.util.List;


import dao.DocGiaDao;
import entity.DocGia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class DocGiaImpl implements DocGiaDao {
	private static final String PERSISTENCE_UNIT_NAME = "Library_Server MSSQL";
	private EntityManagerFactory entityManager;
	private EntityManager em;
	

	public DocGiaImpl() {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityManager.createEntityManager();
	}
	

	/**
	 * Tim tat ca cac doc gia muon cuon sach do tu hai lan
	 * tro len khi biet tua sach.
	 * Moi doc gia la duy nhat trong tap ket qua tra ve
	 */
	
//	@Override
//	public List<DocGia> getDSDocGia1(String tuaSach) {
//		try {
//			String sql = "SELECT dg.MaDG,dg.HoTenDG,dg.DienThoai, dg.Email FROM DocGia dg INNER JOIN ChiTietMuonSach ctm ON dg.MaDG = ctm.MaDG INNER JOIN Sach s ON ctm.MaSach = s.MaSach WHERE s.TuaSach ='Cho tôi xin một vé đi tuổi thơ' GROUP BY dg.MaDG, dg.HoTenDG, dg.DienThoai, dg.Email HAVING COUNT(ctm.MaSach) >= 2";
//			return em.createNativeQuery(sql, DocGia.class).getResultList();
//			} catch (Exception e) {
//				e.printStackTrace();
//				return null;
//			}
//		
//		}
//	
//	public static void main(String[] args) {
//		DocGiaImpl docGiaImpl = new DocGiaImpl();
//		List<DocGia> list = new ArrayList<DocGia>();
//		list = docGiaImpl.getDSDocGia1("Cho tôi xin một vé đi tuổi thơ");
//		for (DocGia docGia : list) {
//			System.out.println(docGia.getHoTenDG());
//		}
//	}
	
	
	
	@Override
	public List<DocGia> getDSDocGia1(String tuaSach) {
//		 Tìm tất cả đọc giả mượn cuốn sách nào đó từ hai lần trở lên khi biết tựa
//		 sách. mỗi đọc giả là duy nhất trong tệp kết quả trả về

		/*
		 * câu truy vấn đúng ra kết quả SELECT dg.MaDG, dg.HoTenDG, dg.DienThoai,
		 * dg.Email FROM DocGia dg INNER JOIN ChiTietMuonSach ctm ON dg.MaDG = ctm.MaDG
		 * INNER JOIN Sach s ON ctm.MaSach = s.MaSach WHERE s.TuaSach ='Cho tôi xin một
		 * vé đi tuổi thơ' GROUP BY dg.MaDG, dg.HoTenDG, dg.DienThoai, dg.Email HAVING
		 * COUNT(ctm.MaSach) >= 2;
		 */
		try {
			String sql = "SELECT dg FROM DocGia dg INNER JOIN ChiTietMuonSach ctm ON dg.id = ctm.docGia.id INNER JOIN Sach s ON ctm.sach.id = s.id WHERE s.tuaSach = :tuaSach GROUP BY dg.id, dg.hoTenDG, dg.dienThoai, dg.email HAVING COUNT(ctm.sach.id) >= 2";
			// tạo câu truy vấn
			List<DocGia> list = em.createQuery(sql, DocGia.class).setParameter("tuaSach", tuaSach)
					.getResultList();
			if (list.size() > 0) {
				return list;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		DocGiaImpl docGiaImpl = new DocGiaImpl();
		List<DocGia> list = docGiaImpl.getDSDocGia1("To Kill a Mockingbird");
		if (list != null) {
			for (DocGia docGia : list) {
				System.out.println(docGia);
			}
		} else {
			System.out.println("Không có đọc giả nào mượn cuốn sách này từ hai lần trở lên");
		}

	}


	@Override
	public void close() {
		em.close();
		
	}

	}
		
	
	

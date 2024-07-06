package dao;

import entity.DocGia;
import entity.Sach;

public interface ChiTietMuonSachDao {
	Boolean themChiTietMuonSach(DocGia docGia, Sach sach);
	public void close();

}

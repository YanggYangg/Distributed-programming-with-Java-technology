package dao;

import java.util.List;

import entity.DocGia;

public interface DocGiaDao {
	List<DocGia> getDSDocGia1(String tuaSach);
	public void close();

}

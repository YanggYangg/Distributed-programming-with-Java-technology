package entity;


import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "ChiTietMuonSach")
public class ChiTietMuonSach implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "NgayMuon")
	private Date ngayMuon;
	@Column(name = "NgayTra")
	private Date ngayTra;
	@Column(name = "TienCoc")
	private long tienCoc;

	@ManyToOne
	@Id
	@JoinColumn(name = "MaDG")
	private DocGia docGia;
	
	@ManyToOne
	@Id
	@JoinColumn(name = "MaSach")
	private Sach sach;
	
	public ChiTietMuonSach() {
		
	}

	public ChiTietMuonSach(Date ngayMuon, Date ngayTra, long tienCoc, DocGia docGia, Sach sach) {
		super();
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
		this.tienCoc = tienCoc;
		this.docGia = docGia;
		this.sach = sach;
	}

	public Date getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public long getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(long tienCoc) {
		this.tienCoc = tienCoc;
	}

	public DocGia getDocGia() {
		return docGia;
	}

	public void setDocGia(DocGia docGia) {
		this.docGia = docGia;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	@Override
	public String toString() {
		return "ChiTietMuonSach [ngayMuon=" + ngayMuon + ", ngayTra=" + ngayTra + ", tienCoc=" + tienCoc + ", docGia="
				+ docGia + ", sach=" + sach + "]";
	}
	
}

package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sach")
public class Sach implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaSach")
	private String maSach;
	@Column(name = "TuaSach")
	private String tuaSach;
	@Column(name = "TacGia")
	private String tacGia;
	@Column(name = "NamXB")
	private int namXB;
	@Column(name = "GiaBia")
	private long giaBia;
	
	@OneToMany(mappedBy = "sach")
	private List<ChiTietMuonSach> chiTietMuonSach;

	public Sach(String maSach, String tuaSach, String tacGia, int namXB, long giaBia,
			List<ChiTietMuonSach> chiTietMuonSach) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.namXB = namXB;
		this.giaBia = giaBia;
		this.chiTietMuonSach = chiTietMuonSach;
	}
	
	public Sach(String maSach, String tuaSach, String tacGia, int namXB, long giaBia) {
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.namXB = namXB;
		this.giaBia = giaBia;
	}

	public Sach(String maSach) {
		this.maSach = maSach;
	}
	
	public Sach() {
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTuaSach() {
		return tuaSach;
	}

	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	public long getGiaBia() {
		return giaBia;
	}

	public void setGiaBia(long giaBia) {
		this.giaBia = giaBia;
	}

	public List<ChiTietMuonSach> getChiTietMuonSach() {
		return chiTietMuonSach;
	}

	public void setChiTietMuonSach(List<ChiTietMuonSach> chiTietMuonSach) {
		this.chiTietMuonSach = chiTietMuonSach;
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tuaSach=" + tuaSach + ", tacGia=" + tacGia + ", namXB=" + namXB
				+ ", giaBia=" + giaBia + ", chiTietMuonSach=" + chiTietMuonSach + "]";
	}
	
	
}

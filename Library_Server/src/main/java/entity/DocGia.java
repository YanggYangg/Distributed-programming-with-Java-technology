package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DocGia")
public class DocGia implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaDG")
	private String maDG;
	@Column(name = "HoTenDG")
	private String hoTenDG;
	@Column(name = "Email")
	private String email;
	@Column(name = "DienThoai")
	private String dienThoai;
	
	@OneToMany(mappedBy = "docGia")
	private List<ChiTietMuonSach> chiTietMuonSach;

	public DocGia(String maDG, String hoTenDG, String email, String dienThoai, 
			List<ChiTietMuonSach> chiTietMuonSach) {
		super();
		this.maDG = maDG;
		this.hoTenDG = hoTenDG;
		this.email = email;
		this.dienThoai = dienThoai;
		this.chiTietMuonSach = chiTietMuonSach;
	}
	
	public DocGia(String maDG, String hoTenDG, String email, String dienThoai) {
		super();
		this.maDG = maDG;
		this.hoTenDG = hoTenDG;
		this.email = email;
		this.dienThoai = dienThoai;
	}
	

	public DocGia(String maDG) {
		super();
		this.maDG = maDG;
	}
	
	public DocGia() {
		
	}

	public String getMaDG() {
		return maDG;
	}

	public void setMaDG(String maDG) {
		this.maDG = maDG;
	}

	public String getHoTenDG() {
		return hoTenDG;
	}

	public void setHoTenDG(String hoTenDG) {
		this.hoTenDG = hoTenDG;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public List<ChiTietMuonSach> getChiTietMuonSach() {
		return chiTietMuonSach;
	}

	public void setChiTietMuonSach(List<ChiTietMuonSach> chiTietMuonSach) {
		this.chiTietMuonSach = chiTietMuonSach;
	}

	@Override
	public String toString() {
		return "DocGia [maDG=" + maDG + ", hoTenDG=" + hoTenDG + ", email=" + email + ", dienThoai=" + dienThoai + "]";
	}
	
	
	
}

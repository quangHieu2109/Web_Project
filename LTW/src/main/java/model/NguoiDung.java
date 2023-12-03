package model;

import java.sql.Date;

public class NguoiDung {
	private String tenDangNhap;
	private String matKhau;
	private String hoVaTen;
	private String email;
	private Date ngaySinh;

	public NguoiDung(String tenDangNhap, String matKhau, String hoVaTen, String email, Date ngaySinh) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.email = email;
		this.ngaySinh = ngaySinh;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Override
	public String toString() {
		return "NguoiDung [tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", hoVaTen=" + hoVaTen + ", email="
				+ email + ", ngaySinh=" + ngaySinh + "]";
	}

}

package model;

import java.sql.Date;
import java.util.List;

public class NguoiDung {
	private String tenDangNhap;
	private String matKhau;
	private String hoVaTen;
	private String email;
	private Date ngaySinh;
	private List<String> roles;

	public NguoiDung(String tenDangNhap, String matKhau, String hoVaTen, String email, Date ngaySinh) {
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.email = email;
		this.ngaySinh = ngaySinh;
	}

	public NguoiDung() {
//		this.tenDangNhap=null;
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
	public void setRoles(List<String> roles) {
		this.roles=roles;
	}
	public List<String> getRoles() {
		return roles;
	}
public String display() {
	if(this.tenDangNhap == null) {
		return "none";
	}else {
		return "flex";
	}
}
	@Override
	public String toString() {
		return "NguoiDung [tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", hoVaTen=" + hoVaTen + ", email="
				+ email + ", ngaySinh=" + ngaySinh + "]";
	}
public static void main(String[] args) {
	System.out.println(new NguoiDung().getTenDangNhap().equals(""));;
}
}

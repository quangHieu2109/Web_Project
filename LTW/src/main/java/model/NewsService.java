package model;

import java.util.List;

import dao.BaiBaoDAO;
import dao.BinhLuanDAO;
import dao.NguoiDungDAO;
import dao.TheLoaiDAO;

public class NewsService {
	private TheLoaiDAO dbTheLoai = new TheLoaiDAO();
	private BaiBaoDAO dbBaiBao = new BaiBaoDAO();
	private BinhLuanDAO dbBinhLuan = new BinhLuanDAO();
	private NguoiDungDAO dbNguoiDung = new NguoiDungDAO();

	public List<TheLoai> getDSTheLoai() {
		return dbTheLoai.getDSTheLoai();
	}
	public boolean checkDangNhap(String tenDangNhap,String matKhau) {
		return dbNguoiDung.checkNguoiDung(tenDangNhap, matKhau);
	}
	public int addNguoiDung(NguoiDung nguoiDung) {
		return dbNguoiDung.insertNguoiDung(nguoiDung);
	}
	
	
}

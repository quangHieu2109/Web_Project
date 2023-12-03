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
	public void addNguoiDung(NguoiDung nguoiDung) {
		dbNguoiDung.addNguoiDung(nguoiDung);
	}
	
	
}

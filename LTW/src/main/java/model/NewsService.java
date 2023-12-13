package model;

import java.util.ArrayList;
import java.util.List;

import dao.BaiBaoDAO;
import dao.BinhLuanDAO;
import dao.NguoiDungDAO;
import dao.TheLoaiDAO;
import database.JDBCUtil;

public class NewsService {
	private TheLoaiDAO dbTheLoai = new TheLoaiDAO();
	private BaiBaoDAO dbBaiBao = new BaiBaoDAO();
	private BinhLuanDAO dbBinhLuan = new BinhLuanDAO();
	private NguoiDungDAO dbNguoiDung = new NguoiDungDAO();
	private boolean isLogin =false;

	public ArrayList<BaiBao> getBaiBaoMoiNhat(int size) {
		return dbBaiBao.selectOrderByTime(size);
	}
	public NguoiDung checkDangNhap(String tenDangNhap,String matKhau) {
		return dbNguoiDung.checkNguoiDung(tenDangNhap, matKhau);
	}
	public int addNguoiDung(NguoiDung nguoiDung) { 
		return dbNguoiDung.insertNguoiDung(nguoiDung);
	}
	public void setIsLogin(boolean isLogin) {
		this.isLogin=isLogin;
	}
	public boolean getIsLogin() {
		return isLogin;
	}
	public boolean addBaiBao(BaiBao baiBao) {
		return BaiBaoDAO.addBaiBao(baiBao);
		
	}
	public void updateBaiBao(BaiBao baiBao) {
		BaiBaoDAO.updateBaiBao(baiBao);
	}
	public ArrayList<BaiBao> searchBaiBao(String search) {
		JDBCUtil.connection();
		ArrayList<BaiBao> res = BaiBaoDAO.selectByTen(search);
		JDBCUtil.closeConnection();
		
		return res;
	}
}

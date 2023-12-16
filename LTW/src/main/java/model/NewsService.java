package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private boolean isLogin = false;

	public ArrayList<BaiBao> getBaiBaoMoiNhat(int size) {
		return dbBaiBao.selectOrderByTime(size);
	}

	public ArrayList<BaiBao> getBaiBaoMoiNhat() {
		return dbBaiBao.selectOrderByTime();
	}

	public NguoiDung checkDangNhap(String tenDangNhap, String matKhau) {
		return dbNguoiDung.checkNguoiDung(tenDangNhap, matKhau);
	}

	public int addNguoiDung(NguoiDung nguoiDung) {
		return dbNguoiDung.insertNguoiDung(nguoiDung);
	}

	public void setIsLogin(boolean isLogin) {
		this.isLogin = isLogin;
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

	public BaiBao getBaiBaoByMaBB(String mabb) {
		JDBCUtil.connection();
		BaiBao reuslt = BaiBaoDAO.selectByMaBaiBao(mabb);
		JDBCUtil.closeConnection();
		return reuslt;
	}

	public ArrayList<BaiBao> getBaiBaoByTheLoai(String theLoaiChinh, String theLoaiPhu) {
		JDBCUtil.connection();
		ArrayList<BaiBao> baos = BaiBaoDAO.getBaiBaoByTheLoai(theLoaiChinh, theLoaiPhu);
		return baos;
	}

	public ArrayList<BaiBao> searchBaiBao(String search) {
		JDBCUtil.connection();
		ArrayList<BaiBao> res = BaiBaoDAO.selectByTen(search);
		JDBCUtil.closeConnection();

		return res;
	}
}

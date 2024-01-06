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

	public NewsService() {
		JDBCUtil.connection();
	}

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
//		JDBCUtil.connection();
		BaiBaoDAO.updateBaiBao(baiBao);
		TheLoaiDAO.updateTheLoai(baiBao);
//		JDBCUtil.closeConnection();
	}

	public BaiBao getBaiBaoByMaBB(String mabb) {
//		JDBCUtil.connection();
		BaiBao reuslt = BaiBaoDAO.selectByMaBaiBao(mabb);
//		JDBCUtil.closeConnection();
		return reuslt;
	}
	public void removeBaiBao(BaiBao baiBao) {
//		JDBCUtil.connection();
		TheLoaiDAO.removeTheLoai(baiBao);
		BaiBaoDAO.removeBaiBaoByMaBaiBao(baiBao);
//		JDBCUtil.closeConnection();
	}
	public ArrayList<BaiBao> getBaiBaoByTheLoai(String theLoaiChinh, String theLoaiPhu) {
//		JDBCUtil.connection();
		ArrayList<BaiBao> baos = BaiBaoDAO.getBaiBaoByTheLoai(theLoaiChinh, theLoaiPhu);
//		JDBCUtil.closeConnection();
		return baos;
	}
	public ArrayList<BaiBao> getBaiBaoByTenDanhNap(String tenDangNhap) {
//		JDBCUtil.connection();
		ArrayList<BaiBao> baos = BaiBaoDAO.selectByTenDangNhap(tenDangNhap);
//		JDBCUtil.closeConnection();
		return baos;
	}
	public ArrayList<BaiBao> searchBaiBao(String search) {
//		JDBCUtil.connection();
		ArrayList<BaiBao> res = BaiBaoDAO.selectByTen(search);
//		JDBCUtil.closeConnection();

		return res;
	}
	public ArrayList<BaiBao> getXuHuong() {
//		JDBCUtil.connection();
		ArrayList<BaiBao> res = BaiBaoDAO.selectXuHuong();
//		JDBCUtil.closeConnection();

		return res;
	}
	public ArrayList<BaiBao> getTopView() {
//		JDBCUtil.connection();
		ArrayList<BaiBao> res = BaiBaoDAO.selectTopView();
//		JDBCUtil.closeConnection();

		return res;
	}
	public NguoiDung getNguoiDung(String tenDangNhap) {
		return NguoiDungDAO.selectByTenDangNhap(tenDangNhap);
	}
	public void updateNguoiDung(NguoiDung nguoiDung	) {
		NguoiDungDAO.updateNguoiDung(nguoiDung);
	}
	public void addBinhLuan(BinhLuan binhLuan) {
		BinhLuanDAO.insertBinhLuan(binhLuan);
	}
	public ArrayList<BinhLuan> getBinhLuan(BaiBao baiBao){
		return BinhLuanDAO.selectByBaiBao(baiBao);
	}
}

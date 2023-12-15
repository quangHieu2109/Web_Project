package dao;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.BaiBao;
import model.BinhLuan;
import model.DSTheLoai;
import model.NguoiDung;
import model.TheLoai;

public class BaiBaoDAO {
	public static void updateBaiBao(BaiBao bao) {
		
	}
	public static ArrayList<BaiBao> selectAll() {
		ArrayList<BaiBao> result = new ArrayList<BaiBao>();
		BinhLuanDAO binhLuanDAO = new BinhLuanDAO();
		NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from baibao";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maBaiBao = rs.getString("maBaiBao");
				String tenBaiBao = rs.getString("tenBaiBao");
				String moTa = rs.getString("moTa");
				String filePath = rs.getString("filePath");
				String noiDung = rs.getString("noiDung");
				Date ngayDang = rs.getDate("ngayDang");
				String tenDangNhap = rs.getString("tenDangNhap");
				int luotXem = rs.getInt("luotXem");

				NguoiDung nguoiDung = nguoiDungDAO.selectByTenDangNhap(tenDangNhap);
				BaiBao baiBao = new BaiBao(maBaiBao, tenBaiBao, moTa, filePath, noiDung, ngayDang, nguoiDung, luotXem);
				ArrayList<BinhLuan> dsBinhLuan = binhLuanDAO.selectByBaiBao(baiBao);
				DSTheLoai dsTheLoai = theLoaiDAO.selectByBaiBao(baiBao);
				baiBao.addAllBinhLuan(dsBinhLuan);
				baiBao.setTheLoai(dsTheLoai);
				result.add(baiBao);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		//
		return result;
	}
	public ArrayList<BaiBao> select(){
		ArrayList<BaiBao> result = new ArrayList<BaiBao>();
		
		int i = selectAll().size()-6;
		if(i>=0) {
			i = (selectAll().size()-3)/3;
			for(int j=3; j<i*3+3; j++) {
				result.add(selectAll().get(j));
			}
		}
		
		return result;
	}
	public int countAll() {
		int result =0;
		JDBCUtil.connection();
		Connection con = JDBCUtil.getConnection();
		try {
			String sql = "select count(*) from baibao";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs  = st.executeQuery();
			rs.next();
			result = rs.getInt(1);
			rs.close();
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		JDBCUtil.closeConnection();
		return result;
	}
	public ArrayList<BaiBao> selectOrderByTime() {
		int size = ((countAll() -4)/3)*3+4;
		ArrayList<BaiBao> temp = new ArrayList<BaiBao>();
		ArrayList<BaiBao> result = new ArrayList<BaiBao>();
		BinhLuanDAO binhLuanDAO = new BinhLuanDAO();
		NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		try {
			JDBCUtil.connection();
			Connection conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM baibao ORDER BY ngayDang DESC LIMIT " + size;
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maBaiBao = rs.getString("maBaiBao");
				String tenBaiBao = rs.getString("tenBaiBao");
				String moTa = rs.getString("moTa");
				String filePath = rs.getString("filePath");
				String noiDung = rs.getString("noiDung");
				Date ngayDang = rs.getDate("ngayDang");
				String tenDangNhap = rs.getString("tenDangNhap");
				int luotXem = rs.getInt("luotXem");

				NguoiDung nguoiDung = nguoiDungDAO.selectByTenDangNhap(tenDangNhap);
				BaiBao baiBao = new BaiBao(maBaiBao, tenBaiBao, moTa, filePath, noiDung, ngayDang, nguoiDung, luotXem);
				ArrayList<BinhLuan> dsBinhLuan = binhLuanDAO.selectByBaiBao(baiBao);
				DSTheLoai dsTheLoai = theLoaiDAO.selectByBaiBao(baiBao);
				baiBao.addAllBinhLuan(dsBinhLuan);
				baiBao.setTheLoai(dsTheLoai);
				result.add(baiBao);
				

				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
		JDBCUtil.closeConnection();
		return result;
	}
	public ArrayList<BaiBao> selectOrderByTime(int size) {
		ArrayList<BaiBao> temp = new ArrayList<BaiBao>();
		ArrayList<BaiBao> result = new ArrayList<BaiBao>();
		BinhLuanDAO binhLuanDAO = new BinhLuanDAO();
		NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		try {
			JDBCUtil.connection();
			Connection conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM baibao ORDER BY ngayDang DESC LIMIT " + size;
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maBaiBao = rs.getString("maBaiBao");
				String tenBaiBao = rs.getString("tenBaiBao");
				String moTa = rs.getString("moTa");
				String filePath = rs.getString("filePath");
				String noiDung = rs.getString("noiDung");
				Date ngayDang = rs.getDate("ngayDang");
				String tenDangNhap = rs.getString("tenDangNhap");
				int luotXem = rs.getInt("luotXem");

				NguoiDung nguoiDung = nguoiDungDAO.selectByTenDangNhap(tenDangNhap);
				BaiBao baiBao = new BaiBao(maBaiBao, tenBaiBao, moTa, filePath, noiDung, ngayDang, nguoiDung, luotXem);
				ArrayList<BinhLuan> dsBinhLuan = binhLuanDAO.selectByBaiBao(baiBao);
				DSTheLoai dsTheLoai = theLoaiDAO.selectByBaiBao(baiBao);
				baiBao.addAllBinhLuan(dsBinhLuan);
				baiBao.setTheLoai(dsTheLoai);
				result.add(baiBao);
				

				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
		JDBCUtil.closeConnection();
		return result;
	}

	public static ArrayList<BaiBao> selectByTen(String tenBB) {
		ArrayList<BaiBao> result = new ArrayList<BaiBao>();
		BinhLuanDAO binhLuanDAO = new BinhLuanDAO();
		NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "Select * from baibao where tenBaiBao like ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" + tenBB.replace(' ', '%') + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maBaiBao = rs.getString("maBaiBao");
				String tenBaiBao = rs.getString("tenBaiBao");
				String moTa = rs.getString("moTa");
				String filePath = rs.getString("filePath");
				String noiDung = rs.getString("noiDung");
				Date ngayDang = rs.getDate("ngayDang");
				String tenDangNhap = rs.getString("tenDangNhap");
				int luotXem = rs.getInt("luotXem");

				NguoiDung nguoiDung = nguoiDungDAO.selectByTenDangNhap(tenDangNhap);
				BaiBao baiBao = new BaiBao(maBaiBao, tenBaiBao, moTa, filePath, noiDung, ngayDang, nguoiDung, luotXem);
				ArrayList<BinhLuan> dsBinhLuan = binhLuanDAO.selectByBaiBao(baiBao);
				DSTheLoai dsTheLoai = theLoaiDAO.selectByBaiBao(baiBao);
				baiBao.addAllBinhLuan(dsBinhLuan);
				baiBao.setTheLoai(dsTheLoai);
				result.add(baiBao);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

	public static ArrayList<BaiBao> selectByTheLoai(DSTheLoai theLoai) {
		ArrayList<BaiBao> result = new ArrayList<BaiBao>();
		BinhLuanDAO binhLuanDAO = new BinhLuanDAO();
		NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "";
			PreparedStatement st = null;
			if (theLoai.getDsTheLoaiPhu().size() > 0) {
				sql = "SELECT baibao.maBaiBao, baibao.tenBaiBao, baibao.moTa, baibao.filePath, baibao.noiDung, baibao.ngayDang, baibao.tenDangNhap, baibao.luotXem "
						+ "FROM (baibao INNER JOIN theloaichinh ON baibao.maBaiBao = theloaichinh.maBaiBao) INNER JOIN danhsachtheloaiphu ON baibao.maBaiBao = danhsachtheloaiphu.maBaiBao "
						+ " WHERE theloaichinh.maTheLoai=? AND danhsachtheloaiphu.maTheLoai=?";
				st = conn.prepareStatement(sql);
				st.setString(1, theLoai.getTheLoaiChinh().getMaTheLoai());
				st.setString(2, theLoai.getDsTheLoaiPhu().get(0).getMaTheLoai());
			} else {
				sql = "SELECT baibao.maBaiBao, baibao.tenBaiBao, baibao.moTa, baibao.filePath, baibao.noiDung, baibao.ngayDang, baibao.tenDangNhap, baibao.luotXem "
						+ "FROM (baibao INNER JOIN theloaichinh ON baibao.maBaiBao = theloaichinh.maBaiBao) INNER JOIN danhsachtheloaiphu ON baibao.maBaiBao = danhsachtheloaiphu.maBaiBao "
						+ " WHERE theloaichinh.maTheLoai=? ";
				st = conn.prepareStatement(sql);
				st.setString(1, theLoai.getTheLoaiChinh().getMaTheLoai());
			}

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maBaiBao = rs.getString("maBaiBao");
				String tenBaiBao = rs.getString("tenBaiBao");
				String moTa = rs.getString("moTa");
				String filePath = rs.getString("filePath");
				String noiDung = rs.getString("noiDung");
				Date ngayDang = rs.getDate("ngayDang");
				String tenDangNhap = rs.getString("tenDangNhap");
				int luotXem = rs.getInt("luotXem");

				NguoiDung nguoiDung = nguoiDungDAO.selectByTenDangNhap(tenDangNhap);
				BaiBao baiBao = new BaiBao(maBaiBao, tenBaiBao, moTa, filePath, noiDung, ngayDang, nguoiDung, luotXem);
				ArrayList<BinhLuan> dsBinhLuan = binhLuanDAO.selectByBaiBao(baiBao);
				DSTheLoai dsTheLoai = theLoaiDAO.selectByBaiBao(baiBao);
				baiBao.addAllBinhLuan(dsBinhLuan);
				baiBao.setTheLoai(dsTheLoai);
				result.add(baiBao);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

	public static boolean addBaiBao(BaiBao baiBao) {
		JDBCUtil.connection();
		Connection conn = JDBCUtil.getConnection();
		try {
			String sql = "insert into baibao(maBaiBao, tenBaiBao, moTa, filePath, noiDung, ngayDang, tenDangNhap, luotXem)"
					+ " values(?,?,?,?,?,?,?,?);";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, baiBao.getMaBaiBao());
			st.setString(2, baiBao.getTieuDe());
			st.setString(3, baiBao.getMoTa());
			st.setString(4, baiBao.getFilePath());
			st.setString(5, baiBao.getNoiDung());
			st.setDate(6, baiBao.getNgayDang());
			st.setString(7, baiBao.getNguoiDang().getTenDangNhap());
			st.setInt(8, baiBao.getLuotXem());
			int res = st.executeUpdate();
			
			sql = "insert into baibao(maBaiBao, tenBaiBao, moTa, filePath, noiDung, ngayDang, tenDangNhap, luotXem)"
					+ " values('" + baiBao.getMaBaiBao() + "', '" + baiBao.getTieuDe() + "', '" + baiBao.getMoTa()
					+ "', '" + baiBao.getFilePath() + "', '" + baiBao.getNoiDung() + "', '" + baiBao.getNgayDang()
					+ "', '" + baiBao.getNguoiDang().getTenDangNhap() + "'," + baiBao.getLuotXem() + ");";
			TheLoaiDAO.insertTheLoaiByBaiBao(baiBao);

			JDBCUtil.closeConnection();
			return res==1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public static void removeBaiBao(BaiBao baiBao) {

	}

	public static void main(String[] args) {
		JDBCUtil.connection();
		BaiBaoDAO dao = new BaiBaoDAO();
		DSTheLoai dsTheLoai = new DSTheLoai(new TheLoai("tl1", null));

		for (BaiBao bb : dao.selectByTheLoai(dsTheLoai)) {
			System.out.println(bb);
		}
		System.out.println("\n");
		dsTheLoai.addTheLoai(new TheLoai("tl3", null));
		for (BaiBao bb : dao.selectByTheLoai(dsTheLoai)) {
			System.out.println(bb);
		}
		JDBCUtil.closeConnection();
		
	}
}

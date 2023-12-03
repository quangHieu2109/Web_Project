package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import database.JDBCUtil;
import model.BaiBao;
import model.BinhLuan;
import model.DSTheLoai;
import model.NguoiDung;
import model.TheLoai;


public class BaiBaoDAO {
	public ArrayList<BaiBao> selectAll() {
		ArrayList<BaiBao> result = new ArrayList<BaiBao>();
		BinhLuanDAO binhLuanDAO = new BinhLuanDAO();
		NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from baibao";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
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
	public ArrayList<BaiBao> selectByTen(String tenBB){
		ArrayList<BaiBao> result = new ArrayList<BaiBao>();
		BinhLuanDAO binhLuanDAO = new BinhLuanDAO();
		NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "Select * from baibao where tenBaiBao like ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%"+tenBB.replace(' ', '%')+"%");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
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
	public ArrayList<BaiBao> selectByTheLoai(DSTheLoai theLoai){
		ArrayList<BaiBao> result = new ArrayList<BaiBao>();
		BinhLuanDAO binhLuanDAO = new BinhLuanDAO();
		NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "";
			PreparedStatement st = null;
			if(theLoai.getDsTheLoaiPhu().size()>0) {
				sql="SELECT baibao.maBaiBao, baibao.tenBaiBao, baibao.moTa, baibao.filePath, baibao.noiDung, baibao.ngayDang, baibao.tenDangNhap, baibao.luotXem "
						 +"FROM (baibao INNER JOIN theloaichinh ON baibao.maBaiBao = theloaichinh.maBaiBao) INNER JOIN danhsachtheloaiphu ON baibao.maBaiBao = danhsachtheloaiphu.maBaiBao "
						+" WHERE theloaichinh.maTheLoai=? AND danhsachtheloaiphu.maTheLoai=?";
				st=conn.prepareStatement(sql);
				st.setString(1, theLoai.getTheLoaiChinh().getMaTheLoai());
				st.setString(2, theLoai.getDsTheLoaiPhu().get(0).getMaTheLoai());
			}else {
				sql="SELECT baibao.maBaiBao, baibao.tenBaiBao, baibao.moTa, baibao.filePath, baibao.noiDung, baibao.ngayDang, baibao.tenDangNhap, baibao.luotXem "
						 +"FROM (baibao INNER JOIN theloaichinh ON baibao.maBaiBao = theloaichinh.maBaiBao) INNER JOIN danhsachtheloaiphu ON baibao.maBaiBao = danhsachtheloaiphu.maBaiBao "
						+" WHERE theloaichinh.maTheLoai=? ";
				st=conn.prepareStatement(sql);
				st.setString(1, theLoai.getTheLoaiChinh().getMaTheLoai());
			}
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
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
	public void addBaiBao(BaiBao baiBao) {
		
	}
	public void removeBaiBao(BaiBao baiBao) {
		
	}
	public static void main(String[] args) {
		JDBCUtil.connection();
		BaiBaoDAO dao = new BaiBaoDAO();
		DSTheLoai dsTheLoai = new DSTheLoai(new TheLoai("tl1", null));
		
		for(BaiBao bb:dao.selectByTheLoai(dsTheLoai)) {
			System.out.println(bb);
		}
		System.out.println("\n");
		dsTheLoai.addTheLoai(new TheLoai("tl3", null));
		for(BaiBao bb:dao.selectByTheLoai(dsTheLoai)) {
			System.out.println(bb);
		}
		JDBCUtil.closeConnection();
	}
}

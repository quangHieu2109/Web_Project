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
import model.NguoiDung;
import model.TheLoai;

public class NguoiDungDAO {
	public List<NguoiDung> selectAll() {
		List<NguoiDung> result = new ArrayList<NguoiDung>();
		// 
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from nguoidung";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String tenNguoiDung = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String hoVaTen = rs.getString("hoVaTen");
				String email = rs.getString("email");
				Date ngaySinh = rs.getDate("ngaySinh");
				result.add(new NguoiDung(tenNguoiDung, matKhau, hoVaTen, email, ngaySinh));
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public NguoiDung selectByTenDangNhap(String tenDN) {
		NguoiDung result = null;
		// 
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from nguoidung where tenDangNhap=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tenDN);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String tenNguoiDung = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String hoVaTen = rs.getString("hoVaTen");
				String email = rs.getString("email");
				Date ngaySinh = rs.getDate("ngaySinh");
				result=new NguoiDung(tenNguoiDung, matKhau, hoVaTen, email, ngaySinh);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public int insertNguoiDung(NguoiDung nguoiDung) {
		int result =0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "insert into nguoidung (tenDangNhap, matKhau, hoVaTen, email, ngaySinh)"
					+ " values (?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, nguoiDung.getTenDangNhap());
			st.setString(2, nguoiDung.getMatKhau());
			st.setString(3, nguoiDung.getHoVaTen());
			st.setString(4, nguoiDung.getEmail());
			st.setDate(5, nguoiDung.getNgaySinh());
			result = st.executeUpdate();
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result; //so dong thay doi
	}
	public int removeNguoiDung(NguoiDung nguoiDung) {
		int result =0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "delete from nguoidung where tenDangNhap=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, nguoiDung.getTenDangNhap());
			result = st.executeUpdate();
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result; //so dong thay doi
	}
	public int updateNguoiDung(NguoiDung nguoiDung) {
		int result =0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "update nguoidung set matKhau =?, hoVaten=?, email=?, ngaySinh=? where tenDangNhap=?";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, nguoiDung.getMatKhau());
			st.setString(2, nguoiDung.getHoVaTen());
			st.setString(3, nguoiDung.getEmail());
			st.setDate(4, nguoiDung.getNgaySinh());
			st.setString(5, nguoiDung.getTenDangNhap());
			result = st.executeUpdate();
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result; //so dong thay doi
	}
	public static void main(String[] args) {
		JDBCUtil.connection();
		NguoiDungDAO dao = new NguoiDungDAO();
//		for(NguoiDung ng : dao.getDSNguoiDung()) {
//			System.out.println(ng);
//		}
//		System.out.println(dao.updateNguoiDung(new NguoiDung("hiu3", "123123456", "Quang Hiu", "asb@gmail.com", null)));;
//		System.out.println(dao.selectByTenDangNhap("hiu3"));
	}
}
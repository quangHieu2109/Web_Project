package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import model.BaiBao;
import model.DSTheLoai;
import model.TheLoai;

public class TheLoaiDAO extends GeneralDAO {
	public List<TheLoai> getDSTheLoai() {
		List<TheLoai> result = new ArrayList<TheLoai>();
//	ArrayList<String> values = new ArrayList<String>();
//	values.add("kinh te");
//	values.add("doi");
//	result.add(new TheLoai("chinh tri", values)); Test data
		//
		return result;
	}

	public DSTheLoai selectByBaiBao(BaiBao baiBao) {
		DSTheLoai result = new DSTheLoai();
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "SELECT theloai.maTheLoai, theloai.tenTheLoai FROM theloai INNER JOIN theloaichinh ON theloai.maTheLoai = theloaichinh.maTheLoai WHERE theloaichinh.maBaiBao=? ";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, baiBao.getMaBaiBao());
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maTheLoai = rs.getString(1);
				String tenTheLoai = rs.getString(2);
				
				result.setTheLoaiChinh(new TheLoai(maTheLoai, tenTheLoai));
			}
			sql = "SELECT theloai.maTheLoai, theloai.tenTheLoai FROM theloai INNER JOIN danhsachtheloaiphu ON"
					+ " theloai.maTheLoai = danhsachtheloaiphu.maTheLoai WHERE danhsachtheloaiphu.maBaiBao=?;";
			st = conn.prepareStatement(sql);
			st.setString(1, baiBao.getMaBaiBao());
			rs = st.executeQuery();
			while (rs.next()) {
				String maTheLoai = rs.getString(1);
				String tenTheLoai = rs.getString(2);
				result.addTheLoai(new TheLoai(maTheLoai, tenTheLoai));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

	public int insertTheLoaiByBaiBao(BaiBao baiBao) {
		int result=0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql ="insert into theloaichinh(maBaiBao, maTheLoai) values (?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, baiBao.getMaBaiBao());
			st.setString(2, baiBao.getTheLoai().getTheLoaiChinh().getMaTheLoai());
			result += st.executeUpdate();
			
			sql="insert into danhsachtheloaiphu(maBaiBao, maTheLoai) values (?,?)";
			st = conn.prepareStatement(sql);
			for(TheLoai tl:baiBao.getTheLoai().getDsTheLoaiPhu()) {
				st.setString(1, baiBao.getMaBaiBao());
				st.setString(2, tl.getMaTheLoai());
				result += st.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}

	public void removeTheLoai(BaiBao baiBao) {

	}

	public static void main(String[] args) {
		JDBCUtil.connection();
		TheLoaiDAO dao = new TheLoaiDAO();
		DSTheLoai tl = dao.selectByBaiBao(new BaiBao("bb1", null, null, null, null, null, null, 0, null, null));
		System.out.println(tl);
		BaiBao bb = new BaiBao("bb4", "123", null, null, null, null, null, 0);
		bb.setTheLoai(tl);
		System.out.println(dao.insertTheLoaiByBaiBao(bb));;
	}
}
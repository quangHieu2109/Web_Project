package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
	private static Connection conn = null;

	public static void connection() {
		try {
			// Đăng ký MySQL Driver với DriverManager
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// Các thông số
			String url = "jdbc:mySQL://localhost:3306/web";
			String username = "root";
			String password = ""; 

			// Tạo kết nối
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Kết nối thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Kết nối thất bại");
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return conn;
	}

	public static void backup() {
		try {
			// Đọc mật khẩu từ một nguồn an toàn hơn, ví dụ như tệp cấu hình
			String password = "your_password";

			// Xây dựng lệnh mysqldump với mật khẩu
			String command = String.format("mysqldump -u root -p%s web > backup.sql", password);

			// Thực thi lệnh và chờ kết quả
			Process process = Runtime.getRuntime().exec(command);
			int exitCode = process.waitFor();

			// Kiểm tra và in thông báo tương ứng
			if (exitCode == 0) {
				System.out.println("Backup successful");
			} else {
				System.out.println("Backup failed");
			}
		} catch (IOException | InterruptedException e) {
			// Ghi log nếu có lỗi
			e.printStackTrace();
		}
	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		JDBCUtil.connection();
		Connection con = JDBCUtil.getConnection();
		String sql = "insert into nguoidung values ('hiu3','123123','Ngo Quang Hieu', null, null)";
		PreparedStatement st = con.prepareStatement(sql);
		System.out.println(st.executeUpdate());
//		JDBCUtil.backup();
		JDBCUtil.closeConnection();
	}
}

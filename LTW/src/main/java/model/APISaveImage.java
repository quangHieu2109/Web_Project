package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class APISaveImage {
	private final String EMAIL = "lavekax254@gearstag.com";
	private final String PASSWORD = "hoctapdh0001";
	

	public static String uploadImageAndGetLink(InputStream imageFile,String nameFile) {
		try {
			URL url = new URL("https://api.imgur.com/3/upload");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Cấu hình request
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "Client-ID " + "dd8ce706a76465e");
			String boundary = "---------------------------" + System.currentTimeMillis();
			connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

			OutputStream outputStream = connection.getOutputStream();
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));

			// Gửi file ảnh
			writer.append("--").append(boundary).append("\r\n");
			writer.append("Content-Disposition: form-data; name=\"image\"; filename=\"").append(nameFile)
					.append("\"\r\n");
			writer.append("Content-Type: ").append("image/jpeg").append("\r\n");
			writer.append("\r\n");
			writer.flush();
			InputStream inputStream = imageFile;
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			outputStream.flush();
			inputStream.close();

			writer.append("\r\n");
			writer.append("--").append(boundary).append("--\r\n");
			writer.close();
			outputStream.close();
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
				reader.close();
				JSONObject json = new JSONObject(response.toString()).getJSONObject("data");

				return json.getString("link");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}

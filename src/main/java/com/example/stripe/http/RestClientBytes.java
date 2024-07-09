package com.example.stripe.http;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public interface RestClientBytes {

	byte[] getBytes(String url, Map<String, String> headers);

	public default byte[] getBytes(URL location, Map<String, String> headers) throws Exception {

		byte[] response = null;
		HttpURLConnection conn = null;
		try {
			// url = URLEncoder.encode(url, "UTF-8");

			System.out.println("AFTER REST URL Object: ");
			conn = (HttpURLConnection) location.openConnection();
			System.out.println("AFTER REST connection open: ");
			conn.setRequestMethod("GET");
			if (headers != null) {
				Set<String> keys = headers.keySet();
				for (String key : keys) {
					Object value = headers.get(key);
					conn.setRequestProperty(key, (String) value);
				}
			}
			response = responseBytes(conn);
			System.out.println("AFTER REST response: " + response);
		} catch (MalformedURLException murle) {
			// TODO Auto-generated catch block
			murle.printStackTrace();
			throw new Exception(murle);
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
			throw new Exception(ioe);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return response;
	}
	
	public default byte[] responseBytes(HttpURLConnection conn) throws IOException {

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int ch = 0;
		BufferedInputStream inputStream = new BufferedInputStream(conn.getInputStream());
		byte[] buffer = new byte[2048];
		while ((ch = inputStream.read(buffer, 0, buffer.length)) != -1) {
			output.write(buffer, 0, ch);
		}
		
		output.close();
		inputStream.close();
		byte imgdata[] = output.toByteArray();
		return imgdata;
	}
}

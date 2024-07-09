package com.example.stripe.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public interface RestClientStream {
	public <T> String post(String url, InputStream inputStream, Map<String, T> headers) throws IOException;
	
	default String response(HttpURLConnection conn) throws IOException {
		StringBuilder lines = new StringBuilder();
		String inputLine = null;
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader in = new BufferedReader(isr);

		while ((inputLine = in.readLine()) != null) {
			// System.out.println("inputLine: " + inputLine);
			lines.append(inputLine);
		}
		int responseCode = conn.getResponseCode();
		in.close();
		return lines.toString();
	}
	
	default void pipe(InputStream input, OutputStream output, int bufferSize) throws IOException {
		System.out.println("PIPE ");
		if (bufferSize > 0) {
			byte[] buf = new byte[1024];
			int read = 0;
			while ((read = input.read(buf, 0, buf.length)) != -1) {
				System.out.println("WRITE");
				output.write(buf, 0, read);
			}
		}
		input.close();

	}
	
	public default <T> String post(URL url, InputStream inputStream, Map<String, T> headers) throws IOException {
		int available = inputStream.available();
		System.out.println("POST_URL: " + url);
		// Construct data
		// JSONObject object = new JSONObject();
		// StringBuilder object = new StringBuilder();

		HttpURLConnection conn = null;
		OutputStream os = null;
		// Send data
		try {
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);

			Set<String> headerKeys = headers.keySet();
			System.out.println("KEYS_SIZE: " + headerKeys.size());
			for (String key : headerKeys) {
				String value = (String) headers.get(key);
				conn.setRequestProperty(key, value);
			}

			conn.setRequestProperty("Content-Length", Integer.toString(available));
			System.out.println("DATA_LENGTH: " + available);
			os = conn.getOutputStream();
			if (inputStream != null) {
				// Writer writer = new OutputStreamWriter(os, "UTF-8");
				// Reader content = new StringReader(object.toString());
				pipe(inputStream, os, available);
				os.flush();
				os.close();
			}
			String response = response(conn);
			System.out.println("REST.post response: " + response);
			return response;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			if (os != null) {
				os.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return "";
	}
}

package com.example.stripe.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RESTClient {
	
	public static synchronized String httpGet(String url) throws Exception {
		return  httpGet(url, null);
	}
	
	public static synchronized String httpGet(String url, Map<String,String> headers) throws Exception {
		
		Builder builder = HttpRequest.newBuilder(new  URI(url));
		if (headers !=  null) {
			Set<String> headerNames = headers.keySet();
			for (String name: headerNames) {
		
			String value = headers.get(name);
			builder.header(name, value);
		
			}
		}
		HttpRequest request = builder
				.GET()
				.build();
		HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}

	public static synchronized String get(String url) throws Exception {
		return get(url, null);
	}

	public static synchronized String get(URL location) throws Exception {
		return get(location, null);
	}

	public static synchronized String get(String url, Map<String, String> headers) throws Exception {
		System.out.println("REST get: " + url);
		URL location = new URL(url);
		return get(location, headers);
	}

	public static synchronized String get(URL location, Map<String, String> headers) throws Exception {

		String response = null;
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
			response = response(conn);
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

	public static synchronized byte[] getBytes(String url, Map<String, String> headers) throws Exception {
		System.out.println("REST getBytes: " + url);
		URL location = new URL(url);
		return getBytes(location, headers);
	}

	public static synchronized byte[] getBytes(URL location, Map<String, String> headers) throws Exception {

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

	public static <T> String post(String url, Map<String, Object> data, Map<String, T> headers) throws IOException {

		System.out.println("POST_URL: " + url);
		// Construct data
		// JSONObject object = new JSONObject();
		StringBuilder object = new StringBuilder();
		if (data != null) {
			Set<String> keys = data.keySet();
			System.out.println("KEYS_SIZE: " + keys.size());
			for (String key : keys) {
				try {
					Object value = data.get(key);
					System.out.println(key + " key:value " + value);

					object.append(URLEncoder.encode(key, "UTF-8") + "=" + value + "&");
					System.out.println("QUERY_BUILDER: " + object.toString());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					System.out.println("UnsupportedEncodingException: " + e.getMessage());
				}
			}
		}
		HttpURLConnection conn = null;
		OutputStream os = null;
		// Send data
		try {
			URL location = new URL(url);
			conn = (HttpURLConnection) location.openConnection();
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

			conn.setRequestProperty("Content-Length", Integer.toString(object.toString().getBytes().length));
			System.out.println("DATA_LENGTH: " + object.toString().getBytes().length);
			os = conn.getOutputStream();
			if (data != null) {
				Writer writer = new OutputStreamWriter(os, "UTF-8");
				Reader content = new StringReader(object.toString());
				pipe(content, writer, object.toString().getBytes().length);
				writer.close();
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

	public static <T> String post(String url, InputStream inputStream, Map<String, T> headers) throws IOException {
		int available = inputStream.available();
		System.out.println("POST_URL: " + url);
		// Construct data
		// JSONObject object = new JSONObject();
		// StringBuilder object = new StringBuilder();

		HttpURLConnection conn = null;
		OutputStream os = null;
		// Send data
		try {
			URL location = new URL(url);
			conn = (HttpURLConnection) location.openConnection();
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

	public static String postJSON(String url, Map<String, Object> params, Map<String, String> headers)
			throws IOException {
		params.put("post_url", url);
		return postJSON(params, headers);
	}

	public static String postJSON(Map<String, Object> params, Map<String, String> headers) throws IOException {
		String url = null;
		if (params.containsKey("post_url")) {
			System.out.println("CONTAINS (POST_URL)");
			url = (String) params.remove("post_url");
		} else {
			System.out.println("DOES NOT CONTAIN (POST_URL)");
		}
		System.out.println("POST_URL: " + url);
		// Construct data
		// Map<String,Object> object = new HashMap<>();
		// Set<String> keys = params.keySet();
		// System.out.println( "KEYS_SIZE: " + keys.size());
		// for (String key : keys) {
		// try {
		// Object value = params.get(key);
		// System.out.println( key + " key:value " + value);

		// object.put(URLEncoder.encode(key, "UTF-8"), value);
		// System.out.println( "QUERY_BUILDER: " + object.toString());
		// } catch (Exception e) {
		// TODO Auto-generated catch block
		// System.out.println( "UnsupportedEncodingException: " + e.getMessage());
		// }
		// }
		String jsonBody = unravel(params);
		HttpURLConnection conn = null;
		OutputStream os = null;
		// Send data
		try {
			URL location = new URL(url);
			conn = (HttpURLConnection) location.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			if (headers != null) {
				Set<String> headerKeys = headers.keySet();
				// System.out.println( "KEYS_SIZE: " + keys.size());
				for (String key : headerKeys) {
					String value = headers.get(key);
					conn.setRequestProperty(key, value);
				}
			}
			conn.setRequestProperty("Content-Length", Integer.toString(jsonBody.getBytes().length));
			System.out.println("DATA_LENGTH: " + jsonBody.getBytes().length);
			os = conn.getOutputStream();

			Writer writer = new OutputStreamWriter(os, "UTF-8");
			Reader content = new StringReader(jsonBody);
			pipe(content, writer, jsonBody.getBytes().length);
			writer.close();
			String response = response(conn);
			System.out.println("REST.post response: " + response);
			return response;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return e.getMessage();
		} finally {
			if (os != null) {
				os.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static String postFormData(String utl, Map<String, String> data, Map<String, String> headers)
			throws IOException {
		String urlParameters;
		DataOutputStream os = null;
		HttpURLConnection conn = null;
		try {
			urlParameters = getDataString(data);

			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			String request = "<Url here>";
			URL url;

			url = new URL(request);

			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setUseCaches(false);
			os = new DataOutputStream(conn.getOutputStream());
			os.write(postData);
			String response = response(conn);
			return response;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		} finally {
			if (os != null) {
				os.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}

	}

	public static boolean delete(String url, Map<String, String> headers) throws Exception {
		// TODO Auto-generated method stub
		boolean response = false;
		HttpURLConnection conn = null;
		try {
			// url = URLEncoder.encode(url, "UTF-8");
			URL location = new URL(url);
			System.out.println("AFTER REST URL Object: ");
			conn = (HttpURLConnection) location.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("DELETE");
			if (headers != null) {
				Set<String> keys = headers.keySet();
				for (String key : keys) {
					String value = headers.get(key);
					conn.setRequestProperty(key, value);
				}
			}
			response = noContentResponse(conn);
			System.out.println("AFTER REST response: " + response);
		} catch (MalformedURLException murle) {
			// TODO Auto-generated catch block
			murle.printStackTrace();
			return response;
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
			return response;
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return response;
	}

	private static String getDataString(Map<String, String> params) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (first)
				first = false;
			else
				result.append("&");
			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}
		return result.toString();
	}

	private static synchronized boolean noContentResponse(HttpURLConnection conn) throws IOException {

		conn.connect();
		int responseCode = conn.getResponseCode();

		return (responseCode == HttpURLConnection.HTTP_NO_CONTENT) ? true : false;
	}

	private static synchronized String response(HttpURLConnection conn) throws IOException {
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

	private static byte[] responseBytes(HttpURLConnection conn) throws IOException {

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

	private static void pipe(Reader data, Writer writer, int bufferSize) throws IOException {
		System.out.println("PIPE ");
		if (bufferSize > 0) {
			char[] buf = new char[bufferSize];
			int read = 0;
			while ((read = data.read(buf)) >= 0) {
				System.out.println("WRITE");
				writer.write(buf, 0, read);
			}
		}
		writer.flush();

	}

	private static void pipe(InputStream input, OutputStream output, int bufferSize) throws IOException {
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

	private static String unravel(Map<String, Object> map) {
		// JsonObject json = new JSONObject();
		String json = "";
		Map<String, Object> payload = new HashMap<>();
		Set<String> keys = map.keySet();
		System.out.println("KEYS_SIZE: " + keys.size());
		for (String key : keys) {
			Object value = map.get(key);
			System.out.println(key + " key:value " + value);
			try {
				if (value instanceof HashMap) {
					payload.put(URLEncoder.encode(key, "UTF-8"), value);
				} else {

					payload.put(URLEncoder.encode(key, "UTF-8"), value);

				}
				json = new ObjectMapper().writeValueAsString(payload);
				System.out.println("QUERY_BUILDER: " + json);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("UnsupportedEncodingException: " + e.getMessage());
			}
		}

		return json;
	}
}

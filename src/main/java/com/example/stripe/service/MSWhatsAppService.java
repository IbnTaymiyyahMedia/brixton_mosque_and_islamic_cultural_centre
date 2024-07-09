package com.example.stripe.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.RequestBodySpec;
import org.springframework.web.client.RestClient.RequestHeadersUriSpec;

import com.example.stripe.http.MSPostHeaders;
import com.example.stripe.http.RestClientBytes;
import com.example.stripe.http.RestClientDelete;
import com.example.stripe.http.RestClientGet;
import com.example.stripe.http.RestClientPost;
import com.example.stripe.http.RestClientStream;
import com.example.stripe.repository.MSWhatsAppRepository;
import com.example.stripe.service.MESSAGE_MODEL.KEY;
import com.example.stripe.util.IConfig;
import com.example.stripe.util.MSConfig;

@Service
public class MSWhatsAppService implements MSWhatsApp, RestClientPost, RestClientGet, RestClientDelete, RestClientStream, RestClientBytes {

	@Autowired
	MSWhatsAppRepository repository;

	private final RestClient restClient;
	
	private final String accessToken;
	
	
	private final Environment env;
	
	private final IConfig config = MSConfig.getInstance();
	
	@Autowired
	public MSWhatsAppService(Environment env) {
		this.env = env;
		restClient = RestClient.builder()
				.baseUrl(MSWhatsApp.DOMAIN)
				.build();
		accessToken = env.getProperty("whatsapp.access.token");
		 POST_HEADERS = new MSPostHeaders() {
			{
				put(AUTHORIZATION, "Bearer " + accessToken);
				put(CONTENT_TYPE, APPLICATION_JSON);
			}
		};
	}
	
	private final MSPostHeaders POST_HEADERS;
	
	public String register(String phoneNumberId) {
		return registerPhone(phoneNumberId, POST_HEADERS,this) ;
	}

	public String deregister(String phoneNumberId) {
		return deregisterPhone(phoneNumberId,POST_HEADERS,this) ;
	}
	
	public String text(String recipientPhoneNumber, String text) {
  		return sendTextMessage(recipientPhoneNumber, text,POST_HEADERS, this);
	}
	
	public String previewURL(String recipientPhoneNumber, String previewURL) {
		return sendTextMessageWithPreviewURL(recipientPhoneNumber, previewURL, POST_HEADERS, this);
	}
	
	
	public String imageURL(String recipientPhoneNumber, String imageURL) {
		return sendImageMessageByURL(recipientPhoneNumber, imageURL,POST_HEADERS, this);
	}
	
	
	public String audioURL(String recipientPhoneNumber, String audioURL) {
		return sendAudioMessageByURL(recipientPhoneNumber, audioURL, POST_HEADERS, this);
	}
	
	
	public String sendDocumentMessageByURL(String recipientPhoneNumber, String documentURL) {
		return sendDocumentMessageByURL(recipientPhoneNumber, documentURL, "See attachment", POST_HEADERS, this);
	}
	
	
	public String updateBusinessProfile(String text) {
		
		return updateBusinessProfile(BUSINESS_PROFILE,POST_HEADERS, this);
	}
	
	
	public String getPhoneNumbers() {
		return getPhoneNumbers();
	}
	
	
	public String getProfileId() {
		return getBusinessProfileId(POST_HEADERS, this);
	}
	
	
	public HttpEntity<byte[]> downloadJpeg(String mediaURL) {
		byte[] image = downloadMedia("https://pps.whatsapp.net/v/t61.24694-24/417341724_383816014589351_6309006714023920586_n.jpg?ccb=11-4&oh=01_AdTivGVWj8-nGtBkijijsRR_2R-MBg3EAQHvSIi8PMaLAA&oe=65EB8758&_nc_sid=e6ed6c&_nc_cat=105",POST_HEADERS, this);
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    headers.setContentLength(image.length);

	    return new HttpEntity<byte[]>(image, headers);
	}
	
	
	public String sendReplyToTextMessage(String fromPhoneNumber, String text, String messageId) {
		return sendReplyToTextMessage( fromPhoneNumber,  text,  messageId);
	}

	public String setPhoneNumber(String phoneNumber, String verifiedName) {
		// TODO Auto-generated method stub
		PHONE_NUMBER phone = new PHONE_NUMBER();
		phone.put(KEY.phone_number, phoneNumber);
		phone.put(KEY.verified_name, verifiedName);
		return setPhoneNumbers(phone,POST_HEADERS, this);
	}

	@Override
	public byte[] getBytes(String url, Map<String, String> headers) {
		// TODO Auto-generated method stub
		URL location;
		try {
			location = new URL(url);
			return getBytes(location, headers);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new byte[0];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new byte[0];
		}
	}

	@Override
	public <T> String post(String url, InputStream inputStream, Map<String, T> headers) throws IOException {
		// TODO Auto-generated method stub
		URL location = new URL(url);
		return post(location, inputStream, headers);
	}

	@Override
	public void delete(String uri, Map<String, String> headers) {
		// TODO Auto-generated method stub
		RequestHeadersUriSpec<?> request = restClient.delete();
		
		Set<String> keys = headers.keySet();
		for (String headerName: keys) {
			String headerValue = headers.get(headerName);
			request.header(headerName, headerValue);
		}
		request.uri(uri)
				.retrieve()
				.toBodilessEntity();
	}

	@Override
	public String get(String uri, Map<String, String> headers) {
		// TODO Auto-generated method stub
		RequestHeadersUriSpec<?> request = restClient.get();
		
		Set<String> keys = headers.keySet();
		for (String headerName: keys) {
			String headerValue = headers.get(headerName);
			request.header(headerName, headerValue);
		}
		return request.uri(uri)
				.retrieve()
				.body(String.class);
	}

	@Override
	public String post(String uri, Map<String, Object> body, Map<String, String> headers) {
		// TODO Auto-generated method stub
		RequestBodySpec request = restClient.post()
				.uri(uri);
		Set<String> keys = headers.keySet();
		for (String headerName: keys) {
			String headerValue = headers.get(headerName);
			request.header(headerName, headerValue);
		}
		return request.body(body)
				.retrieve()
				.body(String.class);
	}
	
	
}

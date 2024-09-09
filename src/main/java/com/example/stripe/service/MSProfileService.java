package com.example.stripe.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.RequestBodySpec;

import com.example.stripe.http.MSPostHeaders;
import com.example.stripe.http.RestClientPost;
import com.example.stripe.http.RestClientStream;
import com.example.stripe.model.MSBusinessProfile;
import com.example.stripe.repository.MSProfileRepository;
import com.example.stripe.service.MESSAGE_MODEL.KEY;
import com.example.stripe.util.IConfig;
import com.example.stripe.util.MSConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MSProfileService implements MSWhatsApp, RestClientPost, RestClientStream {
	
	@Autowired
	MSProfileRepository repository;

private final RestClient restClient;
	

	private final IConfig config = MSConfig.getInstance();
	
	private final Environment env;
	private final String accessToken;
	
	private final MSPostHeaders POST_HEADERS ;
	
	@Autowired
	public MSProfileService(Environment env) {
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
	
	public static final int PROFILES_PER_PAGE = 20;
	
	
	public Page<MSBusinessProfile> listAll(int pageNum, String sortField, String sortDir, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public MSBusinessProfile save(MSBusinessProfile profileImage) {
		// TODO Auto-generated method stub
		return repository.save(profileImage);
	}

	public String updateBiznessProfile(MESSAGE_MODEL businessProfile) {
		// TODO Auto-generated method stub
		return updateBiznessProfile(businessProfile);
	}

	public Map<String, String> createUploadSession(String fileName, String fileType, int length) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		String sessionJson = createUploadSession(fileName, fileType, length,POST_HEADERS, this);
		Map<String, String> sessionObj = mapper.readValue(sessionJson, Map.class);
		return sessionObj;
	}

	public Map<String, String> uploadFileData(InputStream inputStream, String uploadId, String fileType) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		String fileDataJson = uploadFileData(inputStream, uploadId, fileType, accessToken, this);
		Map<String, String> fileDataObj = mapper.readValue(fileDataJson, Map.class);
		return fileDataObj;
	}

	public String updateBiznessProfile(MSBusinessProfile profileImage, String fileHandle) {
		BUSINESS_PROFILE.put(KEY.email, profileImage.getEmail());
		BUSINESS_PROFILE.put(KEY.address, profileImage.getAddress());
		BUSINESS_PROFILE.put(KEY.vertical, profileImage.getVertical());
		BUSINESS_PROFILE.put(KEY.about, profileImage.getAbout());
		BUSINESS_PROFILE.put(KEY.description, profileImage.getDescription());
		BUSINESS_PROFILE.put(KEY.profile_picture_handle, fileHandle);
		return updateBiznessProfile(BUSINESS_PROFILE);
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

	@Override
	public <T> String post(String url, InputStream inputStream, Map<String, T> headers) throws IOException {
		// TODO Auto-generated method stub
		URL location = new URL(url);
		return post(location, inputStream, headers);
	}
}

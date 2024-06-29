package com.example.stripe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.stereotype.Service;

import com.example.stripe.model.MSYouTube;
import com.example.stripe.net.RESTClient;
import com.example.stripe.repository.MSYouTubeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MSYouTubeService {

	@Autowired
	MSYouTubeRepository repository;
	
	private MSYouTube save(MSYouTube youTube) {
		return repository.save(youTube);
	}
	
	private Iterable<MSYouTube> saveAll(Iterable<MSYouTube> youTube) {
		return repository.saveAll(youTube);
	}

	private MSYouTube createModel(Map<String, Object> item) {
		// TODO Auto-generated method stub
		MSYouTube youTube = new MSYouTube();
		String kind = (String) item.get("kind");
		youTube.setKind(kind);
		String etag = (String) item.get("etag");
		youTube.setEtag(etag);
		String id = (String) item.get("id");
		youTube.setId(id);
		Map<String,Object> snippet = (Map<String, Object>) item.get("snippet");
		String publishedAt = (String) snippet.get("publishedAt");
		youTube.setPublishedAt(publishedAt);
		String title = (String) snippet.get("title");
		youTube.setTitle(title);
		String decription = (String) snippet.get("description");
		youTube.setDescription(decription);
		Map<String,Object> thumbnails = (Map<String, Object>) snippet.get("thumbnails");
		Map<String,Object> defaultThumbnails = (Map<String, Object>) thumbnails.get("default");
		String thumbnailUrl = (String) defaultThumbnails.get("url");
		youTube.setThumbnailsDefaultUrl(thumbnailUrl);
		int width = (int) defaultThumbnails.get("width");
		youTube.setThumbnailsDefaultWidth(width);
		int height = (int) defaultThumbnails.get("height");
		youTube.setThumbnailsDefaultHeight(height);
		String playlistId = (String) snippet.get("playlistId");
		youTube.setPlaylistId(playlistId);
		Integer position = (Integer) snippet.get("position");
		youTube.setPosition(position);
		Map<String,Object> resourceId = (Map<String, Object>) snippet.get("resourceId");
		String resourceIdKind = (String) resourceId.get("kind");
		youTube.setResourceIdKind(resourceIdKind);
		String resourceIdVideoId = (String) resourceId.get("videoId");
		youTube.setResourceIdVideoId(resourceIdVideoId);
		return youTube;
	}
	
	public List<MSYouTube> getPlaylist(String url, Map<String,String> headers){
		String pageToken = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<MSYouTube> playlistItems = new ArrayList<MSYouTube>();
		try {
			do {
				String nextPageToken = (pageToken != null) ? "&pageToken=" + pageToken : "";
			String playlistJson = RESTClient.get(url + nextPageToken, headers);
			Map<String, Object> playlistObj = mapper.readValue(playlistJson, Map.class);
			pageToken = (String) playlistObj.get("nextPageToken");
			
				List<Map<String, Object>> items = (List<Map<String, Object>>) playlistObj.get("items");
				for (Map<String,Object> item: items) {
					MSYouTube youTube = createModel(item);
					try {
						playlistItems.add(save(youTube));
					} catch (DbActionExecutionException psqle) {
						youTube.setIsNew(false);
						if(update(youTube)) {
							playlistItems.add(youTube);
						}
						youTube.setIsNew(true);
					}
				}
			}
			while (pageToken != null);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		}
		
		
		return playlistItems;
	}

	private boolean update(MSYouTube youTube) {
		// TODO Auto-generated method stub
		return repository.updateById(youTube.getId(), youTube.getTitle(), youTube.getDescription(), youTube.getEtag(), youTube.getKind(), youTube.getPlaylistId(), youTube.getPublishedAt(), youTube.getResourceIdKind(), youTube.getResourceIdVideoId(), youTube.getThumbnailsDefaultUrl(), youTube.getThumbnailsDefaultHeight(), youTube.getThumbnailsDefaultWidth(), youTube.getPosition());
	}
	
	public Iterable<MSYouTube> findAll() {
		return repository.findAll();
	}
}

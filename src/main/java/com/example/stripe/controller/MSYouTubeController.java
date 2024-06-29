package com.example.stripe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stripe.model.MSYouTube;
import com.example.stripe.service.MSYouTubeService;

@RestController
public class MSYouTubeController {

	@Autowired
	private MSYouTubeService service;

	private static String API_KEY = "AIzaSyC1FGFN3SG_0qoqOC-407zet2gsTjY9Erw";
	private static String CHANNEL_ID = "UCqaoFuy8aE0BJ8GdxCh9syg";
	private static String UPLOADS_ID = "UUqaoFuy8aE0BJ8GdxCh9syg";// playlist of the latest videos
	private static String DOMAIN = "https://youtube.googleapis.com/";

	/**
	 * https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=1000&playlistId=UUqaoFuy8aE0BJ8GdxCh9syg&key=[YOUR_API_KEY]
	 * HTTP/1.1 Authorization: Bearer [YOUR_ACCESS_TOKEN] Accept: application/json
	 * 
	 * @return
	 */
	@GetMapping("/youtube/videos.json")
	public List<MSYouTube> videos() {
		Map<String, String> headers = new HashMap<>();
		String url = DOMAIN + "youtube/v3/playlistItems?part=snippet&maxResults=1000&playlistId=" + UPLOADS_ID + "&key="
				+ API_KEY;
		headers.put("Accept", "application/json");
		List<MSYouTube> youTubes = service.getPlaylist(url, headers);

		return youTubes;
	}

	@GetMapping("/youtube/playlist.json")
	public Iterable<MSYouTube> playlist() {

		return service.findAll();
	}
}

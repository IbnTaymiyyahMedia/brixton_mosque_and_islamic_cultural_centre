package com.example.stripe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

public class MSYouTube implements Persistable<String> {
	private String kind;
	private String etag;
	@Id
	private String id;
	private String publishedAt;
	private String title;
	private String description;
	private String thumbnailsDefaultUrl;
	private int thumbnailsDefaultWidth;
	private int thumbnailsDefaultHeight;
	private String playlistId;
	private String resourceIdKind;
	private String resourceIdVideoId;
	
	private Integer position;
	private static boolean isNew = true;
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnailsDefaultUrl() {
		return thumbnailsDefaultUrl;
	}

	public void setThumbnailsDefaultUrl(String thumbnailsDefaultUrl) {
		this.thumbnailsDefaultUrl = thumbnailsDefaultUrl;
	}

	public int getThumbnailsDefaultWidth() {
		return thumbnailsDefaultWidth;
	}

	public void setThumbnailsDefaultWidth(int thumbnailsDefaultWidth) {
		this.thumbnailsDefaultWidth = thumbnailsDefaultWidth;
	}

	public int getThumbnailsDefaultHeight() {
		return thumbnailsDefaultHeight;
	}

	public void setThumbnailsDefaultHeight(int thumbnailsDefaultHeight) {
		this.thumbnailsDefaultHeight = thumbnailsDefaultHeight;
	}

	public String getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(String playlistId) {
		this.playlistId = playlistId;
	}

	public String getResourceIdKind() {
		return resourceIdKind;
	}

	public void setResourceIdKind(String resourceIdKind) {
		this.resourceIdKind = resourceIdKind;
	}

	public String getResourceIdVideoId() {
		return resourceIdVideoId;
	}

	public void setResourceIdVideoId(String resourceIdVideoId) {
		this.resourceIdVideoId = resourceIdVideoId;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position2) {
		this.position = position2;
	}

	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}
	
	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isNew;
	}

}

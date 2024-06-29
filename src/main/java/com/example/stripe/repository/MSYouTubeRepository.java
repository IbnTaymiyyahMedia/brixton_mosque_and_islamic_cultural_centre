package com.example.stripe.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.stripe.model.MSYouTube;

@Repository
public interface MSYouTubeRepository extends CrudRepository<MSYouTube,String> {

	@Modifying
    @Query("UPDATE ms_you_tube SET title = :title, description = :description, etag = :etag, kind = :kind, playlist_id = :playlist_id, published_at = :published_at, resource_id_kind = :resource_id_kind, resource_id_video_id = :resource_id_video_id, thumbnails_default_url = :thumbnails_default_url WHERE id = :id")
    boolean updateById(@Param("id") String id, @Param("title") String title, @Param("description") String description, @Param("etag") String etag, @Param("kind") String kind, @Param("playlist_id") String playlistId, @Param("published_at") String publishedAt, @Param("resource_id_kind") String resourceIdKind, @Param("resource_id_video_id") String resourceIdVideoId, @Param("thumbnails_default_url") String thumbnailsDefaultUrl, @Param("thumbnails_default_height") Integer thumbnailsDefaultHeight, @Param("thumbnails_default_width") Integer thumbnailsDefaultWidth, @Param("position") Integer position);
}

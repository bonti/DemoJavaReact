package com.sb.musicmanager.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sb.musicmanager.entity.Playlist;

@Repository
public interface PlaylistRepository extends BaseRepository<Playlist, Long> {
	
	public List<Playlist> findByUserId(long userId);

}


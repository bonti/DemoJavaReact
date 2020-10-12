package com.sb.musicmanager.repository;

import org.springframework.stereotype.Repository;

import com.sb.musicmanager.entity.Song; 

@Repository
public interface SongRepository extends BaseRepository<Song, Long> {

}

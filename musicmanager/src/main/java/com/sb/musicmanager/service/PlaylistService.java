package com.sb.musicmanager.service;

 
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sb.musicmanager.request.bean.CreatePlayListRequest;
import com.sb.musicmanager.response.bean.ResponseWrapper;
 
@Service
public interface PlaylistService {
 	 
	public ResponseWrapper getPlaylistsByUser(Long userId);
 
	public ResponseWrapper createPlaylist( CreatePlayListRequest request);
 
}

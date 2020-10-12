package com.sb.musicmanager.service;
 

import org.springframework.stereotype.Service;

import com.sb.musicmanager.response.bean.ResponseWrapper;
  
@Service
public interface SongService {
	 
	public ResponseWrapper getSongs();

}

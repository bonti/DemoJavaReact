package com.sb.musicmanager.service.implementation; 
  
import com.sb.musicmanager.service.SongService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.musicmanager.repository.SongRepository;
import com.sb.musicmanager.response.bean.BaseResponseBean;
import com.sb.musicmanager.response.bean.ResponseWrapper;
import com.sb.musicmanager.response.bean.SongResponse;
import com.sb.musicmanager.security.JwtAuthenticationEntryPoint;
import com.sb.musicmanager.entity.Song;
 

@Service
public class SongServiceImpl extends BaseService implements SongService{

	@Autowired 
	SongRepository songRepository;
	 
	@Override
	public ResponseWrapper getSongs() {
		
		List<Song> songList = songRepository.findAll();
		List<BaseResponseBean> songResponseList = convertEntityToView(songList, SongResponse.class); //In case we wish to change anything from Entity to View
		return getResponseWrapper(songResponseList);
	}


 
 
}

 

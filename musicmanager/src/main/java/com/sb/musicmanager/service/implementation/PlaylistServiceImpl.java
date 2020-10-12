package com.sb.musicmanager.service.implementation; 
  
import com.sb.musicmanager.request.bean.CreatePlayListRequest;
import com.sb.musicmanager.service.PlaylistService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sb.musicmanager.entity.Playlist;
import com.sb.musicmanager.entity.Song;
import com.sb.musicmanager.entity.User; 
import com.sb.musicmanager.exception.EnterpriseException;
import com.sb.musicmanager.repository.PlaylistRepository;
import com.sb.musicmanager.repository.SongRepository;
import com.sb.musicmanager.repository.UserRepository;
import com.sb.musicmanager.response.bean.BaseResponseBean;
import com.sb.musicmanager.response.bean.ResponseWrapper;
import com.sb.musicmanager.security.JwtAuthenticationEntryPoint;

 
@Validated
@Service
public class PlaylistServiceImpl extends BaseService implements PlaylistService{

	@Autowired 
	PlaylistRepository playlistRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	SongRepository songRepository;
	

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);
 
	@Override
	public ResponseWrapper getPlaylistsByUser(Long userId) {
		List<Playlist> playlists= playlistRepository.findByUserId(userId);
		List<BaseResponseBean> playlistResponseList = convertEntityToView(playlists, com.sb.musicmanager.response.bean.Playlist.class); //In case we wish to change anything from Entity to View
		
		return getResponseWrapper(playlistResponseList);
		 
	}

	@Override
	@Transactional
	public ResponseWrapper createPlaylist(@Valid CreatePlayListRequest request) {
		
		Playlist newPlaylist = new Playlist();
		newPlaylist.setName(request.getName());
		newPlaylist.setDescription(request.getDescription());
		//Should not need to do this! The Constraint Validation is not getting triggered for some reason;
		validateCreatePlaylistRequest(request);
		
		 Optional<User> user = userRepository.findById(request.getUserId());
		 //Alternatively, the userId could be got from the authentication principal and we would not pass the user id as a request path variable.
		 if(user.isEmpty()) {  
			 logger.error("Invalid user id when trying to create a request"+request.getUserId());
			 throw new EnterpriseException("User does not exist as per request", HttpStatus.BAD_REQUEST);  
		 }
		 newPlaylist.setUser(user.get());
		 
		 List<Song>songList = songRepository.findByIdIn(request.getSongList()); 
		 
		Set<Song> songSet = songList.stream().collect(Collectors.toSet()); 
		newPlaylist.setSongSet(songSet);
		 try {
			 Playlist savedPlayList=playlistRepository.save(newPlaylist);
		 }
		 catch(Exception ex){
			 logger.error("An exception occurred creating a playlist "+ex.getMessage());
			throw new EnterpriseException("We were not able to save the new playlist at this time, please try again later", HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 
	    return getCreateSuccessResponseWrapper();
	}

	private void validateCreatePlaylistRequest(CreatePlayListRequest request) {
		 //If Name and description are common fields a common constraint could be added across the application with messages contained within the constraint.
	
		if(request.getName() ==null || request.getName().length() <3 || request.getName().length() >100) {

			 logger.error("An invalid playlist name got passed during playlist creation "+ request.getName());
			throw new EnterpriseException("Name must be between 3 and 100 characters in length.", HttpStatus.BAD_REQUEST);
		}
		if(request.getDescription().length() > 250) {
			 logger.error("An invalid playlist description got passed during playlist creation "+ request.getDescription());
				
			throw new EnterpriseException("Description cannot be more than 250 characters in length.", HttpStatus.BAD_REQUEST);
		}
	}
		
			
		
}

 
 

 

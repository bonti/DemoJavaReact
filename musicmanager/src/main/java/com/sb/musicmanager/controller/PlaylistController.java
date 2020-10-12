package com.sb.musicmanager.controller;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity; 
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.sb.musicmanager.util.PortalConstants;
import com.sb.musicmanager.request.bean.CreatePlayListRequest;
import com.sb.musicmanager.response.bean.ResponseWrapper;
import com.sb.musicmanager.service.PlaylistService;
 
 
@Validated
@RestController
@RequestMapping(value = "/playlists")
public class PlaylistController extends BaseController{ 
	
	@Autowired
	private PlaylistService playlistService;
	 
	@GetMapping(value="/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPlaylistsByUser(@PathVariable(value="userId") long userId,
			@RequestHeader(value = PortalConstants.HEADER_AUTHORIZATION) String authentication) {		
		return ResponseEntity.ok(playlistService.getPlaylistsByUser(userId));
	} 
	 	

	/***
	 * This method creates a  playlist for a user
	 * @param userId
	 * @param authentication
	 * @return
	 */
 	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseWrapper> createPlaylist( 
		@Valid @RequestBody CreatePlayListRequest createPlaylistRequest, 
		@RequestHeader(value = PortalConstants.HEADER_AUTHORIZATION) String authentication) {
		ResponseWrapper responseWrapper = playlistService.createPlaylist(createPlaylistRequest);		
		return getResponseEntity(responseWrapper);
    }

		 
	
}

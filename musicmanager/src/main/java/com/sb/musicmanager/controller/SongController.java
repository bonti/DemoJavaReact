package com.sb.musicmanager.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.sb.musicmanager.util.PortalConstants;
import com.sb.musicmanager.service.SongService; 
 
@RestController
@RequestMapping(value = "/songs")
public class SongController extends BaseController{ 
	
	@Autowired
	private SongService songService;
	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllSongs(@RequestHeader(value = PortalConstants.HEADER_AUTHORIZATION) String authentication) {		
		return ResponseEntity.ok(songService.getSongs());
	} 
}

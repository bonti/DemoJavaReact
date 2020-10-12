package com.sb.musicmanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.musicmanager.request.bean.CreatePlayListRequest;
import com.sb.musicmanager.request.bean.LoginRequest;
import com.sb.musicmanager.response.bean.ResponseWrapper;
import com.sb.musicmanager.exception.AuthenticationError;
import com.sb.musicmanager.service.PlaylistService;
import com.sb.musicmanager.service.UserService;
import com.sb.musicmanager.util.PortalConstants;
 
@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController{ 
	
	@Autowired
	private UserService userService;
	
 
	/***
	 * This method creates a authenticates a user
	 * @param username
	 * @param password
	 * @return
	 */
	 
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest)  throws AuthenticationError  {		
		return ResponseEntity.ok(userService.authenticateUser(loginRequest));
	}
	
}

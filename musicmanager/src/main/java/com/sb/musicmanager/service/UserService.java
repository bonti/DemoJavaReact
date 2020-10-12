package com.sb.musicmanager.service;
 

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sb.musicmanager.request.bean.LoginRequest;
import com.sb.musicmanager.response.bean.ResponseWrapper;
import com.sb.musicmanager.response.bean.UserInfo;

import io.jsonwebtoken.Claims;

public interface UserService {
	
	 
	public ResponseWrapper authenticateUser(LoginRequest request);

	 //Added for security config
    
	UserDetails loadUserByToken(Claims claims);
    
   
	UserInfo loadUserByUsername(String username) throws UsernameNotFoundException;
}

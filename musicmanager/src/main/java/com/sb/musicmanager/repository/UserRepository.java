package com.sb.musicmanager.repository;
 
 

import org.springframework.stereotype.Repository;
 
import com.sb.musicmanager.repository.BaseRepository;

import com.sb.musicmanager.entity.User;

@Repository
public interface UserRepository extends BaseRepository<User, Long>{ 
	
	public User findByEmailAndPassword(String email, String password);
}

  
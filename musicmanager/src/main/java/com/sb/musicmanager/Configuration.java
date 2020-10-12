package com.sb.musicmanager;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("examplemusicapi")
public class Configuration {

	private long authSecretExpirationTime;
	
	 
	private String key;
	 
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public long getAuthSecretExpirationTime() {
		return authSecretExpirationTime;
	}
	public void setAuthSecretExpirationTime(long authSecretExpirationTime) {
		this.authSecretExpirationTime = authSecretExpirationTime;
	}
	 
	
	  
}
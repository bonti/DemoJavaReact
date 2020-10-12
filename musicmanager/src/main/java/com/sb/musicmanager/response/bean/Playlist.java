package com.sb.musicmanager.response.bean;
 

import java.util.Set;

 
 

 
public class Playlist extends BaseResponseBean {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = -8729358464013491051L;

private String name; 
  
  private String description;
  
  private Set<SongResponse> songSet;
 
  
  protected Playlist() {}

  public Playlist(String name, String description, Set<SongResponse> songSet) {
    this.name = name;
    this.description = description;
    this.songSet = songSet;
  }

  
   
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}
public Set<SongResponse> getSongSet() {
    return songSet;
 }
 
 public void setSongSet(Set<SongResponse> songSet) {
    this.songSet = songSet;
 }

 
}
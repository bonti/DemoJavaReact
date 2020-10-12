package com.sb.musicmanager.entity;
 

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"user_id", "name"})
	)
@Entity
public class Playlist extends BaseEntitiy {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = -8729358464013491051L;

private String name; 
  
  private String description;
 
  @ManyToMany(targetEntity=Song.class)
  private Set<Song> songSet;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  
  public Playlist() {}

  public Playlist(String name, String description, Set<Song> songSet) {
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
public Set<Song> getSongSet() {
    return songSet;
 }
 
 public void setSongSet(Set<Song> songSet) {
    this.songSet = songSet;
 }

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

 
}
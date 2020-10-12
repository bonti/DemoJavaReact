package com.sb.musicmanager.entity; 
import javax.persistence.Entity;
 

@Entity
public class Song extends BaseEntitiy {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = 7989408837310817051L;
private String name;
  private String artist;
  private String album;
  private String genre;
  private int year; 

  protected Song()  {}

  public Song(String name, String artist,String album, String genre, int year) {
    this.setName(name);
    this.artist = artist;
    this.album= album;
    this.setGenre(genre);
    this.year= year;
  }
 

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getArtist() {
	return artist;
}

public void setArtist(String artist) {
	this.artist = artist;
}

public String getAlbum() {
	return album;
}

public void setAlbum(String album) {
	this.album = album;
}

 

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}
}
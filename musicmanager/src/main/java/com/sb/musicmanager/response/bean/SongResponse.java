package com.sb.musicmanager.response.bean;

public class SongResponse extends BaseResponseBean {
 
private static final long serialVersionUID = 3282627033537923544L;

  private String name;
  private String artist;
  private String album;
  private String genre;
  private int year; 
  private long id;

  protected SongResponse()  {}

  public SongResponse(String name, String artist,String album, String genre, int year) {
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

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
}
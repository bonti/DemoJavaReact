package com.sb.musicmanager.request.bean;

import java.util.List;
 
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.sb.musicmanager.util.ValidationConstants;  
import com.sb.musicmanager.response.bean.EPSerializer;

@Validated 
public class CreatePlayListRequest implements EPSerializer {
	
 
	private static final long serialVersionUID = 5545058097032630977L;
	
	@Size(min = 3, max = 100)
	@NotBlank
	@Pattern(regexp=ValidationConstants.Regex.ALPHANUMERIC_EN, message ="must be alphanumeric with spaces") 
	private String name;
	
	@Size(max = 250)
	private String description;
	
	
	@NotBlank
	@Min(value=1)
	private long userId;
   
    private List<@Min(1) Long> songList;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 

	public List<Long> getSongList() {
		return songList;
	}

	public void setSongList(List<Long> songList) {
		this.songList = songList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	


}

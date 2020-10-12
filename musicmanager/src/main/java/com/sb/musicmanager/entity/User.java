package com.sb.musicmanager.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
 
@Entity
public class User extends BaseEntitiy {
 
private static final long serialVersionUID = 3825780373114401970L;

  private String firstName;
  private String lastName;
  @Column(unique = true)
  private String email;
  private String password;
  
  //TODO: Add Permissions, Address settings here

  protected User()  {}

  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFullName() {
	  return this.firstName+" "+this.lastName;
  }
  
  public String toString() {
    return String.format(
        "User[id=%d, firstName='%s', lastName='%s']",
        getId(), firstName, lastName);
  }

   
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
}
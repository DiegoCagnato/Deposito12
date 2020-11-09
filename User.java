package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class User implements Serializable {

	
	private static final long serialVersionUID = -3363120264501521428L;
    
	@Id
	private String username;
	
	@Column(name = "nome")
	private String name;
	
	
	public User(){}
	
	public User(String username, String name){
		
		this.username = username;
		this.name = name;
	}
	
	public void setUsername(String username){
		
		this.username = username;
	}
	
	public String getUsername(){
		
		return username;
	}
	
    public void setName(String name){
		
		this.name = name;
	}
	
	public String getName(){
		
		return name;
	}
	
	public void printUser(){
		
		System.out.println("Username: " + username + " nome: " + name);
	}
	
	
}

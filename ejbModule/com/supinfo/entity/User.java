package com.supinfo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=true)
	private String lastname;
	
	@Column(nullable=true)
	private String firstname;
	
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String pwd;

	@Column(nullable=true)
	private String token;

	public int getId() {
		return id;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLogin() {
		return login;
	}

	public String getPwd() {
		return pwd;
	}

	public String getToken() {
		return token;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}

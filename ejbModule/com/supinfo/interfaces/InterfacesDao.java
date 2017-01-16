package com.supinfo.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.supinfo.entity.User;

@Remote
public interface InterfacesDao {

	public boolean login(String email, String password);
	public boolean signin(String email, String password);
	public List<User> getUsers();
	
}

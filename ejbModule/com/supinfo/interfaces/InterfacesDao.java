package com.supinfo.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.supinfo.entity.User;

@Remote
public interface InterfacesDao {

	public boolean login(String login, String mdp);
	public boolean signin(String login, String mdp);
	public List<User> getUsers();
	
}

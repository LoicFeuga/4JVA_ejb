package com.supinfo.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.supinfo.entity.Cours;
import com.supinfo.entity.User;

@Remote
public interface InterfacesDao {

	public boolean login(String login, String mdp);
	public List<User> getUsers();
	public List<Cours> getCours();
	public boolean signup(String login, String mdp, String nom, String prenom);
	public void initCours();
	
	
}

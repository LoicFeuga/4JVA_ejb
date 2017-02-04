package com.supinfo.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.supinfo.entity.Certification;
import com.supinfo.entity.Cours;
import com.supinfo.entity.Fichier;
import com.supinfo.entity.Question;
import com.supinfo.entity.Reponse;
import com.supinfo.entity.User;

@Remote
public interface ICoursesDao {
	public List<User> getAllUsers();
	public List<Cours> getAllCours();
	public List<Fichier> getAllFichier();
	public List<Question> getAllQuestion();
	public List<Reponse> getAllReponse();
	public List<Certification> getAllCertification();

	public User addUser(User user);
	public Cours addCours(Cours cours);
	public Fichier addFichier(Fichier fichier);
	public Question addQuestion(Question question);
	public Reponse addReponse(Reponse reponse);
	public Certification addCertification(Certification certification);
	
	public User findUserById(int Id);
	public User findUserByToken(String token);
	
	public Cours findCoursById(int Id);
	
	
	public void removeUser(User user);
	public void removeCours(Cours cours);
	public void removeFichier(Fichier fichier);
	public void removeQuestion(Question question);
	public void removeReponse(Reponse reponse);
	public void removeCertification(Certification certification);
	
	public boolean verifLoginUser(String login, String mdp);
	;
	
	
	
	
	
	
	
	
	
	

	
	
}

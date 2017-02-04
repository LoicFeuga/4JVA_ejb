package com.supinfo.interfaces;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebParam;

import com.supinfo.entity.Cours;
import com.supinfo.entity.Question;
import com.supinfo.entity.User;

@Remote
public interface ICoursesServices {
	public String authenticate(@WebParam(name = "login") String login, @WebParam(name = "mdp") String mdp );
	public User getUser(int idUser);
	public List<Cours> getCours();
	public Cours getCoursById(int idCours);
	public Cours takeCours(int idCours,int idUser);
	public List<Question> passQuizz(int idCours,int idUser);
}

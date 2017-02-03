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
	public User getUser(Long idUser);
	public List<Cours> getCours();
	public Cours getCoursById(Long idCours);
	public Cours takeCours(Long idCours,Long idUser);
	public List<Question> passQuizz(Long idCours,Long idUser);
}

package com.supinfo.webservices;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import com.supinfo.entity.Cours;
import com.supinfo.entity.Question;
import com.supinfo.entity.User;
import com.supinfo.interfaces.ICoursesDao;
import com.supinfo.interfaces.ICoursesServices;
import com.supinfo.interfaces.InterfacesDao;

@Stateless
@WebService(name="courses-api")
public class UserService implements ICoursesServices {
	
	@EJB
	InterfacesDao dao;
	
	@EJB
	ICoursesDao daoc;
	
	
	
//	@WebMethod
//	public String login(@WebParam(name = "log") String log, @WebParam(name = "mdp") String mdp){
//		//System.out.println("=>"+log+"\n::"+mdp);
//		return dao.login(log, mdp) +"" ;
//		
//	}

	@Override
	@WebMethod
	public String authenticate(@WebParam(name = "login") String login, @WebParam(name = "mdp") String mdp ){
		User u = dao.login(login, mdp);	
		if (u != null){
			return u.getToken();
		}
		return null;
	}

	@Override
	@WebMethod
	public User getUser(@WebParam(name = "idUser")int idUser){
		return daoc.findUserById(idUser);
	}
	
	@Override
	@WebMethod
	public List<Cours> getCours(){
		return dao.getCours();
	}

	@Override
	@WebMethod
	public Cours getCoursById(@WebParam(name = "idCours")int idCours){
		return daoc.findCoursById(idCours);
	}
	
	@Override
	@WebMethod
	public Cours takeCours(@WebParam(name = "idCours")int idCours,@WebParam(name = "idUser")int idUser){
		User u = daoc.findUserById(idUser);
		if (u!=null) {
			if (!u.getToken().equals(null)) {
				Cours c = daoc.findCoursById(idCours);
				return daoc.findCoursById(idCours);
			}
		}
		return null;
	}
	
	@Override
	@WebMethod
	public List<Question> passQuizz(@WebParam(name = "idCours")int idCours,@WebParam(name = "idUser")int idUser){
		User u = daoc.findUserById(idUser);
		if (u!=null) {
			if (!u.getToken().equals(null)) {
				Cours c = daoc.findCoursById(idCours);
				return (List<Question>) c.getQuestions();
			}
		}
		return null;
	}
	
	
			
	
}

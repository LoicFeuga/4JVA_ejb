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
import com.supinfo.interfaces.InterfacesDao;

@Stateless
@WebService(name="courses-api")
public class UserService {
	
	
	@EJB
	InterfacesDao dao;
	
//	@WebMethod
//	public String login(@WebParam(name = "log") String log, @WebParam(name = "mdp") String mdp){
//		//System.out.println("=>"+log+"\n::"+mdp);
//		return dao.login(log, mdp) +"" ;
//		
//	}
	
	@WebMethod
	public String authenticate(@WebParam(name = "login") String login, @WebParam(name = "mdp") String mdp ){
		User u = dao.login(login, mdp);	
		if (u != null){
			return u.getToken();
		}
		return "null";
	}
	
	@WebMethod
	public User getUser(Long idUser){
		
		User u = new User();
		u.setLogin("jdhf");
		u.setNom("liloudini");
		u.setPrenom("aziz");
		u.setMdp("zzzz");
		return u;
	}
	
	@WebMethod
	public List<Cours> getCours(){
		
		return dao.getCours();
	}
	
	@WebMethod
	public Cours getCoursById(Long idCours){
		
		return null;
	}
	
	@WebMethod
	public Cours takeCours(Long idCours,Long idUser){
		
		
		return null;
	}
	
	@WebMethod
	public List<Question> passQuuizz(Long idCours,Long idUser){
		
		
		return null;
	}
			
	
}

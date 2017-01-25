package com.supinfo.webservices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.FormParam;

import com.supinfo.interfaces.InterfacesDao;

@Stateless
@WebService
public class UserService {

	@EJB
	InterfacesDao dao;
	
	@WebMethod
	public String login(@WebParam(name = "log") String log, @WebParam(name = "mdp") String mdp){
		//System.out.println("=>"+log+"\n::"+mdp);
		return dao.login(log, mdp) +"" ;
		
	}
	
	
}

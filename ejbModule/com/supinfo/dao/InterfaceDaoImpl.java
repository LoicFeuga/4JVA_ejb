package com.supinfo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.supinfo.database.PersistenceManager;
import com.supinfo.entity.User;
import com.supinfo.interfaces.InterfacesDao;

@Stateless
public class InterfaceDaoImpl implements InterfacesDao{

	@Override
	public List<User> getUsers() {
		EntityManager em = PersistenceManager.getEntityManager();
		Query query = (Query) em.createQuery("Select u FROM User u ");
		List<User> persons = query.getResultList();
		return persons;
	}

	/**
	 * Permet de controler l'accès 
	 */
	@Override
	public boolean login(String login, String password) {
		EntityManager em = PersistenceManager.getEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> person = query.from(User.class);
		query.where(cb.equal(person.get("login"), login)).where(cb.equal(person.get("password"), password));
		
		List<User> persons = em.createQuery(query).getResultList();
	
		return !persons.isEmpty();
	}

	/**
	 * Permet d'enregistrer une nouvelle personne 
	 */
	@Override
	public boolean signin(String email, String password) {
		
		EntityManager em = PersistenceManager.getEntityManager();
		Query query = (Query) em.createQuery("INSERT INTO User (email, pwd) VALUES ('"+email+"','"+password+"') ");

		return true;
	}


}

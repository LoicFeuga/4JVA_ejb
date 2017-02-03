package com.supinfo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.eclipse.persistence.sessions.Session;

import com.supinfo.database.PersistenceManager;
import com.supinfo.entity.Certification;
import com.supinfo.entity.Cours;
import com.supinfo.entity.Fichier;
import com.supinfo.entity.User;
import com.supinfo.entity.User_;
import com.supinfo.interfaces.InterfacesDao;

@Stateless
public class InterfaceDaoImpl implements InterfacesDao {

	// @PersistenceContext(unitName="pu")
	// EntityManager em2;

	private static final String Pet_ = null;

	@Override
	public List<User> getUsers() {
		EntityManager em = PersistenceManager.getEntityManager();

		Query query = (Query) em.createQuery("Select u FROM User u ");
		List<User> persons = query.getResultList();

		return persons;
	}

	/**
	 * Permet de controler l'accès
	 * 
	 * return -2 = login ou mdp null ou ""
	 * return -1 = existe pas ce login ou mdp pas bon
	 * 
	 * return > 0 = id du mec
	 */
	@Override
	public User login(String login, String mdp) {
		if("".equals(login) || "".equals(mdp) || login == null || mdp == null){
			return null;
		}
		
//		EntityManager em = PersistenceManager.getEntityManager();
//
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<User> query = cb.createQuery(User.class);
//		Root<User> person = query.from(User.class);
//
//		query.where(
//				cb.equal(person.get("login"), login),
//				cb.equal(person.get("mdp"),mdp)
//				);
		
		
		EntityManager em = PersistenceManager.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> q = cb.createQuery(User.class);

		Metamodel m = em.getMetamodel();
		Root<User> rootUser = q.from(User.class);
		
		// use metadata class to define the where clause
		q.where(cb.equal(rootUser.get(User_.login), login),cb.equal(rootUser.get(User_.mdp), mdp));


//		EntityManager em2 = PersistenceManager.getEntityManager();
//		Metamodel m1 = em2.getMetamodel();
//		EntityType <Cours>  Cours_ =m1.entity(Cours.class);
//		Root<Cours> Cours = ((AbstractQuery<Cours>) m1).from(Cours_);
//		
//		
//		EntityManager em3 = PersistenceManager.getEntityManager();
//		Metamodel m4 = em3.getMetamodel();
//		EntityType <Certification>  Certification_ =m4.entity(Certification.class);
//		Root<Certification> Certification = ((AbstractQuery<Cours>) m4).from(Certification_);
//		
//		EntityManager em4 = PersistenceManager.getEntityManager();
//		Metamodel m3 = em4.getMetamodel();
//		EntityType <Fichier>  Fichier_ =m3.entity(Fichier.class);
//		Root<Fichier> Fichier = ((AbstractQuery<Fichier>) m3).from(Fichier_);
		

		
		
		List<User> list = (List<User>) em.createQuery(q).getResultList();
		User user = null;
		
		if(list.isEmpty() ){
			return null;
		}else{
			 user = list.get(0);
		}
		
		if(user != null){

			return user;
		}
		
		return null;
	}

	public List<Cours> getCours() {
		EntityManager em = PersistenceManager.getEntityManager();

		// Query query = (Query) em.createQuery("Select c FROM Cours c ");

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cours> cq = cb.createQuery(Cours.class);
		Root<Cours> cours = cq.from(Cours.class);
		cq.select(cours);

		TypedQuery<Cours> q = em.createQuery(cq);
		List<Cours> allCours = q.getResultList();
		
		for(int i = 0 ; i < allCours.size();i++){
			System.out.println(allCours.get(i).getLibelle());
		}
		return allCours;
	}
	
	
	
	

	@Override
	public boolean signup(String login, String mdp, String nom, String prenom) {
		if("".equals(login) || "".equals(mdp) || login == null || mdp == null){
			return false;
		}
		
		EntityManager em = PersistenceManager.getEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> person = query.from(User.class);
		query.where(cb.equal(person.get("login"), login));
		
		if(!em.createQuery(query).getResultList().isEmpty()){
			return false;
		}else{
			em.getTransaction().begin();
			
			em.persist(new User(login,mdp,nom,prenom));
	
			em.getTransaction().commit();
			
			return true;
		}
	}

	@Override
	public void initCours() {

		EntityManager em = PersistenceManager.getEntityManager();
		em.getTransaction().begin();

		
		ArrayList<Cours> list = new ArrayList<>();
		list.add(new Cours("4VTZ", "Virtu", ""));
		list.add(new Cours("4JVA", "Java EE", ""));
		list.add(new Cours("4MOS", "Microsoft Sharepoint", ""));
		list.add(new Cours("4VIP", "Voice Over IP", ""));
		list.add(new Cours("4MET", "Methodes Agiles Scrum", ""));
		for (int i = 0; i < list.size(); i++) {
			em.persist(list.get(i));
		}

		em.getTransaction().commit();
		
	}

}

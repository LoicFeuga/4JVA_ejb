package com.supinfo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.eclipse.persistence.sessions.Session;

import com.supinfo.database.PersistenceManager;
import com.supinfo.entity.Cours;
import com.supinfo.entity.User;
import com.supinfo.interfaces.InterfacesDao;

@Stateless
public class InterfaceDaoImpl implements InterfacesDao {

	// @PersistenceContext(unitName="pu")
	// EntityManager em2;

	@Override
	public List<User> getUsers() {
		EntityManager em = PersistenceManager.getEntityManager();

		Query query = (Query) em.createQuery("Select u FROM User u ");
		List<User> persons = query.getResultList();

		return persons;
	}

	/**
	 * Permet de controler l'acc�s
	 */
	@Override
	public boolean login(String login, String mdp) {
		EntityManager em = PersistenceManager.getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> person = query.from(User.class);

		query.where(cb.equal(person.get("login"), login));// .where(cb.equal(person.get("mdp"),
															// mdp));

		// Query query2 = (Query) em.createQuery("Select u FROM User u WHERE
		// u.login ='"+login+"' AND u.mdp = '"+mdp+"' ");

		List<User> persons = em.createQuery(query).getResultList();
		// for(User user : persons){
		// System.out.println(user.getNom());
		// }
		// System.out.println(persons.toString());
		// List<User> persons2 = query2.getResultList();
		// for(User user : persons2){
		// System.out.println(user.getPrenom());
		// }
		return !persons.isEmpty();
	}

	/**
	 * Permet d'enregistrer une nouvelle personne
	 */
	@Override
	public boolean signin(String email, String password) {

		EntityManager em = PersistenceManager.getEntityManager();
		Query query = (Query) em
				.createQuery("INSERT INTO User (email, pwd) VALUES ('" + email + "','" + password + "') ");

		return true;
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
		
		return allCours;
	}

	@Override
	public boolean signup(String login, String mdp, String nom, String prenom) {

		EntityManager em = PersistenceManager.getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> person = query.from(User.class);

		// TODO Auto-generated method stub
		return true;
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

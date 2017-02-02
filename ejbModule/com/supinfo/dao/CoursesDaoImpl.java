
package com.supinfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.jasper.tagplugins.jstl.If;
import org.eclipse.persistence.internal.jpa.querydef.CriteriaDeleteImpl;

import jersey.repackaged.com.google.common.base.Predicates;

import com.supinfo.database.PersistenceManager;

import com.supinfo.entity.Cours;
import com.supinfo.entity.Fichier;
import com.supinfo.entity.Question;
import com.supinfo.entity.Reponse;
import com.supinfo.entity.Certification;
import com.supinfo.entity.User;
import com.supinfo.interfaces.ICoursesDao;

@Stateless
public class CoursesDaoImpl implements ICoursesDao {

	//@Override
	//public List<User> getAllUsers() {
	//	EntityManager em = PersistenceManager.getEntityManager();
	//	Query q = em.createQuery("select c from User c");
	//	return q.getResultList();
	//}	
	
	
	private EntityManager em;
	
	@Override
	public User addUser(User user){
		em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();
		em.close();
		return user;
		
	}
	
	@Override
	public Cours addCours(Cours cours){
		em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(cours);
		et.commit();
		em.close();
		return cours;
		
	}
	@Override
	public Fichier addFichier(Fichier fichier){
		em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(fichier);
		et.commit();
		em.close();
		return fichier;
	}
	@Override
	public Question addQuestion(Question question){
		em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(question);
		et.commit();
		em.close();
		return question;
		
	}
	@Override
	public Reponse addReponse(Reponse reponse){
		em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(reponse);
		et.commit();
		em.close();
		return reponse;
		
	}
	@Override
	public Certification addCertification(Certification certification){
		em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(certification);
		et.commit();
		em.close();
		return certification;
		
	}

	
	@Override
	public List<User> getAllUsers(){
		em = PersistenceManager.getEntityManager();
		return em.createQuery("select c from User c").getResultList();
	}
	
	@Override
	public User findUserById(Long Id){
		em = PersistenceManager.getEntityManager();
		return em.find(User.class, Id);
	}
	
	
	@Override
	public User findUserByToken(String token){
		em = PersistenceManager.getEntityManager();
		return em.find(User.class, token);
	}
	
	@Override
	public Cours findCoursById(Long Id){
		em = PersistenceManager.getEntityManager();
		return em.find(Cours.class, Id);
	}
	
	
	
	@Override
	public void removeUser(User user){
		em = PersistenceManager.getEntityManager();
		em.remove(user);
	}
	
	

		
	@Override
	public void removeCours(Cours cours){
		em = PersistenceManager.getEntityManager();
		em.remove(cours);
	}
	
	@Override
	public void removeFichier(Fichier fichier){
		em = PersistenceManager.getEntityManager();
		em.remove(fichier);
	}
	
	@Override
	public void removeQuestion(Question question){
		em = PersistenceManager.getEntityManager();
		em.remove(question);
	}
	@Override
	public void removeReponse(Reponse reponse){
		em = PersistenceManager.getEntityManager();
		em.remove(reponse);
	}
	@Override
	public void removeCertification(Certification certification){
		em = PersistenceManager.getEntityManager();
		em.remove(certification);
	}
	
	
	@Override
	public boolean verifLoginUser(String login, String mdp){
		em = PersistenceManager.getEntityManager();
		Query qr = em.createQuery("select u from User u where u.login=:X and u.mdp=:Y");
		qr.setParameter("X", login);
		qr.setParameter("Y", mdp);
		User user = (User) qr.getSingleResult();
		if (user == null) {
			return false;
		}
		return true;	
	}
	

	@Override
	public List<Cours> getAllCours() {
		//init criteria builder
		CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
		CriteriaQuery<Cours> criteriaQuery =criteriaBuilder.createQuery(Cours.class);
		Root<Cours> cours =criteriaQuery.from(Cours.class);
		
		criteriaQuery.select(cours);
		TypedQuery<Cours> q = em.createQuery(criteriaQuery);
		List<Cours> allCours = q.getResultList();
		return allCours;
	}
	


	@Override
	public List<Fichier> getAllFichier() {
		CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
		CriteriaQuery<Fichier> criteriaQuery =criteriaBuilder.createQuery(Fichier.class);
		Root<Fichier> Fichier =criteriaQuery.from(Fichier.class);
		
		criteriaQuery.select(Fichier);
		TypedQuery<Fichier> q = em.createQuery(criteriaQuery);
		List<Fichier> allCours = q.getResultList();
		return allCours;
	}

	@Override
	public List<Question> getAllQuestion() {
		CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
		CriteriaQuery<Question> criteriaQuery =criteriaBuilder.createQuery(Question.class);
		Root<Question> question =criteriaQuery.from(Question.class);
		
		criteriaQuery.select(question);
		TypedQuery<Question> q = em.createQuery(criteriaQuery);
		List<Question> allQuestion = q.getResultList();
		return allQuestion;
	}

	@Override
	public List<Reponse> getAllReponse() {
		CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
		CriteriaQuery<Reponse> criteriaQuery =criteriaBuilder.createQuery(Reponse.class);
		Root<Reponse> reponse =criteriaQuery.from(Reponse.class);
		
		criteriaQuery.select(reponse);
		TypedQuery<Reponse> q = em.createQuery(criteriaQuery);
		List<Reponse> allReponse = q.getResultList();
		return allReponse;
	}

	@Override
	public List<Certification> getAllCertification() {
		CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
		CriteriaQuery<Certification> criteriaQuery =criteriaBuilder.createQuery(Certification.class);
		Root<Certification> reponse =criteriaQuery.from(Certification.class);
		
		criteriaQuery.select(reponse);
		TypedQuery<Certification> q = em.createQuery(criteriaQuery);
		List<Certification> allCertification = q.getResultList();
		return allCertification;
	}
	
	
 
 
}

package com.supinfo.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private static EntityManagerFactory emf;

	private PersistenceManager(){}

	public static EntityManagerFactory getEntityManagerFactory(){
		  if(emf == null){
			  	emf = Persistence.createEntityManagerFactory("pu");
		  }
		 return emf;
	 }
	  
	 public static EntityManager getEntityManager(){
		  return getEntityManagerFactory().createEntityManager();
	 }
	  
	  public static void closeEntityManagerFactory() {
			 if(emf != null && emf.isOpen()){
				 emf.close();
			 }
	  }	
}

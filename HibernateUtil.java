package daoservices;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateUtil implements Serializable {

	
	private static final long serialVersionUID = -3693294865253627707L;
	
	private EntityManagerFactory emf;
	
	
	public HibernateUtil(){
		
		emf = null;
		
	}
	
	public EntityManagerFactory getEMF(){
		
		emf = Persistence.createEntityManagerFactory("EShop2");
		return emf;
	}
	
	

}

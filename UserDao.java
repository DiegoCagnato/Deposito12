package daoservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entity.User;

public class UserDao implements DaoGenerics<User> {
	
	
	//private List<String> userIds; 
	//private HibernateUtil hU;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	
	public UserDao(EntityManagerFactory emf){
		
		//userIds = new ArrayList<>();
		this.emf = emf;
		em = null;
		et = null;
	}

	@Override
	public void insertObject(User user){
			
		    em = emf.createEntityManager();
	        et = em.getTransaction();
			et.begin();
			em.persist(user);
			//userIds.add(user.getUsername());
			et.commit();
			em.close();
		}
	    
	    
	@Override	
    public void findAndPrint(User user){
			
		    em = emf.createEntityManager();
	        et = em.getTransaction();
			et.begin();
			User u = em.find(User.class, user.getUsername());
			u.printUser();
			et.commit();
			em.close();
		}
	
	@Override
	public void findAndModify(User user){
			
			Scanner reader = new Scanner(System.in);
			System.out.println("Vuoi modificare il nome attuale del utente? (si/no)");
			String s = reader.nextLine();
			if(s.equals("si")){
				
				em = emf.createEntityManager();
			    et = em.getTransaction();
				et.begin();
				User u = em.find(User.class, user.getUsername());
				em.remove(u);
				System.out.println("inserisci il nome dell'utente: ");
				s = reader.nextLine();
				u.setName(s);
				em.persist(u);
				et.commit();
				em.close();
			}

		}
		
	public void printAll(){
		
		System.out.println("Stampa utenti");
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("from User");
		List<User> usersList = query.getResultList();
		for(User user : usersList){
			
			user.printUser();
		}
		et.commit();
		em.close();
		System.out.println("------------------------");
		}
}

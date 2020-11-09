package daoservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entity.Category;



public class CategoryDao implements DaoGenerics<Category> {
	
	//private HibernateUtil hU = new HibernateUtil();
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	private List<String> categoryIds; 
	
	
	public CategoryDao(EntityManagerFactory emf){
		
		categoryIds = new ArrayList<>();
		this.emf = emf;
		em = null;
		et = null;
	}
	
	@Override
    public void insertObject(Category category){
		
		
	    em = emf.createEntityManager();
	    et = em.getTransaction();
		et.begin();
		em.persist(category);
		categoryIds.add(category.getIdCategory());
		et.commit();
		em.close();
	}
    
    
	@Override
	public void findAndPrint(Category category){
		
		em = emf.createEntityManager();
	    et = em.getTransaction();
		et.begin();
		Category c = em.find(Category.class, category.getIdCategory());
		c.printCategory();
		et.commit();
		em.close();
	}
	
	@Override
	public void findAndModify(Category category){
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Vuoi modificare il nome attuale della categoria? (si/no)");
		String s = reader.nextLine();
		if(s.equals("si")){
			
			em = emf.createEntityManager();
		    et = em.getTransaction();
			et.begin();
			Category c = em.find(Category.class, category.getIdCategory());
			System.out.println("inserisci il nome della nuova categoria: ");
			s = reader.nextLine();
			c.setCategoryName(s);
			em.persist(c);
			et.commit();
			em.close();
		}

	}
	
	public void printAll(){
		
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select c.categoryName from Category c");
		List<Category> categoryList = query.getResultList();
		for(Category category : categoryList){
			
			category.printCategory();
		}
		et.commit();
		em.close();
		
	}

}

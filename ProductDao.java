package daoservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Category;
import entity.Product;
import entity.User;


public class ProductDao implements DaoGenerics<Product> {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	private List<String> productIds; 
	
	
	public ProductDao(EntityManagerFactory emf){
		
		productIds = new ArrayList<>();
		this.emf = emf;
		em = null;
		et = null;
	}
	
	 @Override
	 public void insertObject(Product product){
			
		    em = emf.createEntityManager();
		    et = em.getTransaction();
			et.begin();
			Category c = em.find(Category.class, product.getCategory().getIdCategory());
			c.setNProduct(c.getNProduct() + 1);
			em.persist(product);
			productIds.add(product.getIdProduct());
			et.commit();
			em.close();
		}
	    
	    
		public Product findById(String id){
			
			em = emf.createEntityManager();
		    et = em.getTransaction();
			et.begin();
			Product product = em.find(Product.class, id);
			et.commit();
			em.close();
			return product;
		}
		
		@Override
		public void findAndPrint(Product product){
			
			em = emf.createEntityManager();
		    et = em.getTransaction();
			et.begin();
			Product p = em.find(Product.class, product.getIdProduct());
			p.printProduct();
			et.commit();
			em.close();
		}
		
		@Override
		public void findAndModify(Product product){
			
			Scanner reader = new Scanner(System.in);
			System.out.println("Vuoi modificare il nome attuale del prodotto? (si/no)");
			String s = reader.nextLine();
			Integer i;
			if(s.equals("si")){
				
				em = emf.createEntityManager();
			    et = em.getTransaction();
				et.begin();
				Product p = em.find(Product.class, product.getIdProduct());
				System.out.println("inserisci il nome del nuovo prodotto: ");
				s = reader.nextLine();
				p.setProductName(s);
				System.out.println("inserisci il prezzo del nuovo prodotto");
				i = reader.nextInt();
				p.setPrice(i);
				em.persist(p);
				et.commit();
				em.close();
			}

		}
		
		public void printAll(){
			
			System.out.println("Stampa oggetti e relative categorie");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("FROM  Product");
			List<Product> productList = query.getResultList();
			for(Product product : productList){
				
				product.printProduct();
			}
			et.commit();
			em.close();
			System.out.println("----------------------------");
		}
}

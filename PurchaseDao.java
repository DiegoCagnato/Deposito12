package daoservices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Category;
import entity.Product;
import entity.Purchase;
import entity.User;

public class PurchaseDao {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	//private HibernateUtil hU = new HibernateUtil();
	
    public PurchaseDao(EntityManagerFactory emf){
    	
    	this.emf = emf;
    	em = null;
    	et = null;
    }
    
	public void removeProductDB(Product product){
		
		em = emf.createEntityManager();
	    et = em.getTransaction();
		et.begin();
		Product p = em.find(Product.class,  product.getIdProduct());
		Category category = em.find(Category.class, p.getCategory().getIdCategory());
		category.setNProduct(category.getNProduct() - 1);
		if(category.getNProduct() == 0){
			
			em.remove(p);
			em.remove(category);
		}
		else{em.remove(p);}
		et.commit();
		em.close();
	}
	
	
	public void addPurchase(Integer idCart, Product product, User user){
		
		em = emf.createEntityManager();
	    et = em.getTransaction();
		et.begin();
		Purchase purchase = new Purchase(idCart, user, product);
		em.persist(purchase);
		et.commit();
		em.close();
		
	}
	
	
	
}

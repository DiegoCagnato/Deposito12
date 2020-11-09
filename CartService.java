package services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManagerFactory;

import daoservices.ProductDao;
import daoservices.PurchaseDao;
import entity.Product;
import entity.User;

public class CartService {
	
	private Integer idCart;
	private User user;
	private Set<Product> cart;
	private Map<String, Product> mapCart;
	private PurchaseDao purchaseDao;
	private ProductDao productDao;
		
	
	public CartService(User user, Integer idCart, EntityManagerFactory emf){
		
		this.idCart = idCart;
		this.user = user;
		cart = new HashSet<Product>();
		mapCart = new HashMap<>();
		purchaseDao = new PurchaseDao(emf);
		productDao = new ProductDao(emf);
	}
	
	public void printUserCart(){
		
		user.printUser();
	}
	
	public void insertProductCart(String id){
		
		Product product = productDao.findById(id);
		cart.add(product);
		mapCart.put(id, product);
		
	}
	
	public void removeProductCart(String id){
		
		cart.remove(mapCart.get(id));
		mapCart.remove(id);
	}
	
	public void purchaseCart(){
		
		for(Product product : cart){
			purchaseDao.addPurchase(idCart, product, user);
			purchaseDao.removeProductDB(product);
		}
	}
	
	public void printProductCart(){
		System.out.println("Stampa prodotti nel carrello");
		for(Product product : cart){
			
			product.printProduct();
		}
	}
	

}

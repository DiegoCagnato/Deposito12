package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;


@Entity
@Table(name = "acquisto")
public class Purchase implements Serializable{

	
	private static final long serialVersionUID = 3852808060632884055L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idPurchase;
	
	
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id_prodotto")
	private Product product;
	
	@Column(name = "id_carrello")
	private Integer idCart;
	
	@Column(name = "data_acquisto")
	private LocalDateTime date;
	
	
	@PrePersist
	public void prePersist(){
		
		date = LocalDateTime.now();
	}
	
	public Purchase(){}

	public Purchase(Integer idCart, User user, Product product){
		
		this.idCart = idCart;
		this.user = user;
		this.product = product;
	}
	
	
	
	
	public void setIdPurchase(Integer idPurchase){
		
		this.idPurchase = idPurchase;
	}
	
	public Integer getIdPurchase(){
		
		return idPurchase;
	}
	
   public void setIdCarrello(Integer idCart){
		
		this.idCart = idCart;
	}
	
	public Integer getIdCarrello(){
		
		return idCart;
	}
	
	
    public void setUser(User user){
		
		this.user = user;
	}
	
	public User getUser(){
		
		return user;
	}
	
    public void setProduct(Product product){
		
		this.product = product;
	}
	
	public Product getProduct(){
		
		return product;
	}
	
	
	
	
	
}

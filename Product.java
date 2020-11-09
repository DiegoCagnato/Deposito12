package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "prodotto")
public class Product implements Serializable{

	
	private static final long serialVersionUID = -750960800826620215L;

	@Id
	@Column(name = "id")
	private String idProduct;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Category category;
	
	@Column(name = "descrizione")
	private String description;
	
	@Column(name = "prezzo")
	private Integer price;
	
	@Column(name = "nome")
	private String productName;
	
	public Product(){}
	
	public Product(String idProduct, Category category, String description, Integer price, String productName){
		
		this.idProduct = idProduct;
		this.category = category;
		this.description = description;
		this.price = price;
		this.productName = productName;
	}
	
   public void setIdProduct(String idProduct){
		
		this.idProduct = idProduct;
	}
	
	public String getIdProduct(){
		
		return idProduct;
	}
	
    public void setCategory(Category category){
   		
		this.category = category;
	}
	
	public Category getCategory(){
		
		return category;
	}
	
   public void setDescription(String description){
		
		this.description = description;
	}
	
	public String getDescription(){
		
		return description;
	}
	
   public void setPrice(Integer price){
		
		this.price = price;
	}
	
	public Integer getPrice(){
		
		return price;
	}
	
    public void setProductName(String productName){
		
		this.productName = productName;
	}
	
	public String getProductName(){
		
		return productName;
	}
	
	public void printProduct(){
		
		System.out.println("Nome prodotto: " + this.getProductName() + ", categoria: " + category.getCategoryName());
	}
	
	
	
	
}

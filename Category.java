package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Categoria")
public class Category implements Serializable {

	
	private static final long serialVersionUID = -1071596622026998554L;

	@Id
	@Column(name = "id")
	private String idCategory;
	
	@Column(name = "categoria")
	private String categoryName;
	
	@Column(name = "n_prodotti")
	private Integer nProduct;
	
	public Category(){}
	
	public Category(String idCategory, String categoryName){
		
		this.idCategory = idCategory;
		this.categoryName = categoryName;
		this.nProduct = 0;
	}
	
	public void setIdCategory(String idCategory){
		
		this.idCategory = idCategory;
	}
	
	public String getIdCategory(){
		
		return idCategory;
	}
	
    public void setCategoryName(String categoryName){
		
		this.categoryName = categoryName;
	}
	
	public String getCategoryName(){
		
		return categoryName;
	}
	
    public void setNProduct(Integer nProduct){
		
		this.nProduct = nProduct;
	}
	
	public Integer getNProduct(){
		
		return nProduct;
	}
	
	public void printCategory(){
		
		System.out.println("Categoria: " + categoryName + " n° prodotti disponibili: " + nProduct);
	}
	
}

package shop.categorysecond;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.NEW;

import shop.category.Category;
import shop.product.Product;

public class CategorySecond {
	private int csid;
	private String csname;
	//需要配置一个二级对象所属的一级分类，即二级分类表的外键
	//放入一个一级分类对象，并生成get set
	private Category category;
	
	//关联的商品的集合
	private Set<Product> products=new HashSet<Product>();
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	
	
}

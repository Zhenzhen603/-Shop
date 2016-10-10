package shop.category;

import java.util.HashSet;
import java.util.Set;

import shop.categorysecond.CategorySecond;

public class Category {
	private int cid;
	private String cname;
	//添加一个二级分类的集合，因为一个一级分类对应多个二级分类项目
	//并生成get set
	private Set<CategorySecond> categorySeconds=new HashSet<CategorySecond>();
	
	
	
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}

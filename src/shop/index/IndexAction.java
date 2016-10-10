package shop.index;

import java.util.List;

import shop.category.Category;
import shop.category.CategoryService;
import shop.product.Product;
import shop.product.ProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	
	//注入查询一级分类的Service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//注入查询商品的Service
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//热门商品
	private List<Product> hotList;
	public List<Product> getHotList() {
		return hotList;
	}
	//最新商品
	private List<Product> newList;
	public List<Product> getNewList() {
		return newList;
	}


	public String execute() throws Exception {
		 //查询所有的一级分类
		List<Category> categoryList=categoryService.findAll();
		//查询到之后，放到session中
		ActionContext.getContext().getSession().put("categoryList", categoryList);
		//查询热门商品模块
		hotList=productService.findHot();
		newList=productService.findNew();
		
		
		
		return "indexSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

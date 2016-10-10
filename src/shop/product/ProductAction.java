package shop.product;
import shop.product.Product;
import java.util.List;
import shop.Utils.PageBean;
import shop.category.Category;
import shop.category.CategoryService;
import shop.user.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
		private Product product=new Product();
		public Product getModel() {
			return product;
								}
		private int cid;
		//注入一级分类的Service，用于查询所有的一级分类
		private CategoryService categoryService;
		public void setCategoryService(CategoryService categoryService) {
			this.categoryService = categoryService;
		}
		//注入ProductService，用于查询商品
		private ProductService productService;
		
		public void setProductService(ProductService productService) {
			this.productService = productService;
		}
		//接收当前要查询的页数
		private Integer page;
		//分页显示的查询结果
		private PageBean<Product> pageBean;
		public PageBean<Product> getPageBean() {
			return pageBean;
		}
		private int csid;
		
		
		public void setCsid(int csid) {
			this.csid = csid;
		}

		public void setPage(Integer page) {
			this.page = page;
		}

		public void setCid(int cid) {
			this.cid = cid;
		}
		
		public String findByCid() {
			//查询所有一级分类
			List<Category> categoryList=categoryService.findAll();
			//使用压栈的方式，先获取值栈
			ActionContext.getContext().getValueStack().set("categoryList", categoryList);
			
			//查询前台页面显示对应分类下的商品
			pageBean=productService.findByPage(cid,page);
			
			return "findByCidSuccess";
		}

		//构建查询商品的方法
		public String findByPid() {
			List<Category> categoryList=categoryService.findAll();
			//使用压栈的方式，先获取值栈
			ActionContext.getContext().getValueStack().set("categoryList", categoryList);
		
			product=productService.findByPid(product.getPid());
			return "findByPidSuccess";
		}
		 
		
		public String findByCsid() {
			List<Category> categoryList=categoryService.findAll();
			//使用压栈的方式，先获取值栈
			ActionContext.getContext().getValueStack().set("categoryList", categoryList);
			
			pageBean=productService.findByCsid(csid,page);
			return "findByCsidSuccess";
			
		}
		
		
		
		
		
		
		
		
		
		

}












		
	
	
















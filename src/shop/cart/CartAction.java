package shop.cart;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import shop.product.Product;
import shop.product.ProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport{
	//接收参数
	int count;
	int pid;
	private ProductService productService;
	
	public void setCount(int count) {
		this.count = count;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//获取购物车的方法
	public Cart getCart(HttpServletRequest request) {
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		if(cart==null)
		{
			cart=new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	
	
	
	//添加到购物车的方法
	public String addCart() {
		CartItem cartItem=new CartItem();
		Product product=productService.findByPid(pid);
		cartItem.setCount(count);
		cartItem.setProduct(product);
		//获取购物车
		HttpServletRequest httpServletRequest=ServletActionContext.getRequest();
		Cart cart=getCart(httpServletRequest);
		cart.addCart(cartItem);
		return "addCartSuccess";
	}
}

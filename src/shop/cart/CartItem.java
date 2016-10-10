package shop.cart;

import shop.product.Product;
//购物项的实体类
public class CartItem {
	//商品实体类
	private Product product;
	//数量
	private int count; 
	//小计
	private Double	subtotal;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return count*product.getShop_price();
	}
	
	
}

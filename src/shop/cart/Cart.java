package shop.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	//购物项集合用Map集合 存储购物项
	private Map<Integer,CartItem> map=new HashMap<Integer, CartItem>();
	//单列的，方便在JSP中遍历
	public Collection getCartItems() {
		return map.values();
	}
	
	//总价
	private Double total=0d;
	public Double getTotal() {
		return total;
	}
	//添加到购物车
	public void addCart(CartItem cartItem) {
		int pid=cartItem.getProduct().getPid();
		if(map.containsKey(pid))
		{
		CartItem _cartItem=map.get(pid);
		_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}
		else {
			map.put(pid, cartItem);
		}
		total=total+cartItem.getSubtotal();
	}
	//清空购物车
	public void clearCart() {
		map.clear();
		total=0d;
	}
	//移除购物项
	public void removeCart(int pid) {
		CartItem cartItem=map.remove(pid);
		total=total-cartItem.getSubtotal();		
	}
	
	
}

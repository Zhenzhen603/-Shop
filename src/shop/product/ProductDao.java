package shop.product;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.Utils.PageHibernateCallback;

public class ProductDao extends HibernateDaoSupport{

	public List<Product> findHot() {
		//查询商品 且只显示10个
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("is_hot", 1));
		List<Product> hotList=this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return hotList;
	}
/*
	public List<Product> findNew() {
		//调试失败的话  就用另一种查询方式  
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("order by pdate desc", null));
		List<Product> newList=this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return newList;
	}
*/	
	public List<Product> findNew() {
		List<Product> list = this.getHibernateTemplate().executeFind(new PageHibernateCallback<Product>("from Product order by pdate desc", null , 0, 11));
		return list;
	}
	//统计某个分类下的商品总数
	public int findCount(int cid) {
		
		List<Long> list=this.getHibernateTemplate().find("select count(*) from Product p,CategorySecond cs where p.categorySecond = cs and cs.category.cid=?",cid);
		System.out.println(list.get(0).intValue());
		return list.get(0).intValue();
		
	}
	public List<Product> findByPage(int cid, int begin, int limit) {
		String hql="select p from Product p,CategorySecond cs where p.categorySecond=cs and cs.category.cid=?";
		List<Product> list=this.getHibernateTemplate().executeFind(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		return list;
	}
	
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	//查询二级分类下商品的总数量
	public int findCountByCsid(int csid) {
		List<Long> list=this.getHibernateTemplate().find("select count(*) from Product p join p.categorySecond cs where cs.csid=?",csid);
		return list.get(0).intValue();
	}
	public List<Product> findByCsid(int csid, int begin,int limit) {
		String hql="select p from Product p join p.categorySecond cs where cs.csid=? ";
		List<Product> list=this.getHibernateTemplate().executeFind(new PageHibernateCallback<Product>(hql,new Object[]{csid},begin,limit));
		return list;
	}
	
}































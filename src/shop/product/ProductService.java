package shop.product;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import shop.Utils.PageBean;
@Transactional

public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> findHot() {
		
		return productDao.findHot();
	}

	public List<Product> findNew() {
		
		return productDao.findNew();
	}
	//	分类页面显示商品
	public PageBean<Product> findByPage(int cid, Integer page) {
		int limit=12;
		int totalPage=0;
		PageBean<Product> pageBean=new PageBean<Product>();
		pageBean.setPage(page);
		pageBean.setLimit(limit);
		//查询总记录数
		int totalCount=productDao.findCount(cid);
		pageBean.setTotalCount(totalCount);
		//总页数 封装
		if(totalCount%limit==0)
		{
			totalPage=totalCount/limit;
		}
		else {
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//查到的商品的 集合
		int begin=(page-1)*limit;
		List<Product> list=productDao.findByPage(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public Product findByPid(Integer pid) {
		
		return productDao.findByPid(pid);
	}
	//点击二级分类名，显示二级分类下的商品
	public PageBean<Product> findByCsid(int csid, Integer page) {
		int limit=12;
		int begin=1;
		int totalPage;
		begin=(page-1)*12;
		int totalCount=productDao.findCountByCsid(csid);
		if(totalCount%limit==0)
		{
			totalPage=totalCount/limit;
		}
		else {
			totalPage=totalCount/limit+1;
		}
	
		List<Product> list=productDao.findByCsid(csid,begin,limit);
		PageBean<Product> pageBean=new PageBean<Product>();
		pageBean.setLimit(limit);
		pageBean.setList(list);
		pageBean.setPage(1);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		return pageBean;
		
	}
	

	
	
	
	
	
	
	
	
	
}

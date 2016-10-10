package shop.category;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public class CategoryService {
	
	//在spring中注入Dao
	private CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	
	
	
	
	
	
	
	
	
}

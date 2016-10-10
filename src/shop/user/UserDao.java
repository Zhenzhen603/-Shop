package shop.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.category.Category;



public class UserDao extends HibernateDaoSupport {


	public void save(User user) {
		this.getHibernateTemplate().save(user);
		
	}

	public User findByCode(String code) {
		List<User> list=this.getHibernateTemplate().find("from User where code=?",code);
		return list.get(0);
	}
	//激活之后重新放入数据库
	public  void update(User exitUser) {
		this.getHibernateTemplate().update(exitUser);
		
	}

//通过数据库查询是否有该用户，并返回这个用户
	public User login(User user) {
		List<User> list=this.getHibernateTemplate().find("from User where username=? and password=? and state=?",user.getUsername(),user.getPassword(), 1);
		if(list.size()!=0)
			{
			User existUser=list.get(0);
			return existUser;
			}
		else 
			return null;
	}


	
	
	
	
	
	
	
	
}

package shop.user;

import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;

import shop.Utils.MailUtils;
import shop.Utils.UUIDUtils;
import shop.product.Product;
import shop.product.ProductDao;

@Transactional
public class UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void regist(User user) throws Exception{
		//保存用户
		user.setState(0);// 0未激活  1已激活
		String code=UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		//发送邮件
		MailUtils mailUtils=new MailUtils();
		mailUtils.sendMail(user.getEmail(), code);
		
		
	}

	public  User findByCode(String code) {
		return userDao.findByCode(code);
	
	}

	public  void update(User exitUser) {
		userDao.update(exitUser);
	}
//登陆时 查询用户是否存在
	public User login(User user) {
		User existUser=userDao.login(user);
		return existUser;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

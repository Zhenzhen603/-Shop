package shop.user;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	//Struts2中模型驱动使用的类
	
	//返回一个user对象，可以存储网页传过来的数据，并赋值给user*
	private User user=new User();
	public User getModel(){
		return user;
	}
	//跳转页面的方法
	
	public String registPage() {
		return "registPage";
		
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	//注册的实现方法
	@InputConfig(resultName="registInput")
	public String regist() throws Exception{
		userService.regist(user);
		this.addActionMessage("注册成功，快去邮箱激活");
		return "registSuccess";
	}
	
	//激活用户
	public String active(){
		User exitUser=userService.findByCode(user.getCode());
		if(exitUser!=null)
		{
			exitUser.setState(1);
			userService.update(exitUser);
			this.addActionMessage("激活成功，马上返回首页");
			return "activeSuccess";
		}
		else{
			this.addActionMessage("没有查询到用户,现在去注册页面");
			return "activeFail";
		}	
	}
	
	//跳转到登陆页面
	public String loginPage(){
		return "loginPage";
	}

	//登陆
	@InputConfig(resultName="loginInput")
	public String login(){
	User existUser=userService.login(user);
	if(existUser==null)//==是比较内存地址的。。。而不是=
		{
			//登陆失败
			this.addActionError("用户名或密码错误或者没有激活");
			return "loginInput";
		}
	else 
		{
		//登陆成功，将用户存入到session
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess";
		}
	
	}
	
	//编写退出的方法
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quitSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	


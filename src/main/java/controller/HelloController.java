package controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 处理器
 */
@Controller
public class HelloController {
	HttpServletRequest request;
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("HelloController的方法");
		return "hello";
	}
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("helloController-tologin");
		return "tologin";
	}
	
	@RequestMapping("/login.do")
	/**
	 * 读取请求参数的第一种方式：
	 * 使用请求request对象。
	 * 注：前端控制器会将request对象作为参数传进来
	 */
	//http://localhost:8081/springcase-springmvc2/login.do?adminCode=aaa&pwd=aaaaa
	public void checkLogin(HttpServletRequest request) throws UnsupportedEncodingException{
		//乱码问题待解决
		System.out.println("helloController-checkLogin");
		String adminCode=request.getParameter("adminCode");
		String pwd=request.getParameter("pwd");
		System.out.println("adminCode:"+adminCode+"  pwd:"+pwd);
	}
	
	@RequestMapping("/login2.do")
	//http://localhost:8081/springcase-springmvc2/login2.do?adminCode=aaa&pwd=aaaaa
	public void checklogin2(String adminCode,String pwd){
		//乱码问题待解决
		System.out.println("checkLogin2()..");
		System.out.println("adminCode:"+adminCode+"  pwd:"+pwd);
	}
	
	@RequestMapping("/login3.do")
	////http://localhost:8081/springcase-springmvc2/login3.do
	//没成功哦
	public String checkLogin3(){
		return "login31.do";
	}
	@RequestMapping("/login31.do")
	public String checkLogin31(Admin admin){
		System.out.println("checkLogin3()");
		System.out.println("admincode："+admin.getAdminCode()+" pwd:"+admin.getPwd());
		return "index";
	}
	
	@RequestMapping("/login4.do")
	/*
	 * 向页面传值得第一种方式
	 * 使用resquest对象
	 */
	public String checkLogin4(Admin admin,HttpServletRequest request){
		System.out.println("checkLogin4()...");
		System.out.println("adminCode:"+admin.getAdminCode());
		//向页面传值
		request.setAttribute("adminCode",admin.getAdminCode());
		//默认是使用转发的方式
		return "index";
	}
	
	
	@RequestMapping("/login5.do")
	/*
	 * 向页面传值的第二种方式
	 * 使用ModelMap作为方法的参数
	 */
	public String checkLogin5(Admin admin,ModelMap data){
			System.out.println("checkLogin5()...");
			System.out.println("adminCode:"+admin.getAdminCode());
			/*
			 *等同于request.setAttribute 
			  */
			data.addAttribute("admincode",  admin.getAdminCode());
		return "index";
	}
	
	@RequestMapping("/login6.do")
	/*
	 * 向页面传值的第三种方式：
	 * 使用session对象绑定数据
	 */
	public String checkLogin6(Admin admin,HttpSession session){
			System.out.println("checkLogin6()...");
			System.out.println("adminCode:"+admin.getAdminCode());
			session.setAttribute("adminCode", admin.getAdminCode());
		return "index";
	}
	
	@RequestMapping("/login7.do")
	public ModelAndView checkLogin7(Admin admin){
		System.out.println("checkLogin7()..");
		System.out.println("adminCode:"+admin.getAdminCode());
		Map<String,Object> data=new HashMap<String,Object>();
		//相当于request,setAttribute
		data.put("adminCode", "123");
		ModelAndView mav=new ModelAndView("index",data);
		return mav;
	}
	
	@RequestMapping("/login8.do")
	/*
	 * 重定向第一种方式：
	 * 如果处理方法的返回值是String,需要在重定向地址前添加"redirect"
	 */
	public String checkLogin8(){
		System.out.println("checkLogin8()");
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/login9.do")
	/*
	 * 重定向的第二种方式：
	 */
	public ModelAndView checkLogin9(){
		System.out.println("checkLogin9()...");
		RedirectView rv=new RedirectView("toIndex.do");
		return new ModelAndView(rv);
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()...");
		return "index";
	}
	
}






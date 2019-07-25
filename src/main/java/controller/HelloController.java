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
 * ������
 */
@Controller
public class HelloController {
	HttpServletRequest request;
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("HelloController�ķ���");
		return "hello";
	}
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("helloController-tologin");
		return "tologin";
	}
	
	@RequestMapping("/login.do")
	/**
	 * ��ȡ��������ĵ�һ�ַ�ʽ��
	 * ʹ������request����
	 * ע��ǰ�˿������Ὣrequest������Ϊ����������
	 */
	//http://localhost:8081/springcase-springmvc2/login.do?adminCode=aaa&pwd=aaaaa
	public void checkLogin(HttpServletRequest request) throws UnsupportedEncodingException{
		//������������
		System.out.println("helloController-checkLogin");
		String adminCode=request.getParameter("adminCode");
		String pwd=request.getParameter("pwd");
		System.out.println("adminCode:"+adminCode+"  pwd:"+pwd);
	}
	
	@RequestMapping("/login2.do")
	//http://localhost:8081/springcase-springmvc2/login2.do?adminCode=aaa&pwd=aaaaa
	public void checklogin2(String adminCode,String pwd){
		//������������
		System.out.println("checkLogin2()..");
		System.out.println("adminCode:"+adminCode+"  pwd:"+pwd);
	}
	
	@RequestMapping("/login3.do")
	////http://localhost:8081/springcase-springmvc2/login3.do
	//û�ɹ�Ŷ
	public String checkLogin3(){
		return "login31.do";
	}
	@RequestMapping("/login31.do")
	public String checkLogin31(Admin admin){
		System.out.println("checkLogin3()");
		System.out.println("admincode��"+admin.getAdminCode()+" pwd:"+admin.getPwd());
		return "index";
	}
	
	@RequestMapping("/login4.do")
	/*
	 * ��ҳ�洫ֵ�õ�һ�ַ�ʽ
	 * ʹ��resquest����
	 */
	public String checkLogin4(Admin admin,HttpServletRequest request){
		System.out.println("checkLogin4()...");
		System.out.println("adminCode:"+admin.getAdminCode());
		//��ҳ�洫ֵ
		request.setAttribute("adminCode",admin.getAdminCode());
		//Ĭ����ʹ��ת���ķ�ʽ
		return "index";
	}
	
	
	@RequestMapping("/login5.do")
	/*
	 * ��ҳ�洫ֵ�ĵڶ��ַ�ʽ
	 * ʹ��ModelMap��Ϊ�����Ĳ���
	 */
	public String checkLogin5(Admin admin,ModelMap data){
			System.out.println("checkLogin5()...");
			System.out.println("adminCode:"+admin.getAdminCode());
			/*
			 *��ͬ��request.setAttribute 
			  */
			data.addAttribute("admincode",  admin.getAdminCode());
		return "index";
	}
	
	@RequestMapping("/login6.do")
	/*
	 * ��ҳ�洫ֵ�ĵ����ַ�ʽ��
	 * ʹ��session���������
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
		//�൱��request,setAttribute
		data.put("adminCode", "123");
		ModelAndView mav=new ModelAndView("index",data);
		return mav;
	}
	
	@RequestMapping("/login8.do")
	/*
	 * �ض����һ�ַ�ʽ��
	 * ����������ķ���ֵ��String,��Ҫ���ض����ַǰ���"redirect"
	 */
	public String checkLogin8(){
		System.out.println("checkLogin8()");
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/login9.do")
	/*
	 * �ض���ĵڶ��ַ�ʽ��
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






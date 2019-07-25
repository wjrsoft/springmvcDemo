package controller;
/**
 * 1属性名要与参数名一致
 * 2这些属性要有对应的get/set方法。
 * @author Administrator
 *
 */
public class Admin {
	private String adminCode="12";
	private String pwd;
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Amin [adminCode=" + adminCode + ", pwd=" + pwd + "]";
	}
	 
}

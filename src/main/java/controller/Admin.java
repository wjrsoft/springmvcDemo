package controller;
/**
 * 1������Ҫ�������һ��
 * 2��Щ����Ҫ�ж�Ӧ��get/set������
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

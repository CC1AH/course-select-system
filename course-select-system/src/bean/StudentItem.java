package bean;

public class StudentItem {
	public String sID;
	public String stuID;
	public String name;
	public String dept_name;
	public int tot_cred;
	public String password;
	
	public String getsID() {
		return sID;
	}
	public void setsID(String sID) {
		this.sID = sID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public int getTot_cred() {
		return tot_cred;
	}
	public void setTot_cred(int tot_cred) {
		this.tot_cred = tot_cred;
	}
	public int getCred() {
		return tot_cred;
	}
	public void setCred(int tot_cred) {
		this.tot_cred = tot_cred;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

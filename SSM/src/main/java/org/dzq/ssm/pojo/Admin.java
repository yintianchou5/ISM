package org.dzq.ssm.pojo;

public class Admin {
	private String name;
	private String pwd;
	private int id;
	private int state;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Admin [name=" + name + ", pwd=" + pwd + ", id=" + id + ", state=" + state + "]";
	}
	
}

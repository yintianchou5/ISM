package org.dzq.ssm.service;

import java.util.List;

import org.dzq.ssm.pojo.Admin;

public interface AdminService {
	List<Admin> getAdminList();
	List<Admin> getAdminListByName(String name);
	boolean checkLogin(String name,String pwd);
	Admin getAdmin(int id);
	Admin getAdminByAdmin(Admin admin);
	int insertAdmin(Admin admin);
	int deleteAdmin(int id);
	int updateAdmin(Admin admin);
	
}

package org.dzq.ssm.dao;

import java.util.List;

import org.dzq.ssm.pojo.Admin;

public interface AdminMapper {
	List<Admin> findAll();
	Admin findById(int id);
	List<Admin> findByName(String name);
	int insertAdmin(Admin admin);
	int deleteAdmin(int id);
	int updateAdmin(Admin admin);
	Admin findByNameAndPwd(String name,String pwd);
}

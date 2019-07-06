package org.dzq.ssm.service.impl;

import java.util.List;

import org.dzq.ssm.dao.AdminMapper;
import org.dzq.ssm.pojo.Admin;
import org.dzq.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminDao;
	@Override
	public List<Admin> getAdminList() {
		List<Admin> adminList = adminDao.findAll();
		return adminList;
	}
	@Override
	public List<Admin> getAdminListByName(String name) {
		List<Admin> adminList = adminDao.findByName(name);
		return adminList;
	}
	@Override
	public Admin getAdmin(int id) {
		Admin admin = adminDao.findById(id);
		return admin;
	}
	@Override
	public int insertAdmin(Admin admin) {
		int effectNum = adminDao.insertAdmin(admin);
		return effectNum;
	}
	@Override
	public int deleteAdmin(int id) {
		int effectNum=0;
		if(id>0) {
			effectNum = adminDao.deleteAdmin(id);
		}else {
			System.out.println("输入id有误");
		}
		return effectNum;
	}
	@Override
	public int updateAdmin(Admin admin) {
		int effectNum = adminDao.updateAdmin(admin);
		return effectNum;
	}
	@Override
	public boolean checkLogin(String name, String pwd) {
		Admin admin = adminDao.findByNameAndPwd(name, pwd);
		boolean flag=false;
		if(admin!=null) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	@Override
	public Admin getAdminByAdmin(Admin admin) {
		Admin admin2= adminDao.findByNameAndPwd(admin.getName(), admin.getPwd());
		return admin2;
	}
	
}

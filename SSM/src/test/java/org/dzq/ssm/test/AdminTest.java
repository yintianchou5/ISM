package org.dzq.ssm.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.dzq.ssm.dao.AdminMapper;
import org.dzq.ssm.pojo.Admin;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminTest extends BaseTest{
	@Autowired
	private AdminMapper adminDao;
	@Test
	@Ignore
	public void testFindAll() {
		List<Admin> adminList = adminDao.findAll();
		assertEquals(7, adminList.size());
	}
	@Test
	@Ignore
	public void testFindById() {
		int id=4;
		Admin admin = adminDao.findById(id);
		assertEquals("张无忌", admin.getName());
	}
	@Test
	public void testfindByName() {
		List<Admin> adminList = adminDao.findByName("马");
		assertEquals(2, adminList.size());
	}
	@Test
	@Ignore
	public void testInsertAdmin() {
		Admin admin=new Admin();
		admin.setName("张良");
		admin.setPwd("123456");
		admin.setState(1);
		adminDao.insertAdmin(admin);
	}
}

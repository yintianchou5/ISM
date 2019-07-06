package org.dzq.ssm.service.impl;

import java.util.List;

import org.dzq.ssm.dao.BigTypeMapper;
import org.dzq.ssm.pojo.BigType;
import org.dzq.ssm.service.BigTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BigTypeServiceImpl implements BigTypeService{
	@Autowired
	private BigTypeMapper bigTypeMapper;
	@Override
	public List<BigType> getBigTypeList() {
		List<BigType> bigTypeList = bigTypeMapper.selectAllBigType();
		return bigTypeList;
	}
	
}

package org.dzq.ssm.service.impl;

import java.util.List;

import org.dzq.ssm.dao.SmallTypeMapper;
import org.dzq.ssm.pojo.SmallType;
import org.dzq.ssm.service.SmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SmallTypeServiceImpl implements SmallTypeService{
	@Autowired
	private SmallTypeMapper smallTypeMapper;
	@Override
	public List<SmallType> selectSmallByBigId(int bid) {
		List<SmallType> smallList = smallTypeMapper.selectSmallByBigId(bid);
		return smallList;
	}
	@Override
	public SmallType getSmallById(int id) {
		SmallType smallType = smallTypeMapper.selectSmallTypeById(id);
		return smallType;
	}

}

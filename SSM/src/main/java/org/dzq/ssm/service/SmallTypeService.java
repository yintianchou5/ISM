package org.dzq.ssm.service;

import java.util.List;

import org.dzq.ssm.pojo.SmallType;

public interface SmallTypeService {
	List<SmallType> selectSmallByBigId(int bid);
	SmallType getSmallById(int id);
}

package org.dzq.ssm.service;

import java.util.List;

import org.dzq.ssm.pojo.Input;

public interface InputService {
	int InsertInput(Input input);
	
	int deleteByPrimaryKey(Integer id);
	
	Input selectByPrimaryKey(Integer id);
	List<Input> getInputList();

	int updateByPrimaryKeySelective(Input record);

	int updateByPrimaryKey(Input record);
}

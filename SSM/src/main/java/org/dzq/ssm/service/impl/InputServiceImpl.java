package org.dzq.ssm.service.impl;

import java.util.List;

import org.dzq.ssm.dao.InputMapper;
import org.dzq.ssm.pojo.Input;
import org.dzq.ssm.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class InputServiceImpl implements InputService{
	@Autowired
	private InputMapper inputMapper;
	@Override
	public int InsertInput(Input input) {
		int effectNum = inputMapper.insert(input);
		return effectNum;
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Input selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Input> getInputList() {
		List<Input> InputList = inputMapper.selectAllInput();
		return InputList;
	}
	@Override
	public int updateByPrimaryKeySelective(Input record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateByPrimaryKey(Input record) {
		// TODO Auto-generated method stub
		return 0;
	}

}

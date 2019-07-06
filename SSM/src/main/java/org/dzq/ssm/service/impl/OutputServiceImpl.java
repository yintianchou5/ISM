package org.dzq.ssm.service.impl;

import java.util.List;

import org.dzq.ssm.dao.OutputMapper;
import org.dzq.ssm.pojo.Output;
import org.dzq.ssm.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OutputServiceImpl implements OutputService{
	@Autowired
	private OutputMapper outputMapper;
	@Override
	public List<Output> getOutputList() {
		List<Output> outputList = outputMapper.selectAllOutput();
		return outputList;
	}
	@Override
	public int InsertOutput(Output output) {
		int effectNum = outputMapper.insert(output);
		return effectNum;
	}

}

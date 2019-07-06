package org.dzq.ssm.service;

import java.util.List;

import org.dzq.ssm.pojo.Output;

public interface OutputService {
	List<Output> getOutputList();
	int InsertOutput(Output output);
}

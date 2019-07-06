package org.dzq.ssm.service.impl;

import java.util.List;

import org.dzq.ssm.dao.ProviderMapper;
import org.dzq.ssm.pojo.Provider;
import org.dzq.ssm.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProviderServiceImpl implements ProviderService{
	@Autowired private ProviderMapper providerMapper;
	@Override
	public List<Provider> getProviderList() {
		List<Provider> providerList = providerMapper.selectAllProvider();
		return providerList;
	}
	@Override
	public int addProvider(Provider provide) {
		int effectNum = providerMapper.insert(provide);
		return effectNum;
	}

}

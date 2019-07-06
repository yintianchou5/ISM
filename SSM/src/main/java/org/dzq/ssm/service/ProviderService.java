package org.dzq.ssm.service;

import java.util.List;

import org.dzq.ssm.pojo.Provider;

public interface ProviderService {
	List<Provider> getProviderList();
	int addProvider(Provider provide);
}

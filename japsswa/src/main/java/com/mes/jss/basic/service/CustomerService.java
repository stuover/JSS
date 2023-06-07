package com.mes.jss.basic.service;

import java.util.List;

import com.mes.jss.basic.domain.CustomerVO;
import com.mes.jss.basic.domain.TransListVO;
import com.mes.jss.basic.domain.TransactionItemVO;

public interface CustomerService {

	List<CustomerVO> getList();

	void saveCusDeta(TransListVO vo);

	List<TransactionItemVO> getTranList(String cusId);

	void removeItem(TransListVO data);

	CustomerVO addCustomer(CustomerVO data);



}

package com.mes.jss.basic.mapper;

import java.util.List;

import com.mes.jss.basic.domain.CustomerVO;
import com.mes.jss.basic.domain.TransactionItemVO;

public interface CustomerMapper {

	List<CustomerVO> getCustomerList();

	void updateCus(CustomerVO deta);

	void insertTrans(TransactionItemVO list);

	List<TransactionItemVO> getCusItemList(String cusId);

	int result(TransactionItemVO list);

}

package com.mes.jss.sale.service;

import java.security.Principal;
import java.util.List;

import com.mes.jss.sale.domain.FinishedVO;

public interface FinishedService {

	List<FinishedVO> passItem();

	void fRegister(List<FinishedVO> flist);

	List<FinishedVO> storeInItem();

	public void delFinished(List<FinishedVO> list);

	

}

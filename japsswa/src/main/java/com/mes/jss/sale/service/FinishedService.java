package com.mes.jss.sale.service;

import java.util.List;

import com.mes.jss.sale.domain.FinishedVO;

public interface FinishedService {

	List<FinishedVO> passItem();

	public void fRegister(List<FinishedVO> flist);

	List<FinishedVO> storeInItem();

	public void delFinished(List<FinishedVO> list);

	List<FinishedVO> entStoreIn();

	

}

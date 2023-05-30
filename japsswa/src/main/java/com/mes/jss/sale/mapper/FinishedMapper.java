package com.mes.jss.sale.mapper;

import java.util.List;

import com.mes.jss.sale.domain.FinishedVO;

public interface FinishedMapper {

	List<FinishedVO> passList();

	public void fRegister(long manager, FinishedVO fvo);

	List<FinishedVO> storeInItem();





}

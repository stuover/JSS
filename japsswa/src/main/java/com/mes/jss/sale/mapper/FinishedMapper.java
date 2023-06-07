package com.mes.jss.sale.mapper;

import java.util.List;

import com.mes.jss.sale.domain.FinishedVO;

public interface FinishedMapper {

	List<FinishedVO> passItem();

	public void fRegister(FinishedVO fvo);

	List<FinishedVO> storeInItem();

	public void delFinished(FinishedVO vo);





}

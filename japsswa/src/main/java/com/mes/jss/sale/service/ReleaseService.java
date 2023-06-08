package com.mes.jss.sale.service;

import java.util.List;

import com.mes.jss.sale.domain.ReleaseListVO;
import com.mes.jss.sale.domain.ReleaseVO;

public interface ReleaseService {

	List<ReleaseVO> showTopList(String itemName);

	List<ReleaseVO> showBottomList(String iName);

	public void itemOut(ReleaseListVO rlist);




}

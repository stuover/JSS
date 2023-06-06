package com.mes.jss.sale.mapper;

import java.util.List;

import com.mes.jss.sale.domain.ReleaseVO;

public interface ReleaseMapper {

	List<ReleaseVO> showTopList(String itemName);

	List<ReleaseVO> showBottomList(String iName);

	public void commOut(ReleaseVO volist);

	public void itemOut(ReleaseVO rVo);





}

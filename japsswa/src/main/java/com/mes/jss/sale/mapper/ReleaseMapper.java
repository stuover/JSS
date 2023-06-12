package com.mes.jss.sale.mapper;

import java.util.List;

import com.mes.jss.sale.domain.ReleaseListVO;
import com.mes.jss.sale.domain.ReleaseVO;

public interface ReleaseMapper {

	List<ReleaseVO> showTopList(String itemName);

	List<ReleaseVO> showBottomList(String iName);

	public void commOut(ReleaseVO rlist);

	public void itemOut(ReleaseVO rVo);

	List<ReleaseVO> entRelease();

	List<ReleaseVO> releaseCheck(ReleaseVO rvo);

	List<ReleaseVO> relItemSearch(String itemName);

	List<ReleaseVO> relCustSearch(String customerName);

	List<ReleaseVO> relDetCheck(String fnReleaseId);





}

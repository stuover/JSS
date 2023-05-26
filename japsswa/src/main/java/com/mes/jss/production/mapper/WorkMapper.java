package com.mes.jss.production.mapper;

import java.util.List;

import com.mes.jss.basic.domain.BomVO;
import com.mes.jss.basic.domain.ProcessOrderVO;
import com.mes.jss.production.domain.WorkVO;

public interface WorkMapper {
	
	// 선택한 제품의 공정정보
	List<BomVO> processInfo(String code);
	
	// 선택한 공정에 투입되는 자재 BOM 정보
	List<BomVO> bomInfo(BomVO vo);
	
}

package com.mes.jss.production.mapper;

import java.util.List;

import com.mes.jss.production.domain.WorkVO;

public interface WorkMapper {
	
	// 선택한 제품의 공정정보
	List<WorkVO> processInfo(String code);
	
	
}

package com.mes.jss.production.service;

import java.util.List;

import com.mes.jss.basic.domain.ProcessOrderVO;
import com.mes.jss.production.domain.WorkVO;

public interface WorkService {
	
	// 선택한 제품의 공정정보
	List<ProcessOrderVO> processInfo(String code);
	
	
	//
	
	
	
	

}

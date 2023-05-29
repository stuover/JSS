package com.mes.jss.production.service;

import java.util.List;

import com.mes.jss.basic.domain.ProcessVO;

public interface PerformanceService {
	
	// 공정 조회 모달창 : 공정 리스트(초기값)
	List<ProcessVO> processList();
	
	
	
}

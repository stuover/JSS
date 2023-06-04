package com.mes.jss.production.mapper;

import java.util.List;

import com.mes.jss.basic.domain.EmpVO;
import com.mes.jss.basic.domain.ProcessVO;
import com.mes.jss.production.domain.WorkVO;

public interface PerformanceMapper {
	
	// 공정 조회 모달창 : 공정 리스트(초기값)
	List<ProcessVO> processList();
	
	// 공정 조회 모달창 : 공정 리스트(키워드 검색 결과)
	List<ProcessVO> processListResult(ProcessVO vo);
	
	// 작업지시 조회 모달창 : 작업지시 내역
	// 작업이 완료된 작업지시 제외
	// 작업 시작 시간이 현재 날짜인 것만 조회
	List<WorkVO> todayWorkModalList();
	
	// 생산실적 등록 모달창 : 사원 리스트
	List<EmpVO> empList();
	
}

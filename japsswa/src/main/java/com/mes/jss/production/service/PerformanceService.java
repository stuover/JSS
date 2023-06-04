package com.mes.jss.production.service;

import java.util.List;

import com.mes.jss.basic.domain.EmpVO;
import com.mes.jss.basic.domain.ProcessVO;
import com.mes.jss.production.domain.PerformanceVO;
import com.mes.jss.production.domain.WorkVO;

public interface PerformanceService {
	
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
	
	// 생산실적 등록 모달창 :  설비 리스트
	// 설비 조회 모달창 : 비가동 사유가 점검이나 세척이 아닌 설비 리스트
	List<PerformanceVO> performanceFacList(String podCode);
	
	
	// 생산실적 등록 : 작업 시작
	public void performanceStart(PerformanceVO vo);
	
	// 생산실적 등록 :  작업 완료
	public void performanceEnd(PerformanceVO vo);
	
	
	
}

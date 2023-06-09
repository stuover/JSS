package com.mes.jss.production.mapper;

import java.util.List;

import com.mes.jss.basic.domain.EmpVO;
import com.mes.jss.basic.domain.ProcessVO;
import com.mes.jss.production.domain.PerformanceVO;
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
	
	// 생산실적 등록 모달창 :  설비 리스트
	// 설비 조회 모달창 : 비가동 사유가 점검이나 세척이 아닌 설비 리스트
	List<PerformanceVO> performanceFacList(String podCode);
	
	
	// 생산실적 등록 : 작업 시작
	public PerformanceVO performanceStart(PerformanceVO vo);
	
	// 생산실적 등록 :  작업 완료
	public PerformanceVO performanceEnd(PerformanceVO vo);
	
	// 생산실적 등록 : 등록 모달창 오픈 -> 작업시작 or 작업완료 여부
	public PerformanceVO performanceInsertCondition(PerformanceVO vo);
	
	// 생산실적 : 작업완료 등록인 경우
	// 입력했던 생산실적 등록정보 가져오기
	public PerformanceVO searchPerformanceStart(PerformanceVO vo);
	
	
	// 설비별 생산실적 모니터링
	public List<PerformanceVO> performanceMonitoring();
	
	// 생산 실적  차트
	public List<PerformanceVO> todayChart();
	
	
}

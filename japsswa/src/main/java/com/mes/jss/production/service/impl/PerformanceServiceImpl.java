package com.mes.jss.production.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.domain.EmpVO;
import com.mes.jss.basic.domain.ProcessVO;
import com.mes.jss.production.domain.PerformanceVO;
import com.mes.jss.production.domain.WorkVO;
import com.mes.jss.production.mapper.PerformanceMapper;
import com.mes.jss.production.service.PerformanceService;


@Service
public class PerformanceServiceImpl implements PerformanceService{
	
	@Autowired PerformanceMapper performanceMapper ;
	
	// 공정 조회 모달창 : 공정 리스트(초기값)
	@Override
	public List<ProcessVO> processList() {
		List<ProcessVO> list = new ArrayList<>();
		list = performanceMapper.processList();
		
		return list;
	}

	// 공정 조회 모달창 : 공정 리스트(키워드 검색 결과)
	@Override
	public List<ProcessVO> processListResult(ProcessVO vo) {
		List<ProcessVO> list =  performanceMapper.processListResult(vo);
		return list;
	}

	
	// 작업지시 조회 모달창 : 작업지시 내역
	// 작업이 완료된 작업지시 제외
	// 작업 시작 시간이 현재 날짜인 것만 조회
	@Override
	public List<WorkVO> todayWorkModalList() {
		List<WorkVO> list = performanceMapper.todayWorkModalList();
		return list;
	}

	// 생산실적 등록 모달창 : 사원 리스트
	@Override
	public List<EmpVO> empList() {
		List<EmpVO> list = performanceMapper.empList();
		return list;
	}

	
	// 생산실적 등록 모달창 :  설비 리스트
	// 설비 조회 모달창 : 비가동 사유가 점검이나 세척이 아닌 설비 리스트
	@Override
	public List<PerformanceVO> performanceFacList(String podCode) {
		List<PerformanceVO> list = performanceMapper.performanceFacList(podCode);
		return list;
	}

	// 생산실적 등록 : 작업 시작
	@Override
	public void performanceStart(PerformanceVO vo) {
		performanceMapper.performanceStart(vo);
		
	}

	// 생산실적 등록 :  작업 완료
	@Override
	public void performanceEnd(PerformanceVO vo) {
		performanceMapper.performanceEnd(vo);
		
	}

	
	// 생산실적 등록 : 등록 모달창 오픈 -> 작업시작 or 작업완료 여부
	@Override
	public PerformanceVO performanceInsertCondition(PerformanceVO vo) {
		PerformanceVO result = performanceMapper.performanceInsertCondition(vo);
		return result;
	}

	
	// 생산실적 : 작업완료 등록인 경우
	// 입력했던 생산실적 등록정보 가져오기
	@Override
	public PerformanceVO searchPerformanceStart(PerformanceVO vo) {
		PerformanceVO result = performanceMapper.searchPerformanceStart(vo);
		return result;
	}

	
	// 설비별 생산실적 모니터링
	@Override
	public List<PerformanceVO> performanceMonitoring() {
		List<PerformanceVO> result = performanceMapper.performanceMonitoring();
				
		return result;
	}


	
	
	
	
	
	
}

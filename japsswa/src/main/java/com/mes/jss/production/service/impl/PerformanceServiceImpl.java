package com.mes.jss.production.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.domain.EmpVO;
import com.mes.jss.basic.domain.ProcessVO;
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
	
	
	
	
	
	
}

package com.mes.jss.production.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.domain.ProcessVO;
import com.mes.jss.production.mapper.PerformanceMapper;
import com.mes.jss.production.service.PerformanceService;


@Service
public class PerformanceServiceImpl implements PerformanceService{
	
	@Autowired PerformanceMapper performanceMapper ;
	
	@Override
	public List<ProcessVO> processList() {
		List<ProcessVO> list = new ArrayList<>();
		list = performanceMapper.processList();
		
		return list;
	}
	
	
	
	
	
	
}

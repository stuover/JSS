package com.mes.jss.production.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.production.domain.WorkVO;
import com.mes.jss.production.mapper.WorkMapper;
import com.mes.jss.production.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService {
	
	@Autowired WorkMapper workmapper;
	
	
	@Override
	public List<WorkVO> processInfo(String code) {
		List<WorkVO> list = new ArrayList<>();
		workmapper.processInfo(code);
		

		return list;
	}

}

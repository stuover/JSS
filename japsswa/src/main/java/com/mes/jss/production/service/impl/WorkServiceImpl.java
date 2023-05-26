package com.mes.jss.production.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.domain.BomVO;
import com.mes.jss.basic.domain.ProcessOrderVO;
import com.mes.jss.production.domain.WorkVO;
import com.mes.jss.production.mapper.WorkMapper;
import com.mes.jss.production.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService {
	
	@Autowired WorkMapper workmapper;
	
	
	@Override
	public List<BomVO> processInfo(String code) {
		List<BomVO> list = new ArrayList<>();
		list = workmapper.processInfo(code);

		return list;
	}


	@Override
	public List<BomVO> bomInfo(BomVO vo) {
		List<BomVO> list = new ArrayList<>();
		list = workmapper.bomInfo(vo);
		
		return list;
	}

}

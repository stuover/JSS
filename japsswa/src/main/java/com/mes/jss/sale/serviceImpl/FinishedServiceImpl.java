package com.mes.jss.sale.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.sale.domain.FinishedVO;
import com.mes.jss.sale.mapper.FinishedMapper;
import com.mes.jss.sale.service.FinishedService;

@Service
public class FinishedServiceImpl implements FinishedService{
	
	@Autowired FinishedMapper finishedMapper;
	
	@Override
	public List<FinishedVO> passList() {
		List<FinishedVO> flist = finishedMapper.passList();
		return flist;
	}

}

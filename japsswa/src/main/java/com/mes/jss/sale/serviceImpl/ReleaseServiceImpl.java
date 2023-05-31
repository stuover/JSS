package com.mes.jss.sale.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.sale.domain.ReleaseVO;
import com.mes.jss.sale.mapper.ReleaseMapper;
import com.mes.jss.sale.service.ReleaseService;

@Service
public class ReleaseServiceImpl implements ReleaseService {
	
	@Autowired ReleaseMapper releaseMapper;

	@Override
	public List<ReleaseVO> finishedList() {
		List<ReleaseVO> tlist = releaseMapper.finishedList();
		return tlist;
	}
	
}

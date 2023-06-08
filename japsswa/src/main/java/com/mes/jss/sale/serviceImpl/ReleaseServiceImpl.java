package com.mes.jss.sale.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.sale.domain.ReleaseListVO;
import com.mes.jss.sale.domain.ReleaseVO;
import com.mes.jss.sale.mapper.ReleaseMapper;
import com.mes.jss.sale.service.ReleaseService;

@Service
public class ReleaseServiceImpl implements ReleaseService {
	
	@Autowired ReleaseMapper releaseMapper;

	@Override
	public List<ReleaseVO> showTopList(String itemName) {
		List<ReleaseVO> toplist = releaseMapper.showTopList(itemName);
		return toplist;
	}

	@Override
	public List<ReleaseVO> showBottomList(String iName) {
		List<ReleaseVO> botlist = releaseMapper.showBottomList(iName);
		return botlist;
	}

	@Override
	public void itemOut(ReleaseListVO rlist) {
		
		
		
		releaseMapper.commOut(rlist.getReleaseList().get(0));
		System.err.println(rlist.getReleaseList().get(0));
		
		
		  for(int i=0; i<rlist.getReleaseList2().size(); i++) {
		  releaseMapper.itemOut(rlist.getReleaseList2().get(i));
		  System.err.println(rlist.getReleaseList2().get(i)); }
		 
	}




}

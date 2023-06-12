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

	@Override
	public List<ReleaseVO> entRelease() {
		List<ReleaseVO> erlist = releaseMapper.entRelease();
		return erlist;
	}

	@Override
	public List<ReleaseVO> releaseCheck(ReleaseVO rvo) {
		List<ReleaseVO> checkList = releaseMapper.releaseCheck(rvo);
		return checkList;
	}

	@Override
	public List<ReleaseVO> relItemSearch(String itemName) {
		List<ReleaseVO> rllist = releaseMapper.relItemSearch(itemName);
		return rllist;
	}

	@Override
	public List<ReleaseVO> relCustSearch(String customerName) {
		List<ReleaseVO> rclist = releaseMapper.relCustSearch(customerName);
		return rclist;
	}

	@Override
	public List<ReleaseVO> relDetCheck(String fnReleaseId) {
		List<ReleaseVO> rdlist = releaseMapper.relDetCheck(fnReleaseId);
		return rdlist;
	}




}

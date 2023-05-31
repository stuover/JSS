package com.mes.jss.sale.serviceImpl;

import java.security.Principal;
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
	public List<FinishedVO> passItem() {
		List<FinishedVO> flist = finishedMapper.passItem();
		return flist;
	}

	@Override
	public void fRegister( List<FinishedVO> flistvo) {
		
			
		for(FinishedVO fvo : flistvo) {
			
					
			finishedMapper.fRegister(fvo);
		}
		
	}

	@Override
	public List<FinishedVO> storeInItem() {
		return finishedMapper.storeInItem();
		
	}

	@Override
	public void delFinished(List<FinishedVO> list) {
		for(FinishedVO vo : list) {
			finishedMapper.delFinished(vo);
		}
		
	}

	

}

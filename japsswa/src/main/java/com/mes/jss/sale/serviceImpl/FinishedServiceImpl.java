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
	public List<FinishedVO> passList() {
		List<FinishedVO> flist = finishedMapper.passList();
		return flist;
	}

	@Override
	public void fRegister(Principal principal, List<FinishedVO> flist) {
		
			
		for(FinishedVO fvo : flist) {
			long a =Long.parseLong(principal.getName());
					
			finishedMapper.fRegister(a, fvo);
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

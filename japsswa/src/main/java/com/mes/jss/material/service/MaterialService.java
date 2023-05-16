package com.mes.jss.material.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mes.jss.material.domain.MrVO;

public interface MaterialService {
	
		public int mrStore(MrVO vo);
	public List<MrVO> mrlist();
}

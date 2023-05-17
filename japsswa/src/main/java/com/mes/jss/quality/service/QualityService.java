package com.mes.jss.quality.service;

import java.util.List;

import com.mes.jss.material.domain.MrVO;
import com.mes.jss.quality.domain.QualityVO;

public interface QualityService {

	public int mrStore(MrVO vo);
public List<QualityVO> qlList();
}

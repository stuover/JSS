package com.mes.jss.basic.service;

import java.util.List;

import com.mes.jss.basic.domain.CommListVO;
import com.mes.jss.basic.domain.CommVO;

public interface CommonService {

	public List<CommVO> getCommListe();

	public List<CommVO> getDetaList(String commCode);

	public void modifyDetails(CommListVO listVo);

}

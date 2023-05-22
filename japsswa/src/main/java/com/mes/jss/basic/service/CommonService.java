package com.mes.jss.basic.service;

import java.util.List;

import com.mes.jss.basic.domain.CommListVO;
import com.mes.jss.basic.domain.CommVO;

public interface CommonService {

	public List<CommVO> getCommListe();

	public List<CommVO> getDetaList(String commCode);

	public void modifyDetails(CommListVO listVo);

	public void removeDetails(CommListVO listVo);

	public CommVO getCommCode(String commCode);

	public void addCommCode(CommVO vo);

	public boolean searchComm(String commCode);

	public void removeCommCode(String commCode);

}

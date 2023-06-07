package com.mes.jss.basic.service;

import java.util.List;

import com.mes.jss.basic.domain.BomListVO;
import com.mes.jss.basic.domain.BomVO;
import com.mes.jss.basic.domain.ItemVO;

public interface BomService {

	List<BomVO> getBomList(String itemCode);


	void saveBom(BomListVO save);


	String getNumber();


	void remove(BomListVO dete);


	List<BomVO> getBomManageList(String itemCode);

}

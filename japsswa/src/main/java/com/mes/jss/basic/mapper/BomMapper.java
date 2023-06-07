package com.mes.jss.basic.mapper;

import java.util.List;

import com.mes.jss.basic.domain.BomVO;
import com.mes.jss.basic.domain.ItemVO;

public interface BomMapper {
	
	List<BomVO> getBomList(String itemCode);

	void insertBom(BomVO vo);

	String getNumber();

	void deleteBom(BomVO vo);

	void updateBom(BomVO vo);

	List<BomVO> getBomManageList(String itemCode);

	List<BomVO> getSmaBomList(String itemCode);


}

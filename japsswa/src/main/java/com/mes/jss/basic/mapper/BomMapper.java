package com.mes.jss.basic.mapper;

import java.util.List;

import com.mes.jss.basic.domain.ItemVO;

public interface BomMapper {

	List<ItemVO> getBomList(String itemCode);

}

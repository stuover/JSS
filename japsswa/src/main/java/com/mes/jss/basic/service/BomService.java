package com.mes.jss.basic.service;

import java.util.List;

import com.mes.jss.basic.domain.ItemVO;

public interface BomService {

	List<ItemVO> getBomList(String itemCode);

}

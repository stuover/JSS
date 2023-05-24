package com.mes.jss.basic.service;

import java.util.List;

import com.mes.jss.basic.domain.ItemVO;

public interface ItemService {

	List<ItemVO> getItemList(String val);

	ItemVO getItemCode();

	List<ItemVO> getAllItemList();

	void addItem(ItemVO vo);

	void modifyItem(ItemVO vo);

	boolean removeItem(String itemCode);

	List<ItemVO> searchItem(String itemName);

}

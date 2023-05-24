package com.mes.jss.basic.mapper;

import java.util.List;

import com.mes.jss.basic.domain.ItemVO;

public interface ItemMapper {

	List<ItemVO> getItemList(String val);

	ItemVO getItemCode();

	List<ItemVO> getAllItemList();

	int insertItem(ItemVO vo);

	void updateItem(ItemVO vo);

	boolean deleteItem(String itemCode);

	List<ItemVO> searchItem(String itemName);

}

package com.mes.jss.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.domain.ItemVO;
import com.mes.jss.basic.mapper.ItemMapper;
import com.mes.jss.basic.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	@Autowired ItemMapper itemMapper;

	@Override
	public List<ItemVO> getItemList(String val) {
		// TODO Auto-generated method stub
		return itemMapper.getItemList(val);
	}

	@Override
	public ItemVO getItemCode() {
		// TODO Auto-generated method stub
		return itemMapper.getItemCode();
	}

	@Override
	public List<ItemVO> getAllItemList() {
		// TODO Auto-generated method stub
		return itemMapper.getAllItemList();
	}

	@Override
	public void addItem(ItemVO vo) {
		 itemMapper.insertItem(vo);
	}

	@Override
	public void modifyItem(ItemVO vo) {
		itemMapper.updateItem(vo);
		
	}

	@Override
	public boolean removeItem(String itemCode) {
		// TODO Auto-generated method stub
		return itemMapper.deleteItem(itemCode);
	}

	@Override
	public List<ItemVO> searchItem(String itemName) {
		// TODO Auto-generated method stub
		return itemMapper.searchItem(itemName);
	}
}

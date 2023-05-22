package com.mes.jss.basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.mapper.ItemMapper;
import com.mes.jss.basic.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	@Autowired ItemMapper itemMapper;
}

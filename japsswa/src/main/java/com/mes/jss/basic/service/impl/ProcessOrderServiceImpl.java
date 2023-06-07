package com.mes.jss.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.mapper.ProcessOrderMapper;
import com.mes.jss.basic.service.ProcessOrderService;

@Service("processOrderService")
public class ProcessOrderServiceImpl implements ProcessOrderService{
@Autowired ProcessOrderMapper proOrdMapper;

@Override
public List<Object> getProList(String itemCode) {
	// TODO Auto-generated method stub
	return proOrdMapper.getProList(itemCode);
}
}

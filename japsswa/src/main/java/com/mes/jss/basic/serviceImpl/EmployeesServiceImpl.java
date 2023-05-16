package com.mes.jss.basic.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.DTO.Criteria;
import com.mes.jss.basic.domain.EmpVO;
import com.mes.jss.basic.mapper.EmployeesMapper;
import com.mes.jss.basic.service.EmployeesService;


@Service("emploeesService")
public class EmployeesServiceImpl implements EmployeesService{
	
	@Autowired EmployeesMapper mapper;

	@Override
	public List<EmpVO> getEmpList(){
		return mapper.getList();
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return mapper.getTotalCountj(cri);
	}
	
}

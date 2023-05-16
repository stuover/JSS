package com.mes.jss.basic.mapper;

import java.util.List;

import com.mes.jss.DTO.Criteria;
import com.mes.jss.basic.domain.EmpVO;

public interface EmployeesMapper {
	
	// 사원 List
	public List<EmpVO> getList();

	public int getTotalCountj(Criteria cri);

}

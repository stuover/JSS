package com.mes.jss.basic.service;

import java.util.List;

import com.mes.jss.DTO.Criteria;
import com.mes.jss.basic.domain.EmpVO;

public interface EmployeesService {
	
	// 사원 List
	public List<EmpVO> getEmpList();
	public int getTotalCount(Criteria cri);
	public String getNextSeq();
	public boolean ragisterEmp(EmpVO vo);
	public EmpVO getEmp(EmpVO vo);


}

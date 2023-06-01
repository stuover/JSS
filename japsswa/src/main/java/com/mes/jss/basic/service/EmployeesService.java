package com.mes.jss.basic.service;

import java.util.List;

import com.mes.jss.basic.domain.EmpVO;

public interface EmployeesService {
	
	// 사원 List
	public List<EmpVO> getEmpList();
	public String getNextSeq();
	public boolean ragisterEmp(EmpVO vo);
	public EmpVO getEmp(EmpVO vo);
	public boolean modifyEmp(EmpVO vo);
	public boolean removeEmp(EmpVO vo);
	EmpVO gerUser(EmpVO vo);
	public String getPwd(String name);
	public void modifyPwd(EmpVO vo);


}

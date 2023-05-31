package com.mes.jss.basic.mapper;

import java.util.List;

import com.mes.jss.basic.domain.EmpVO;

public interface EmployeesMapper {
	
	// 사원 List
	public List<EmpVO> getList();

	public String getNextSeq();

	public int insertEmp(EmpVO vo);

	public EmpVO selectEmp(EmpVO vo);

	public boolean updateEmp(EmpVO vo);

	public boolean deleteEmp(EmpVO vo);

	public EmpVO getUser(EmpVO vo);

	public String getPwd(String name);

	public void updatePwd(String npwd, String name);

}

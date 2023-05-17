package com.mes.jss.basic.domain;

import lombok.Data;

@Data
public class EmpVO {
	
	public int rownum;
	public long empNo;
	public String empName;
	public String hireDate;
	public String phoneNum;
	public String deptName;
	public String position;
	public String email;
	public String password;
	public String roleId;
}

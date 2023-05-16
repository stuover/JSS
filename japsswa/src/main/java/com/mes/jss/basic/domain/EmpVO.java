package com.mes.jss.basic.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {

	public long empNo;
	public String empName;
	public Date hireDate;
	public String phoneNum;
	public String deptName;
	public String position;
	public String email;
	public String password;
	public String roleId;
}

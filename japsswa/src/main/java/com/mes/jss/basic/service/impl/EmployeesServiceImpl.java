package com.mes.jss.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.domain.EmpVO;
import com.mes.jss.basic.mapper.EmployeesMapper;
import com.mes.jss.basic.service.EmployeesService;


@Service("emploeesService")
public class EmployeesServiceImpl implements EmployeesService, UserDetailsService{
	
	@Autowired EmployeesMapper empMapper;

	
	@Override
	public EmpVO gerUser(EmpVO vo) {

		return empMapper.getUser(vo);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 단건조회
		EmpVO userVO = new EmpVO();
		userVO.setEmpNo(username);
		EmpVO vo =  empMapper.getUser(userVO);		

		// id 없으면 에러
		if(vo == null) {
			throw new UsernameNotFoundException("no id");
		}

		// id 있으면 vo return
		return vo;		// Principal
	}
	
	@Override
	public List<EmpVO> getEmpList(){
		return empMapper.getList();
	}


	@Override
	public String getNextSeq() {
		// TODO Auto-generated method stub
		return empMapper.getNextSeq();
	}

	@Override
	public boolean ragisterEmp(EmpVO vo) {

		return empMapper.insertEmp(vo) > 0;
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		return empMapper.selectEmp(vo);
	}

	@Override
	public boolean modifyEmp(EmpVO vo) {
		return empMapper.updateEmp(vo);
	}

	@Override
	public boolean removeEmp(EmpVO vo) {
		
		return empMapper.deleteEmp(vo);
	}

	@Override
	public String getPwd(String name) {
		// TODO Auto-generated method stub
		return empMapper.getPwd(name);
	}

	@Override
	public void modifyPwd(String npwd, String name) {
		empMapper.updatePwd(npwd, name);
		
	}
	
	


	
}

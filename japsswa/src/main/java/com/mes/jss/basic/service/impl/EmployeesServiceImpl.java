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
	
	@Autowired EmployeesMapper mapper;

	
	@Override
	public EmpVO gerUser(EmpVO vo) {

		return mapper.getUser(vo);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 단건조회
		EmpVO userVO = new EmpVO();
		userVO.setEmpNo(username);
		EmpVO vo =  mapper.getUser(userVO);		

		// id 없으면 에러
		if(vo == null) {
			throw new UsernameNotFoundException("no id");
		}

		// id 있으면 vo return
		return vo;		// Principal
	}
	
	@Override
	public List<EmpVO> getEmpList(){
		return mapper.getList();
	}


	@Override
	public String getNextSeq() {
		// TODO Auto-generated method stub
		return mapper.getNextSeq();
	}

	@Override
	public boolean ragisterEmp(EmpVO vo) {

		return mapper.insertEmp(vo) > 0;
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		return mapper.selectEmp(vo);
	}

	@Override
	public boolean modifyEmp(EmpVO vo) {
		return mapper.updateEmp(vo);
	}

	@Override
	public boolean removeEmp(EmpVO vo) {
		
		return mapper.deleteEmp(vo);
	}
	
	


	
}

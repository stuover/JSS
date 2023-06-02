package com.mes.jss.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mes.jss.DTO.SearchDTO;
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
	public List<EmpVO> getEmpList(SearchDTO dto){
		return empMapper.getList(dto);
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
		System.err.println(vo);
		
		if(vo.getPosition().equals("관리자")) {
			if(vo.getDeptName().equals("인사")) {
				vo.setRoleId("EMP_ADMIN");
			}else if(vo.getDeptName().equals("자재")) {
				vo.setRoleId("MAT_ADMIN");
			}else if(vo.getDeptName().equals("품질")) {
				vo.setRoleId("QUA_ADMIN");
			}else if(vo.getDeptName().equals("영업")) {
				vo.setRoleId("SAL_ADMIN");
			}else if(vo.getDeptName().equals("설비")) {
				vo.setRoleId("FAC_ADMIN");
			}else if(vo.getDeptName().equals("생산")) {
				vo.setRoleId("PRO_ADMIN");
			}
		}else {
			if(vo.getDeptName().equals("인사")) {
				vo.setRoleId("EMP_USER");
			}else if(vo.getDeptName().equals("자재")) {
				vo.setRoleId("MAT_USER");
			}else if(vo.getDeptName().equals("품질")) {
				vo.setRoleId("QUA_USER");
			}else if(vo.getDeptName().equals("영업")) {
				vo.setRoleId("SAL_USER");
			}else if(vo.getDeptName().equals("설비")) {
				vo.setRoleId("FAC_USER");
			}else if(vo.getDeptName().equals("생산")) {
				vo.setRoleId("PRO_USER");
			}
			
		}
		
		System.err.println(vo);
		
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
	public void modifyPwd(EmpVO vo) {
		empMapper.updatePwd(vo);
		
	}
	
	


	
}

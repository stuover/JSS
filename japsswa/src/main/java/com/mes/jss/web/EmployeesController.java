package com.mes.jss.web;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.DTO.SearchDTO;
import com.mes.jss.basic.domain.EmpVO;
import com.mes.jss.basic.service.EmployeesService;

@Controller
public class EmployeesController {

	@Autowired
	EmployeesService empService;
	@RequestMapping("/employee")
	public String testgrid(Model model) {

		return "basic/employee";
	}

	// 전체 리스트
	@ResponseBody
	@GetMapping("/employeeAjax")
	public List<EmpVO> employees(SearchDTO dto ) {
		System.err.println(dto);
		List<EmpVO> list = empService.getEmpList(dto);

		return list;
	}

	// 사원등록 페이지
	@GetMapping("/employee/ragister")
	public String register() {

		return "basic/ragister";
	}

	// 사원 등록
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String register(Model model, EmpVO vo) {
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		vo.setPassword(scpwd.encode(vo.getPassword()));
		empService.ragisterEmp(vo);
		return "basic/employee";
	}

	// 사원번호 부여
	@ResponseBody
	@RequestMapping("/ragisterAjax")
	public String ragisterAjax(EmpVO vo, Model model) {
		String strNewDtFormat = null;
		try {
			SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat newDtFormat = new SimpleDateFormat("yyMMdd");
			// String 타입을 Date 타입으로 변환
			Date formatDate = dtFormat.parse(vo.getHireDate());
			// Date타입의 변수를 새롭게 지정한 포맷으로 변환
			strNewDtFormat = newDtFormat.format(formatDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String empNo = strNewDtFormat + empService.getNextSeq();

		return empNo;
	}

	// 사원 단건조회
	@ResponseBody
	@RequestMapping("/serchEmpAjax")
	public EmpVO serchEmp(EmpVO vo, Model model) {

		System.out.println(vo.getEmpNo());
		System.out.println(empService.getEmp(vo));
		return empService.getEmp(vo);

	}

	// 사원정보 수정
	@ResponseBody
	@RequestMapping("/modifyEmpAjax")
	public String modifyEmp(EmpVO vo, Model model) {
		System.err.println(vo);
		if (empService.modifyEmp(vo)) {
			return "Success";
		} else {
			return "Fail";
		}

	}

	// 사원정보 삭제
	@ResponseBody
	@RequestMapping("/removeEmpAjax")
	public String removeEmp(EmpVO vo, Model model) {

		if (empService.removeEmp(vo)) {
			return "success";
		} else {
			return "Fail";
		}
	}
	
	@ResponseBody
	@RequestMapping("/modifyPwd")
	public String modifyPwd(@RequestBody EmpVO vo, Principal principal) {
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		System.err.println(vo);
		
		boolean result = scpwd.matches(vo.getPassword(), empService.getPwd(principal.getName()));
		System.err.println(result);
		if(result) {
			if(vo.getNewPwd()!= null && vo.getNewPwd()!="".toString()) {
				vo.setNewPwd(scpwd.encode(vo.getNewPwd()));
			}
			vo.setEmpNo(principal.getName());
			empService.modifyPwd(vo);
			return "success";
		}else{
			return "fail";
		}
		
	}
	
	
}

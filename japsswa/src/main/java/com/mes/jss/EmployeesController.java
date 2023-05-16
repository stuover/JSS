package com.mes.jss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.DTO.Criteria;
import com.mes.jss.basic.domain.EmpVO;
import com.mes.jss.basic.service.EmployeesService;
import com.mes.jss.basic.serviceImpl.EmployeesServiceImpl;

@Controller
public class EmployeesController {
	
	@Autowired EmployeesService service = new EmployeesServiceImpl();
	

	@RequestMapping("/employee")
	public String testgrid(Model model) {	
		
		return "basic/employee";
	}
	
	
	@ResponseBody
	@GetMapping("/employeeAjax")
	public List<EmpVO> employees(Model model, Criteria cri) {	
		List<EmpVO> list = service.getEmpList();

        return list;
	}
	
	
	@RequestMapping("/employee/ragister")
	public String register() {
		
		return "basic/ragister";
	}
	
	
}

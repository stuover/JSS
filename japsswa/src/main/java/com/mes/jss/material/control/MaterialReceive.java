package com.mes.jss.material.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.service.MaterialService;





@Controller
@SpringBootApplication

public class MaterialReceive {
	
	@Autowired
	MaterialService materialService;
	
	
	@GetMapping("/mslist")
	public String mrList(Model model, MrVO vo) {
	
		
		return "/material/material";
						
	}
	
	@ResponseBody
	@GetMapping("/mslistAjax")
	public List<MrVO> mrList() {
						
		List<MrVO> list = materialService.mrlist();
	
		
		
		return list;
						
	}
	
	
	
	
	
	
	
	
	
}

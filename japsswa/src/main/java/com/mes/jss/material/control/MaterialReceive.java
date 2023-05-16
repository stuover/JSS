package com.mes.jss.material.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.service.MaterialService;





@Controller
@SpringBootApplication

public class MaterialReceive {
	
	@Autowired
	MaterialService materialService;
	
	
	@GetMapping("/mrlist")
	public String mrList(Model model, MrVO vo) {
	
		
		return "/material/materialStore";
						
	}
	
	@ResponseBody
	@GetMapping("/mrlistAjax")
	public List<MrVO> mrList() {
						
		List<MrVO> list = materialService.mrlist();
	
		
		
		return list;
						
	}
	
	
	
	
	
	
	
	
}

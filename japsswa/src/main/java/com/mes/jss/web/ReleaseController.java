package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.domain.ReleaseVO;
import com.mes.jss.sale.service.ReleaseService;

@Controller
public class ReleaseController {
	
	@Autowired ReleaseService releaseService;
	
	//출고관리화면
	@GetMapping("/release")
	public String release() {
		return "sale/Release";
	}

	//품목검색 -> 상단 그리드 자동입력
	@RequestMapping("/showTopList")
	@ResponseBody
	public List<ReleaseVO> showTopListAjax(@RequestParam String itemName){
	
		System.out.println(itemName);
		List<ReleaseVO> tlist = releaseService.showTopList(itemName);
		
		return tlist;
	}
	
	//하단 그리드 리스트
	@RequestMapping("/showBottomList")
	@ResponseBody
	public List<ReleaseVO> showBottomListAjax(@RequestParam (name="itemName") String iName){
		List<ReleaseVO> blist = releaseService.showBottomList(iName);
		return blist;
	}

	//출고처리
	@RequestMapping("/itemOut")
	@ResponseBody
	public ReleaseVO itemOutAjax(@RequestBody List<ReleaseVO> rlist) {
		releaseService.itemOut(rlist);
		
		return null;
	}
	
}

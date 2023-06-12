package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.sale.domain.ReleaseListVO;
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
	public ReleaseVO itemOutAjax(@RequestBody ReleaseListVO releaseList) {
		
		
		System.err.println(releaseList);
		
	
		releaseService.itemOut(releaseList);
		
		return null;
	}
	
	//출고 조회 화면
	@RequestMapping("/relShow")
	public String relShow() {
		return "sale/releaseShow";
	}
	
	//출고 전체 조회
	@RequestMapping("/entRelease")
	@ResponseBody
	public List<ReleaseVO> entReleaseAjax(){
		List<ReleaseVO> entRelList = releaseService.entRelease();
		return entRelList;
	}
	
	//출고 조회
	@RequestMapping("/releaseCheck")
	@ResponseBody
	public List<ReleaseVO> releaseCheckAjax(ReleaseVO rvo){
		List<ReleaseVO> rclist = releaseService.releaseCheck(rvo);
		return rclist;
	}
	
	//품목 검색
	@RequestMapping("/relItemSearch")
	@ResponseBody
	public List<ReleaseVO> relItemSearchAjax(@RequestParam String itemName){
		List<ReleaseVO> islist = releaseService.relItemSearch(itemName);
		return islist;
	}
	
	//거래처 검색
	@RequestMapping("/relCustSearch")
	@ResponseBody
	public List<ReleaseVO> relCustSearchAjax(@RequestParam String customerName){
		List<ReleaseVO> iclist = releaseService.relCustSearch(customerName);
		return iclist;
		
	}
	
	//출고상세조회
	@RequestMapping("/relDetCheck")
	@ResponseBody
	public List<ReleaseVO> relDetCheckAjax(@RequestParam String fnReleaseId){
		List<ReleaseVO> rdlist = releaseService.relDetCheck(fnReleaseId);
		return rdlist;
	}
	
}

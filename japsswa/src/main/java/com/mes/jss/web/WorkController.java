package com.mes.jss.web;



import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.production.domain.SearchVO;
import com.mes.jss.production.domain.WorkDatasVO;
import com.mes.jss.production.domain.WorkVO;
import com.mes.jss.production.service.WorkService;

import lombok.extern.log4j.Log4j2;



@Controller
@Log4j2
public class WorkController {
	
	@Autowired WorkService workService;

	@RequestMapping("/workManage")
	public String workManagement(){
		return "production/workManage";
	}
	
	
	// 작업지시 등록.
	// 공통 및 세부사항 등록.
	@RequestMapping("/workSaveAjax")
	@ResponseBody
	public void workSaveAjax(@RequestBody WorkDatasVO data, Principal principal) {
		WorkVO head = data.getHead();
		head.setEmpNo(Long.parseLong(principal.getName()));
		
		List<WorkVO> detailList = data.getDetailList();
		workService.workSave(head, detailList);
	}
	
	
	// 작업지시 조회 모달창 : 초기값 
	// 현재 날짜를 기준으로 일주일동안의 작업지시 조회 - 현재 날짜 포함, 현잰 날짜 전후로 3일
	@RequestMapping("/modalWorkListAjax")
	@ResponseBody
	public List<WorkVO> modalWorkListAjax(){
		List<WorkVO> inputData = new ArrayList<>();
		inputData = workService.workResult();
		System.err.println(inputData);
		return inputData;
	}
	
	
	// 작업지시 조회 모달창 : 검색 결과 
	// 두 날짜 사이의 작업지시 내역 조회
	@RequestMapping("/workSearchResultAjax")
	@ResponseBody
	public List<WorkVO> workSearchResultAjax(SearchVO vo){
		List<WorkVO> inputData = new ArrayList<>();
		inputData = workService.workSearchResult(vo);
		
		return inputData;
	}
	
	
	// 작업지시 관리 페이지 : 작업지시 세부내용 그리드에 입력
	// 작업지시 모달창에서 선택한 작업지시의 세부내용
	@RequestMapping("/workSelectDetailAjax")
	@ResponseBody
	public List<WorkVO> workSelectDetailAjax(String workId){
		List<WorkVO> inputData = new ArrayList<>();
		inputData = workService.workSelectDetail(workId);
		
		System.out.println(inputData);
		
		return inputData;
	}
	
	
	
	// 작업지시 관리 페이지 : 제품별 BOM 및 공정 정보 조회
	// 제품명 더블클릭 -> 제품의 BOM 및 공정 정보 리스트
	@RequestMapping("/itemBomInfoAjax")
	@ResponseBody
	public List<WorkVO> itemBomInfoAjax(String ingCode, String itemType) {
		List<WorkVO> inputData = new ArrayList<>();
		inputData = workService.itemBomInfo(ingCode, itemType);
		
		return inputData;
	}
	
	// 작업지시 삭제
	// 공통 및 세부사항 삭제
	@RequestMapping("/workDeleteAjax")
	@ResponseBody
	public boolean workDeleteAjax(String workId) {
		boolean result = workService.workDelete(workId);

		return result;
	}
	
	
	// 작업지시 수정 
	// 공통 및 세부사항 수정
	@RequestMapping("/workModifyAjax")
	@ResponseBody
	public void workModifyAjax(@RequestBody WorkDatasVO data, Principal principal) {
		WorkVO head = data.getHead();
		head.setEmpNo(Long.parseLong(principal.getName()));
		System.err.println(data);
		List<WorkVO> detailList = data.getDetailList();
		workService.workModify(head, detailList);	
	}
	
	
	// 홀드 자재 선택 모달창 : 자재 리스트
	// BOM정보 그리드에서 선택한 자재 리스트 출력.
	@RequestMapping("/selectHoldMaterialAjax")
	@ResponseBody
	public List<WorkVO> selectHoldMaterialAjax(String itemCode){
		List<WorkVO> inputData = workService.selectHoldMaterial(itemCode);
		
		return inputData;
		
	}
	
	
}

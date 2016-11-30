package com.delivery.rocket.corp.facility.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.corp.facility.dto.FacilityDto;
import com.delivery.rocket.corp.facility.service.DeleteFacility;
import com.delivery.rocket.corp.facility.service.InsertFacility;
import com.delivery.rocket.corp.facility.service.ListFacility;
import com.delivery.rocket.corp.facility.service.ListFacility2;
import com.delivery.rocket.corp.facility.service.ListFacility3;
import com.delivery.rocket.corp.facility.service.UpdateFacility;
@Controller
@SessionAttributes("facilityinfo")
public class FacilityController {

	@Autowired // 목록
	ListFacility listFacility = null;

	@Autowired // 세부목록
	ListFacility2 listFacility2 = null;

	@Autowired // 리스트 내 검색
	ListFacility3 listFacility3 = null;

	@Autowired // 검색
	InsertFacility insertFacility = null;

	@Autowired // 삭제
	DeleteFacility deleteFacility = null;

	@Autowired // 수정
	UpdateFacility updateFacility = null;

	// 메인
	@RequestMapping(value = "/main.facility")
	public String MainPage() {
		return "./CorpMenu/main";
	}

	// list페이지 이동
	@RequestMapping(value = "/list.facility")
	public ModelAndView listPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./CorpMenu/main");
		modelAndView.addObject("menu", "list");
		return modelAndView;
	}

	// insert페이지 이동
	@RequestMapping(value = "/insert.facility")
	public ModelAndView insertPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./CorpMenu/main");
		modelAndView.addObject("menu", "insert");
		return modelAndView;
	}

	// update페이지 이동
	@RequestMapping(value = "/update.facility")
	public ModelAndView updatePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./CorpMenu/main");
		modelAndView.addObject("menu", "update");
		return modelAndView;
	}

	// delete페이지 이동
	@RequestMapping(value = "/delete.facility")
	public ModelAndView deletePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./CorpMenu/main");
		modelAndView.addObject("menu", "delete");
		return modelAndView;
	}

	@RequestMapping(value = "/centerleft.facility")
	public String centerleftPage() {
		return "./CorpMenu/centerleft";
	}

	// 삽입 뷰
	@RequestMapping(value = "/FacilityInsertView.facility")
	public String ListPage() {
		return "./CorpMenu/FacilityInsertView";
	}

	// 목록

	@RequestMapping("/ListFacility.facility")
	public ModelAndView doList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		FacilityDto facilityDto = new FacilityDto();
		modelAndView = listFacility.execute(facilityDto, request, response);
		modelAndView.setViewName("./CorpMenu/FacilityListView");
		return modelAndView;
	}

	//////////

	// 눌렀을 시 세부 목록

	@RequestMapping("/ListFacility2.facility")
	public ModelAndView doList2(@RequestParam("f_id") String f_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		FacilityDto facilityDto = new FacilityDto();
		facilityDto.setF_id(f_id);
		modelAndView = listFacility2.execute(facilityDto, request, response);
		modelAndView.setViewName("./CorpMenu/FacilityListDetail");
		return modelAndView;
	}

	//////////

	// 리스트에서 검색하는것 목록

	@RequestMapping("/ListFacility3.facility")
	public ModelAndView doList3(@RequestParam("keyword") String keyword, @RequestParam("keyfield") String keyfield,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		FacilityDto facilityDto = new FacilityDto();
		facilityDto.setKeyfield(keyfield);
		facilityDto.setKeyword(keyword);
		System.out.println(facilityDto.getKeyword());
		System.out.println(facilityDto.getKeyfield());
		modelAndView = listFacility3.execute(facilityDto, request, response);
		modelAndView.setViewName("./CorpMenu/FacilityListView");
		return modelAndView;
	}

	//////////

	// 삽입
	@RequestMapping("/InsertFacility.facility")
	public ModelAndView doInsert(@RequestParam("f_id") String f_id, @RequestParam("f_name") String f_name,
			@RequestParam("f_address") String f_address, @RequestParam("f_tel") String f_tel,
			@RequestParam("f_gps") String f_gps, @RequestParam("manager_id") String manager_id,
			@RequestParam("f_kind_id") String f_kind_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		FacilityDto facilityDto = new FacilityDto();
		facilityDto.setF_id(f_id);
		facilityDto.setF_name(f_name);
		facilityDto.setF_address(f_address);
		facilityDto.setF_tel(f_tel);
		facilityDto.setF_gps(f_gps);
		facilityDto.setManager_id(manager_id);
		facilityDto.setF_kind_id(f_kind_id);
		modelAndView.setViewName("/CorpMenu/FacilityInsertView");
		modelAndView = insertFacility.execute(facilityDto, request, response);
		return modelAndView;
	}

	// 삭제 뷰
	@RequestMapping(value = "/FacilityDeleteView.facility")
	public String DeletePage() {
		return "./CorpMenu/FacilityDeleteView";
	}

	// 삭제
	@RequestMapping("/DeleteFacility.facility")
	public ModelAndView doDelete(@RequestParam("f_id") String f_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		FacilityDto facilityDto = new FacilityDto();
		facilityDto.setF_id(f_id);
		modelAndView = deleteFacility.execute(facilityDto, request, response);
		return modelAndView;
	}

	// 수정 뷰
	@RequestMapping(value = "/FacilityUpdateView.facility")
	public String UpdatePage() {
		return "./CorpMenu/FacilityUpdateView";
	}

	// 수정
	@RequestMapping("/UpdateFacility.facility")
	public ModelAndView doUpdate(@RequestParam("f_id") String f_id, @RequestParam("f_name") String f_name,
			@RequestParam("f_address") String f_address, @RequestParam("f_tel") String f_tel,
			@RequestParam("f_gps") String f_gps, @RequestParam("manager_id") String manager_id,
			@RequestParam("f_kind_id") String f_kind_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		FacilityDto facilityDto = new FacilityDto();
		facilityDto.setF_id(f_id);
		facilityDto.setF_name(f_name);
		facilityDto.setF_address(f_address);
		facilityDto.setF_tel(f_tel);
		facilityDto.setF_gps(f_gps);
		facilityDto.setManager_id(manager_id);
		facilityDto.setF_kind_id(f_kind_id);
		modelAndView = updateFacility.execute(facilityDto, request, response);
		return modelAndView;
	}

}

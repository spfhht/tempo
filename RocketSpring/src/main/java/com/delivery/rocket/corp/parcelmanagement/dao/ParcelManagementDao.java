package com.delivery.rocket.corp.parcelmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.delivery.rocket.corp.parcelmanagement.dto.ParcelManagementDto;

@Repository
public interface ParcelManagementDao {

	// 수화물 개수 
	int getListCount(String id);

	// 수화물 리스트
	List<ParcelManagementDto> getParcelList(int page, int limit, String id);

	// 수화물 상세 정보
	ParcelManagementDto getDetail(String manager_id, String delivery_id);

	// 수화물 배송상태 변경
	void updateDelState(String delivery_id, String del_state_id);

	// 수화물의 회사 아이디 (본인 회사 수화물만 가져오기)
	ParcelManagementDto getCorpId(String manager_id);

	// 가져올때 수화물 있나 없나
	ParcelManagementDto isParcel(String delivery_id);

	// 수화물 가져오기
	boolean parcelBring(String delivery_id, String manager_id);

	// 검색한 수화물 개수
	int getSearchListCount(String keyword, String keyfield, String id);

	// 검색한 수화물 리스트 
	List<ParcelManagementDto> getSearchList(String keyword, String keyfield, int page, int limit, String id);
}

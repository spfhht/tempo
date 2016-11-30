package com.delivery.rocket.corp.parcelmanagement.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.rocket.corp.parcelmanagement.dao.ParcelManagementDao;
import com.delivery.rocket.corp.parcelmanagement.dto.ParcelManagementDto;

@Service
public class ParcelManagementService implements ParcelManagementDao {

	@Autowired
	SqlSession sqlSession = null;
	private HashMap<String, Object> valueMap = new HashMap<String, Object>();

	@Override
	public int getListCount(String id) {
		// TODO Auto-generated method stub
		valueMap.put("manager_id", id);
		return (Integer) sqlSession.selectOne("parcelmanagement.getListCount", valueMap);
	}

	

	@Override
	public ParcelManagementDto getDetail(String manager_id, String delivery_id) {
		// TODO Auto-generated method stub
		valueMap.put("manager_id", manager_id);
		valueMap.put("delivery_id", delivery_id);
		return sqlSession.selectOne("parcelmanagement.getDetail", valueMap);
	}

	@Override
	public void updateDelState(String delivery_id, String del_state_id) {
		valueMap.put("delivery_id", delivery_id);
		valueMap.put("del_state_id", del_state_id);
		sqlSession.update("parcelmanagement.parcelDelStateUpdate", valueMap);
	}

	@Override
	public ParcelManagementDto getCorpId(String manager_id) {
		System.out.println(manager_id);
		return sqlSession.selectOne("parcelmanagement.getCorpId", manager_id);

	}

	@Override
	public ParcelManagementDto isParcel(String delivery_id) {

		return sqlSession.selectOne("parcelmanagement.isParcel", delivery_id);
	}

	@Override
	public boolean parcelBring(String delivery_id, String manager_id) {
		valueMap.put("delivery_id", delivery_id);
		valueMap.put("manager_id", manager_id);

		sqlSession.update("parcelmanagement.parcelmanageUpdate", valueMap);
		sqlSession.update("parcelmanagement.parcelatUpdate", valueMap);
		return false;
	}

	
	
	@Override
	public int getSearchListCount(String type, String keyword, String id) {
		valueMap.put("type", type);
		valueMap.put("keyword", keyword);
		valueMap.put("manager_id", id);
		return (Integer) sqlSession.selectOne("parcelmanagement.getSearchListCount", valueMap);
	}
	
	@Override
	public List<ParcelManagementDto> getParcelList(int page, int limit, String id) {
		// TODO Auto-generated method stub
		valueMap.put("startrow", page);
		valueMap.put("endrow", limit);
		valueMap.put("manager_id", id);
		return sqlSession.selectList("parcelmanagement.getParcelList", valueMap);
	}

	@Override
	public List<ParcelManagementDto> getSearchList(String type, String keyword, int page, int limit, String id) {
		// TODO Auto-generated method stub
		valueMap.put("type", type);
		valueMap.put("keyword", keyword);
		valueMap.put("startrow", page);
		valueMap.put("endrow", limit);
		valueMap.put("manager_id", id);
		return sqlSession.selectList("parcelmanagement.getSearchList", valueMap);
	}

}

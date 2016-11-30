package com.delivery.rocket.admin.joincorp.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.rocket.admin.joincorp.dao.JoinCorpDao;
import com.delivery.rocket.admin.joincorp.dto.JoinCorpDto;

@Service
public class JoinCorpService implements JoinCorpDao{

	@Autowired
	SqlSession sqlSession = null;
	private HashMap<String, Object> valueMap = new HashMap<String,Object>();

	
	
	@Override
	public List<JoinCorpDto> getCorpList(int startCorpNum, int endCorpNum) {
		valueMap.put("startCorpNum", startCorpNum);
		valueMap.put("endCorpNum", endCorpNum );
		return sqlSession.selectList("corp.getCorpList",valueMap);
	}

	@Override
	public JoinCorpDto getOneCorp(String c_id) {
		return sqlSession.selectOne("corp.getOneCorp",c_id);
	}

	@Override
	public List<JoinCorpDto> searchCorp(String type, String keyword, int startCorpNum, int endCorpNum) {
		valueMap.put("type", type);
		valueMap.put("keyword", keyword);
		valueMap.put("startCorpNum", startCorpNum);
		valueMap.put("endCorpNum", endCorpNum);
		return sqlSession.selectList("corp.searchCorp",valueMap);
	}


	@Override
	public boolean joinCorp(JoinCorpDto joinCorpDto) {
		sqlSession.insert("corp.joinCorp",joinCorpDto);
		return true;
	}

	@Override
	public void deleteCorp(String c_id) {
		sqlSession.delete("corp.deleteCorp",c_id);
	}

	@Override
	public int getTotalNum() {
		return (Integer) sqlSession.selectOne("corp.getTotalNum");
	}

	@Override
	public int getSearchTotalNum(String type, String keyword) {
		valueMap.put("type", type);
		valueMap.put("keyword", keyword);
		return (Integer) sqlSession.selectOne("corp.getSearchTotalNum",valueMap);
	}

	@Override
	public boolean modifyCorp(JoinCorpDto joinCorpDto) {
		
		System.out.println("test");
		sqlSession.update("corp.modifyCorp",joinCorpDto);
		return true;
	}

}

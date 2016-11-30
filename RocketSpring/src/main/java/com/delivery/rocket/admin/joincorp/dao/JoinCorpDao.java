package com.delivery.rocket.admin.joincorp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.delivery.rocket.admin.joincorp.dto.JoinCorpDto;

@Repository
public interface JoinCorpDao {
	
	List<JoinCorpDto> getCorpList(int startCorpNum, int endCorpNum);

	JoinCorpDto getOneCorp(String c_id) ;

	List<JoinCorpDto> searchCorp(String type, String keyword, int startCorpNum, int endCorpNum);
	
	boolean joinCorp(JoinCorpDto joinCorpDto);

	void deleteCorp(String c_id);

	int getTotalNum();

	int getSearchTotalNum(String type, String keyword);
	
	boolean modifyCorp(JoinCorpDto joinCorpDto);
	

}

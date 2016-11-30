package com.delivery.rocket.qna.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.delivery.rocket.qna.dto.QnADTO;

@Repository
public class QnADAO {
	private static final String namespaces = "mapper.qna";
	@Autowired
	SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	public int getListCount(QnADTO qnaDTO) {
		qnaDTO.setC_id("%" + qnaDTO.getC_id() + "%");
		return template.selectOne(namespaces + ".listCount", qnaDTO);
	}

	public List<QnADTO> getBoardList(QnADTO qnaDTO) {
		qnaDTO.setC_id("%" + qnaDTO.getC_id() + "%");
		return template.selectList(namespaces + ".boardList", qnaDTO);
	}

	public List<QnADTO> getCorpList() {
		return template.selectList(namespaces + ".corpList");
	}

	public boolean isBoardWriter(QnADTO qnaDTO) {
	QnADTO qnaDTO2 = template.selectOne(namespaces + ".boardWriter", qnaDTO);
	if (qnaDTO.getM_group() != null) {
		if (qnaDTO.getM_group().equals("0")) {
			System.out.println("tnehd1");
			return true;
		} else {
			if (qnaDTO.getQ_pwd().equals(qnaDTO2.getQ_pwd())) {
				System.out.println("tnehd2");
				return true;
			}
		}
	} else {
		if (qnaDTO.getQ_pwd().equals(qnaDTO2.getQ_pwd())) {
			System.out.println("tnehd3");
			return true;
		}
	} 
	System.out.println("tnehd4");
	return false; 
	}

	public boolean boardDelete_Admin(QnADTO qnaDTO) {
		int result = template.delete(namespaces + ".boardDelete_admin", qnaDTO);
		if (result==0) {
			return false;
		}
		return true;
	}

	public boolean boardDelete(QnADTO qnaDTO) {
		int result = template.delete(namespaces + ".boardDelete");
		if (result==0) {
			System.out.println("김제우1");
			return false;
		}
		System.out.println("김제우2");
		return true;
	}
	
	public boolean setBoardInsert(QnADTO qnaDTO) {
		int result = template.insert(namespaces + ".boardInsert", qnaDTO);
		if (result==0) {
			return false;
		}
		return true;
	}
	
	public boolean setBoardInsert_corp(QnADTO qnaDTO) {
		int result = template.insert(namespaces + ".boardInsert_corp", qnaDTO);
		if (result==0) {
			return false;
		}
		return true;
	}

	public QnADTO setReadCountUpdate(int q_id) {
		return template.selectOne(namespaces + ".readCountUpdate", q_id);
	}

	public QnADTO getDetail(int q_id) {
		return template.selectOne(namespaces + ".detail", q_id);
	}

	public List<QnADTO> getReply(int q_id) {
		return template.selectOne(namespaces + ".reply", q_id);
	}

	public int getQid() {
		String result = template.selectOne(namespaces + ".qid");
		if (result != null) {
			return Integer.parseInt(result) + 1;
		}
		return 1;
	}
	public boolean boardModify(QnADTO qnaDTO) {
		template.update(namespaces + ".boardModify", qnaDTO);
		return false;
	}

	// public List<BoardCommand> showListBoard(BoardCommand boardCommand) {
	// return sqlSessionTemplate.selectList("showList");
	// }
}

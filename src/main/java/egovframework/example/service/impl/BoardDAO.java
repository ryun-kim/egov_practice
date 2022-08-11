package egovframework.example.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.service.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAO {

	@Resource(name="sqlSession")
	private SqlSession query;
	
	
	public List<BoardVO> boardList(BoardVO searchVO) {
		return query.selectList("boardList", searchVO);
	}


	public BoardVO detailBoard(BoardVO searchVO) {
		return query.selectOne("detailBoard",searchVO);
	}
	
	public int insertBoard(BoardVO searchVO) {
		return query.insert("insertBoard", searchVO);		
	}


	public int updBoard(BoardVO searchVO) {
		return query.update("updBoard", searchVO);
	}


	public int delBoard(BoardVO searchVO) {		
		return query.delete("delBoard",searchVO);
	}

}

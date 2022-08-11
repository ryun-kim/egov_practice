package egovframework.example.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.service.BoardService;
import egovframework.example.service.vo.BoardVO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	@Resource(name="boardDAO")
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> boardList(BoardVO searchVO){
		return dao.boardList(searchVO);
	}

	
	public int insertBoard(BoardVO searchVO ) {
		return dao.insertBoard(searchVO);
	}
	
	@Override
	public BoardVO detailBoard(BoardVO searchVO) {
		return dao.detailBoard(searchVO);
	}

	@Override
	public int updBoard(BoardVO searchVO) {return dao.updBoard(searchVO);}
	
	@Override
	public int delBoard(BoardVO searchVO) {return dao.delBoard(searchVO);}
}

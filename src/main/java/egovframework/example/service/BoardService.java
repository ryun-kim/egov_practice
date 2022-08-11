package egovframework.example.service;

import java.util.List;

import egovframework.example.service.vo.BoardVO;

public interface BoardService {

	List<BoardVO> boardList(BoardVO searchVO);

	int insertBoard(BoardVO searchVO);
	
	BoardVO detailBoard(BoardVO searchVO);

	int updBoard(BoardVO searchVO);
	
	int delBoard(BoardVO searchVO);

}

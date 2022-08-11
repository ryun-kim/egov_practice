package egovframework.example.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import egovframework.example.service.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	public List<BoardVO>boardList(BoardVO searchVO);
	
	public int insertBoard(BoardVO searchVO);

	public BoardVO detailBoard(BoardVO searchVO);
	
	public int updBoard(BoardVO searchVO);
	
	public int delBoard(BoardVO searchVO);
}

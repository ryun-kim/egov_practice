package egovframework.example.service.impl;

import java.util.List;

import egovframework.example.service.Criteria;
import egovframework.example.service.vo.DeptVO;
import egovframework.example.service.vo.PaginationVO;
import egovframework.example.service.vo.PosVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("posMapper")
public interface PosMapper {
	
	int insPos(DeptVO vo); //직원 등록
	
	List<DeptVO> selPosList(); //직원 리스트
	PosVO seldetail(DeptVO vo); //직원 디테일
	
	int updPos(DeptVO vo); //직원정보 수정
	
	int delPos(DeptVO vo); //직원목록 삭제
	
	int getTotal(Criteria cri);
	
	List<DeptVO> selectBoard(Criteria cri);
}

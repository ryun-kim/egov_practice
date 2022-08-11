package egovframework.example.service;

import java.util.List;

import egovframework.example.service.vo.DeptVO;

public interface PosService {

	List<DeptVO> selPosList();

	DeptVO seldetail(DeptVO vo);
	
	int insPos(DeptVO vo);
	
	int delPos(DeptVO vo);

	int updPos(DeptVO vo);

	List<DeptVO> getList(Criteria cri);
	
	int getTotal(Criteria cri);

}

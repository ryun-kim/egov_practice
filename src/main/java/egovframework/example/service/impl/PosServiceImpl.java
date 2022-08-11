package egovframework.example.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.service.Criteria;
import egovframework.example.service.PosService;
import egovframework.example.service.vo.DeptVO;
import egovframework.example.service.vo.PaginationVO;

@Service("posService")
public class PosServiceImpl implements PosService{
	
		
	@Resource(name="posDAO")
	private PosDAO dao;
	
	public int insPos(DeptVO vo) {return dao.insPos(vo);} //삽입
	
	@Override
	public List<DeptVO> selPosList(){return dao.selPosList();} //리스트조회
	
	
	
	@Override
	public DeptVO seldetail(DeptVO vo) {return dao.seldetail(vo);} //디테일 조회
	
	@Override
	public int updPos(DeptVO vo) {return dao.updPos(vo);} //수정
	
	@Override
	public int delPos(DeptVO vo) {return dao.delPos(vo);} //삭제
	
	
	
	@Override
	public List<DeptVO> getList(Criteria cri){return dao.getList(cri);}
	
	@Override
	public int getTotal(Criteria cri) {return dao.getTotal(cri);}

}

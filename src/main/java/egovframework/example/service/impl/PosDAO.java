package egovframework.example.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.service.Criteria;
import egovframework.example.service.vo.DeptVO;
import egovframework.example.service.vo.PaginationVO;
import egovframework.example.service.vo.PosVO;

@Repository("posDAO")
public class PosDAO {
	
	@Resource(name="sqlSession")
	private SqlSession query;
	
	public int insPos(PosVO vo) {return query.insert("insPos", vo);}
	
	public List<DeptVO> selPosList(){return query.selectList("selPosList");}
	
	public DeptVO seldetail(DeptVO vo) {return query.selectOne("seldetail", vo);}

	public int updPos(DeptVO vo) {return query.update("updPos", vo);}
	
	public int delPos(DeptVO vo) {return query.delete("delPos", vo);}

	
	
	List<DeptVO> getList(Criteria cri) {return query.selectList("getList", cri);}
	int getTotal(Criteria cri) {return query.selectOne("getTotal", cri);}
	
}


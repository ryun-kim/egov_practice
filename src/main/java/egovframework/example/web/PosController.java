package egovframework.example.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.service.Criteria;
import egovframework.example.service.PosService;
import egovframework.example.service.vo.DeptVO;
import egovframework.example.service.vo.PageVO;
import egovframework.example.service.vo.PaginationVO;

@Controller
public class PosController {
	
	@Resource(name="posService")
	private PosService service;
	
	@RequestMapping("/list.do") //직원 리스트
	public String posList(Model model) {
		model.addAttribute("list",service.selPosList());
		System.out.println("리스트 호출");
		return "list";
	}
	
	@RequestMapping(value="/pagingList.do",method=RequestMethod.GET)
	public String pagingList(Model model, Criteria cri) {
		PageVO pageVO = new PageVO(cri, service.getTotal(cri));
		List<DeptVO> dept = service.getList(cri);
		System.out.println("페이지넘버 =" + cri.getPageNum() );
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("dept", dept);
		System.out.println("페이징 처리 리스트 호출");
		return "pagingList";
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String detail(HttpServletRequest request, DeptVO vo, ModelMap model) {
		String posNo = request.getParameter("posNum");
		int posPkInt = Integer.parseInt(posNo);
		DeptVO deptVO = new DeptVO();
		deptVO.setPOS_NUM(posPkInt);
		model.addAttribute("posVo", service.seldetail(deptVO));
		System.out.println("vo에 들어오는 값!!"+ posPkInt);
		return "detail";
	}
	
	@RequestMapping(value="/write.do", method = RequestMethod.GET) //글쓰기 화면 조회
	public String write() {
		System.out.println("등록화면 호출");
		return "write";
	}
	
	@RequestMapping(value="/write.do", method = RequestMethod.POST) // 글 등록
	public String writePos(DeptVO vo, Model model) {
		service.insPos(vo);	
		model.addAttribute("result",vo);
		System.out.println("등록 포스트 보내기");
		return "redirect:/list.do";
	}
	
	@RequestMapping(value="/mod.do", method = RequestMethod.GET) //글 수정 화면
	public String mod(HttpServletRequest request, Model model, DeptVO vo) {
		String posNo = request.getParameter("posNum");
		int posPkInt = Integer.parseInt(posNo);
		DeptVO deptVO = new DeptVO();
		deptVO.setPOS_NUM(posPkInt);		
		model.addAttribute("PosVo",service.seldetail(deptVO));
		System.out.println("수정화면 호출"+ posPkInt);
		return "mod";
	}
	
	@RequestMapping(value="/mod.do", method = RequestMethod.POST) //글 수정
	public String modPos(DeptVO vo, Model model) {	
		System.out.println("========================================vo : "+vo);
		service.updPos(vo);		
		System.out.println("수정  완료 값:" + vo.getPOS_NUM());
		return "redirect:/detail.do?posNum="+ vo.getPOS_NUM();
	}
	
	
	@RequestMapping(value="/del.do", method = RequestMethod.GET) //글 삭제
	public String delPos(HttpServletRequest request, DeptVO vo,ModelMap model ) {
		String posNo = request.getParameter("posNum");
		int posPkInt = Integer.parseInt(posNo);
		DeptVO deptVO = new DeptVO();
		deptVO.setPOS_NUM(posPkInt);		
		model.addAttribute("posVo", service.delPos(deptVO));		
		System.out.println("글 삭제 성공 !" + deptVO.getPOS_NUM());
		return "redirect:/list.do";
	}
	
	
}

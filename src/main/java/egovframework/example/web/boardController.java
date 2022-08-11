package egovframework.example.web;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import egovframework.example.service.BoardService;
import egovframework.example.service.vo.BoardVO;

@Controller
public class boardController {
	
	@Autowired
	private BoardService service;

	@RequestMapping(value = "/board/create.do", method =RequestMethod.GET) //글쓰기  화면호출
	public String create(@ModelAttribute("searchVO") BoardVO searchVO, Model model) {
		return "/board/create";
	}
	
	@RequestMapping(value = "/board/create_action.do", method=RequestMethod.POST) //글 등록
	public String create_action(@ModelAttribute("searchVO") BoardVO searchVO, RedirectAttributes redirect) {
		System.out.println("글등록 호출");
		try {
			SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
			Date time = new Date();
			String time1 = format1.format(time);
			searchVO.setBoard_regdate(time1);
			service.insertBoard(searchVO);
			redirect.addFlashAttribute("redirect", searchVO.getBoard_idx());
			redirect.addFlashAttribute("msg", "등록이 완료되었습니다.");
		}catch (Exception e) {
			redirect.addFlashAttribute("msg", "등록 오류가 발생하였습니다.");
		}
		
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/board/read.do", method = RequestMethod.GET)
	public String read(@ModelAttribute("searchVO") BoardVO searchVO,@RequestParam("board_idx") int board_idx, Model model) {
		System.out.println("게시글 디테일 번호:" + board_idx);
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_idx(board_idx);
		model.addAttribute("detailBoard",service.detailBoard(boardVo));
		return "/board/read";
	}
	
	
	@RequestMapping(value = "/board/list.do", method = RequestMethod.GET) //리스트
	public String list(@ModelAttribute("searchVO") BoardVO searchVO,HttpServletRequest request, Model model) {
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
	    if(null != inputFlashMap) {
	    	
	    	model.addAttribute("msg",(String) inputFlashMap.get("msg"));
	    	
	    }
		
		List<BoardVO> boardList = service.boardList(searchVO);
		
		model.addAttribute("boardList",boardList);
		
		System.out.println("보드리스트");
		return "/board/list";
	}
	

	@RequestMapping(value="/board/update.do", method=RequestMethod.GET) //수정화면
	public String update(@ModelAttribute("searchVO") BoardVO searchVO,@RequestParam("board_idx") int board_idx, Model model) {
		System.out.println("수정게시글 번호:"+ board_idx);
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_idx(board_idx);
		model.addAttribute("detailBoard",service.detailBoard(boardVo));
		
		return "/board/update";
	}
	
	@RequestMapping(value="/board/update_action.do", method = RequestMethod.POST)
	public String update_action(@ModelAttribute("searchVO") BoardVO searchVO, HttpServletRequest request, RedirectAttributes redirect, Model model) {
	
		try {
			service.updBoard(searchVO);
			redirect.addFlashAttribute("redirect", searchVO.getBoard_idx());
			redirect.addFlashAttribute("msg", "수정이 완료되었습니다.");
		}catch(Exception e) {
			redirect.addFlashAttribute("msg", "수정하는데에 오류가 발생하였습니다.");
		}
		return "redirect:/board/read.do?board_idx=" + searchVO.getBoard_idx();
	}
	
	@RequestMapping(value="/board/delete.do", method=RequestMethod.GET)
	public String delete(@ModelAttribute("searchVO") BoardVO searchVO, @RequestParam("board_idx") int board_idx, RedirectAttributes redirect , Model model) {
		System.out.println("삭제번호:"+ board_idx);
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_idx(board_idx);
		try {
			service.delBoard(boardVo);
			redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");
		}catch(Exception e) {
			redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
		}
		return "redirect:/board/list.do";
	}
	
}

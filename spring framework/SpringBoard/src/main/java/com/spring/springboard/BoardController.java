package com.spring.springboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//클래스 내부에 다 적용됨. board.do하면 클래스 BoardController가 호출
@RequestMapping("/board.do")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
//특정 파라미터값으로 찾는 방식..많이 안쓰임	
	@RequestMapping(params="method=addBoardForm")
	public String addBoardForm() throws Exception {
		return "addBoardForm";
	}
	
	@RequestMapping(params="method=addBoard")
	public String addBoard(BoardVO boardVO) throws Exception {
		boardService.addBoard(boardVO);
		return "redirect:/board.do?method=getBoardList";
	}
//글 수정할 때 폼양식에 출력하는데 사용	
	@RequestMapping(params="method=updateBoardForm")
	public String updateBoardForm(BoardVO boardVO, Model model) throws Exception {
		BoardVO vo= boardService.getBoard(boardVO);
		model.addAttribute("boardVO", vo);
		return "updateboardform"; //뷰 : updateform.jsp를 의미
	}
	
	@RequestMapping(params="method=updateBoard")
	public String updateBoard(BoardVO boardVO) throws Exception {
		boardService.updateBoard(boardVO);
		return "redirect:/board.do?method=getBoardList";
	}
	
	@RequestMapping(params="method=deleteBoard")
	public String deleteBoard(BoardVO boardVO) throws Exception {
		boardService.deleteBoard(boardVO);
		return "redirect:/board.do?method=getBoardList";
	}
	
	@RequestMapping(params="method=getBoard")
	public String getBoard(BoardVO boardVO, Model model) throws Exception {
		BoardVO vo= boardService.getBoard(boardVO);
		model.addAttribute("boardVO", vo);
		return "getboard";
	}
	
	@RequestMapping(params="method=getBoardList")
	public String getBoardList(BoardVO boardVO, Model model) throws Exception {
		ArrayList<BoardVO> boardList= boardService.getBoardList(boardVO);
		model.addAttribute("boardList", boardList);
		return "getboardlist";
	}

}

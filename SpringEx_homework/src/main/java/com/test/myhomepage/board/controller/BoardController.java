package com.test.myhomepage.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.myhomepage.board.dto.BoardDto;
import com.test.myhomepage.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board/list")
	public ModelAndView list(){
		ModelAndView mView=boardService.getList();
		mView.setViewName("board/list");
		return mView;
	}
	
	@RequestMapping("/board/detail")
	public ModelAndView boardDetail(@RequestParam int num){
		ModelAndView mView=boardService.getData(num);
		boardService.increaseViewCount(num);
		mView.setViewName("board/detail");
		return mView;
	}
	
	@RequestMapping("/board/private/insertform")
	public ModelAndView boardInsertForm(){
		return new ModelAndView("board/private/insertform");
	}
	@RequestMapping("/board/private/insert")
	public ModelAndView boardInsert(HttpServletRequest request){
		String writer=request.getParameter("writer");
		String title=request.getParameter("title");
		String content=request.getParameter("ir1");
		BoardDto dto=new BoardDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		boolean isSuccess=boardService.insert(dto);
		String alertMess="";
		String redirectUri=request.getContextPath()+"/board/list.do";
		if(isSuccess){
			alertMess="글 등록이 성공 했습니다.";
		}else{
			alertMess="글 등록이 실패 했습니다.";
			redirectUri=request.getContextPath()+"/board/private/insertform.do";
		}
		ModelAndView mView=new ModelAndView();
		
		mView.addObject("alertMess", alertMess);
		mView.addObject("redirectUri", redirectUri);
		mView.setViewName("alert");		
		return mView;		

	}
	@RequestMapping("/board/private/updateform")
	public ModelAndView boardUpdateForm(@RequestParam int num){
		ModelAndView mView=boardService.getData(num);
		mView.setViewName("board/private/updateform");
		return mView;
	}
	
	@RequestMapping("/board/private/update")
	public ModelAndView boardUpdate(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		String title=request.getParameter("title");
		String content=request.getParameter("ir1");
		BoardDto dto=new BoardDto();
		dto.setNum(num);
		dto.setTitle(title);
		dto.setContent(content);
		boolean isSuccess=boardService.update(dto);
		String alertMess="";
		String redirectUri=request.getContextPath()+"/board/detail.do?num="+num;
		if(isSuccess){
			alertMess="글 수정이 성공 했습니다.";
		}else{
			alertMess="글 수정이 실패 했습니다.";
		}
		ModelAndView mView=new ModelAndView();
		
		mView.addObject("alertMess", alertMess);
		mView.addObject("redirectUri", redirectUri);
		mView.setViewName("alert");		
		return mView;		
	}
	@RequestMapping("/board/private/delete")
	public ModelAndView boardDelete(HttpServletRequest request, @RequestParam int num){
		boolean isSuccess=boardService.delete(num);
		String alertMess="";
		String redirectUri=request.getContextPath()+"/board/list.do";
		if(isSuccess){
			alertMess="글 삭제를 성공 했습니다.";
		}else{
			alertMess="글 삭제를 실패 했습니다.";
		}
		ModelAndView mView=new ModelAndView();
		
		mView.addObject("alertMess", alertMess);
		mView.addObject("redirectUri", redirectUri);
		mView.setViewName("alert");		
		return mView;
	}
}

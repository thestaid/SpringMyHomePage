package com.test.myhomepage.board.service;

import org.springframework.web.servlet.ModelAndView;

import com.test.myhomepage.board.dto.BoardDto;

public interface BoardService {
	public ModelAndView getList();
	public int getCount(BoardDto dto);
	public boolean insert(BoardDto dto);
	public ModelAndView getData(int num);
	public void increaseViewCount(int num);
	public boolean update(BoardDto dto);
	public boolean delete(int num);
}

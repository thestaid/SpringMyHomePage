package com.test.myhomepage.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.test.myhomepage.board.dao.BoardDao;
import com.test.myhomepage.board.dto.BoardDto;

@Component
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public ModelAndView getList() {
		List<BoardDto> list=boardDao.getList();
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		return mView;
	}

	@Override
	public int getCount(BoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insert(BoardDto dto) {
		boolean isSuccess=boardDao.insert(dto);
		return isSuccess;
	}

	@Override
	public ModelAndView getData(int num) {
		BoardDto dto=boardDao.getData(num);
		ModelAndView mView=new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}

	@Override
	public void increaseViewCount(int num) {
		boardDao.increaseViewCount(num);
	}

	@Override
	public boolean update(BoardDto dto) {
		boolean isSuccess=boardDao.update(dto);
		return isSuccess;
	}

	@Override
	public boolean delete(int num) {
		boolean isSuccess=boardDao.delete(num);
		return isSuccess;
	}
	
}

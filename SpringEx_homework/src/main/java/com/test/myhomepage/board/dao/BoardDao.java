package com.test.myhomepage.board.dao;

import java.util.List;

import com.test.myhomepage.board.dto.BoardDto;

public interface BoardDao {
	public List<BoardDto> getList();
	public int getCount(BoardDto dto);
	public boolean insert(BoardDto dto);
	public BoardDto getData(int num);
	public void increaseViewCount(int num);
	public boolean update(BoardDto dto);
	public boolean delete(int num);
}

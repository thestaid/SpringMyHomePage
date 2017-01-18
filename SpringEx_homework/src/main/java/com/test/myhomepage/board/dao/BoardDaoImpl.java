package com.test.myhomepage.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.myhomepage.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private SqlSession session;	
	

	@Override
	public List<BoardDto> getList() {
		List<BoardDto> list=session.selectList("board.getList");
		return list;
	}

	@Override
	public int getCount(BoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insert(BoardDto dto) {
		boolean isSuccess=false;
		try{
			session.insert("board.insert", dto);
			isSuccess=true;
		}catch(Exception e){isSuccess=false;}
		return isSuccess;
	}

	@Override
	public BoardDto getData(int num) {
		BoardDto dto=session.selectOne("board.getData", num);
		return dto;
	}

	@Override
	public void increaseViewCount(int num) {
		session.update("board.increaseViewCount", num);
	}

	@Override
	public boolean update(BoardDto dto) {
		boolean isSuccess=false;
		try{
			session.update("board.update", dto);
			isSuccess=true;
		}catch(Exception e){isSuccess=false;}
		return isSuccess;
	}

	@Override
	public boolean delete(int num) {
		boolean isSuccess=false;
		try{
			session.delete("board.delete", num);
			isSuccess=true;
		}catch(Exception e){isSuccess=false;}
		return isSuccess;
	}


}

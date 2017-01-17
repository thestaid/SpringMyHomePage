package com.test.myhomepage.users.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.myhomepage.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public boolean insert(UsersDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	//isValid Start
	@Override
	public boolean isValid(UsersDto dto) {
		UsersDto resultDto=null;
		try{
			resultDto=session.selectOne("users.isValid", dto);
		}catch(Exception e){}
		if(resultDto==null){
			return false;
		}else{
			return false;
		}
	}//isValid END

	@Override
	public UsersDto getData(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsersDto> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(UsersDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}

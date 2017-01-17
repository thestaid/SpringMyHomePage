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
		boolean isSuccess=false;
		try{
			session.insert("users.insert", dto);
			isSuccess=true;
		}catch(Exception e){
			isSuccess=false;
		}
		return isSuccess;
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
			return true;
		}
	}//isValid END

	@Override
	public UsersDto getData(String id) {
		UsersDto dto=null;
		try{
			dto=session.selectOne("users.getData", id);	
		}catch(Exception e){}
		return dto;
	}

	@Override
	public List<UsersDto> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(UsersDto dto) {
		boolean isSuccess=false;
		try{
			session.update("users.update", dto);
			isSuccess=true;
		}catch(Exception e){
			isSuccess=false;
		}
		return isSuccess;
	}

	@Override
	public boolean delete(String id) {
		boolean isSuccess=false;
		try{
			session.update("users.delete", id);
			isSuccess=true;			
		}catch(Exception e){
			isSuccess=false;
		}
		return isSuccess;
	}

}

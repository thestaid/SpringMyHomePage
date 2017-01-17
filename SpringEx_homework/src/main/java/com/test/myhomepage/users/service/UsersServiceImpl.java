package com.test.myhomepage.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.myhomepage.users.dao.UsersDao;
import com.test.myhomepage.users.dto.UsersDto;

@Component
public class UsersServiceImpl implements UsersDao{
	
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public boolean insert(UsersDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid(UsersDto dto) {
		boolean isValid=usersDao.isValid(dto);
		return isValid;
	}

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

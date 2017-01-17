package com.test.myhomepage.users.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.test.myhomepage.users.dao.UsersDao;
import com.test.myhomepage.users.dto.UsersDto;

@Component
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao usersDao;

	@Override
	public boolean insert(HttpServletRequest request, UsersDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid(HttpServletRequest request, UsersDto dto) {
		boolean isValid=usersDao.isValid(dto);
		return isValid;
	}

	@Override
	public ModelAndView getData(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(HttpServletRequest request, UsersDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(HttpServletRequest request, String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}

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
	public boolean insert(UsersDto dto) {
		boolean isSuccess=usersDao.insert(dto);
		return isSuccess;
	}

	@Override
	public boolean isValid(UsersDto dto) {
		boolean isValid=usersDao.isValid(dto);
		return isValid;
	}

	@Override
	public ModelAndView getData(String id) {
		UsersDto dto=usersDao.getData(id);
		ModelAndView mView=new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}

	@Override
	public ModelAndView getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(UsersDto dto) {
		boolean isSuccess=usersDao.update(dto);
		return isSuccess;
	}

	@Override
	public boolean delete(String id) {
		boolean isSucess=usersDao.delete(id);
		return isSucess;
	}
	
	

}

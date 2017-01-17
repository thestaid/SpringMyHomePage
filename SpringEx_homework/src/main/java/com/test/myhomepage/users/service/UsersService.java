package com.test.myhomepage.users.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.test.myhomepage.users.dto.UsersDto;

public interface UsersService {
	public boolean insert(HttpServletRequest request, UsersDto dto);
	public boolean isValid(HttpServletRequest request, UsersDto dto);
	public ModelAndView getData(String id);
	public ModelAndView getList();
	public boolean update(HttpServletRequest request, UsersDto dto);
	public boolean delete(HttpServletRequest request, String id);
}

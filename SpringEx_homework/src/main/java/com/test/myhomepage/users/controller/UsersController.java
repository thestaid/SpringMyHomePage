package com.test.myhomepage.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.myhomepage.users.dto.UsersDto;
import com.test.myhomepage.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/users/signin")
	public ModelAndView isvalid(HttpServletRequest request, @ModelAttribute UsersDto dto){
		boolean isValid=usersService.isValid(dto);
		String alertMess="";
		String redirectUri=request.getContextPath()+"/home.do";
		if(isValid){
			alertMess="로그인 성공 했습니다.";
			request.getSession().setAttribute("id", dto.getId());
		}else{
			alertMess="아이디 혹은 비밀번호가 틀립니다.";
		}
		ModelAndView mView=new ModelAndView();
		
		mView.addObject("alertMess", alertMess);
		mView.addObject("redirectUri", redirectUri);
		mView.setViewName("alert");
		return mView;
	}
	
	@RequestMapping("/users/signupform")
	public ModelAndView signupForm(){
		return new ModelAndView("users/signupform");
	}
	
	@RequestMapping("/users/signup")
	public ModelAndView signup(HttpServletRequest request, @ModelAttribute UsersDto dto){
		boolean isSuccess=usersService.insert(dto);
		String alertMess="";
		String redirectUri=request.getContextPath()+"/home.do";
		if(isSuccess){
			alertMess="회원가입 성공 했습니다.";
		}else{
			alertMess="회원가입 실패 했습니다.";
			redirectUri=request.getContextPath()+"/users/signupform.do";
		}
		ModelAndView mView=new ModelAndView();
		
		mView.addObject("alertMess", alertMess);
		mView.addObject("redirectUri", redirectUri);
		mView.setViewName("alert");		
		return mView;
	}
}

package com.test.myhomepage.users.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping("/users/checkid")
	@ResponseBody
	public Map<String, Object> checkId(@RequestParam String signupId){
		boolean canUse=true;
		ModelAndView mView=usersService.getData(signupId);
		System.out.println(mView.getModel().get("dto"));
		if(mView.getModel().get("dto")!=null){
			canUse=false;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("canUse", canUse);
		return map;		
	}
	
	@RequestMapping("/users/info")
	public ModelAndView userInfo(@RequestParam String id){
		ModelAndView mView=usersService.getData(id);
		mView.setViewName("users/private/info");
		return mView;
	}
	
	@RequestMapping("/users/signout")
	public String signout(HttpServletRequest request){
		request.getSession().removeAttribute("id");
		return "redirect:/home.do";
	}
	@RequestMapping("/users/private/delete")
	public ModelAndView userDelete(HttpServletRequest request, @RequestParam String id){
		boolean isSuccess=usersService.delete(id);
		String alertMess="";
		String redirectUri=request.getContextPath()+"/home.do";
		if(isSuccess){
			alertMess="회원탈퇴 성공 했습니다.";
			request.getSession().removeAttribute("id");
		}else{
			alertMess="회원탈퇴 실패 했습니다.";
			redirectUri=request.getContextPath()+"/users/info.do?id="+id;
		}
		ModelAndView mView=new ModelAndView();
		
		mView.addObject("alertMess", alertMess);
		mView.addObject("redirectUri", redirectUri);
		mView.setViewName("alert");		
		return mView;
	}
	
	@RequestMapping("/users/private/updateform")
	public ModelAndView userUpdateForm(@RequestParam String id){
		ModelAndView mView=usersService.getData(id);
		mView.setViewName("users/private/updateform");
		return mView;
	}
	
	@RequestMapping("/users/private/update")
	public ModelAndView usersUpdate(HttpServletRequest request, @ModelAttribute UsersDto dto){
		boolean isSuccess=usersService.update(dto);
		String alertMess="";
		String redirectUri=request.getContextPath()+"/users/info.do?id="+dto.getId();	
		if(isSuccess){
			alertMess="회원정보 수정 성공 했습니다.";
		}else{
			alertMess="회원정보 수정 실패 했습니다.";
		}
		ModelAndView mView=new ModelAndView();
		
		mView.addObject("alertMess", alertMess);
		mView.addObject("redirectUri", redirectUri);
		mView.setViewName("alert");		
		return mView;		
	}
}

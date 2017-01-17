<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>대문 페이지</title>
<link rel="stylesheet" href='<c:url value="resources/css/bootstrap.css"/>'/>
<script src='<c:url value="/resources/js/jquery-3.1.1.js"/>'></script>
<style>
	.mainSigninForm{width:100%;margin-top:10px;}
</style>
</head>
<body>
	<div class="container">
		<form action="users/signin.do" method="post" style="margin: 0 auto;width:500px;vertical-align: middle; ">
		<h3>SIMPLE HOMEPAGE</h3>
		<p>${id }</p>
			<input type="text" name="id" placeholder="아이디" class="mainSigninForm"/><br/>
			<input type="password" name="pwd" class="mainSigninForm" placeholder="비밀번호"/><br/>
			<button type="submit" class="btn btn-primary mainSigninForm">
				<span class="glyphicon glyphicon-ok"></span> 로그인
			</button><br/>
			<a href="users/signupform.do" class="btn btn-success mainSigninForm">
				<span class="glyphicon glyphicon-user"></span> 회원가입
			</a><br/>
		</form>	
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.js"></script>
<style>
	.SignupForm{width:100%;margin-top:10px;}
</style>
</head>
<body>
	<div class="container">
		<form action="signup.do" method="post" class="form-group"style="margin:0 auto;width:500px;vertical-align:middle; ">
		<h3>회원가입</h3>
			<input type="text" name="id" id="id" placeholder="아이디" class="SignupForm form-control"/><br/>
			<input type="password" name="pwd" id="pwd" class="SignupForm form-control" placeholder="비밀번호"/><br/>
			<input type="text" name="email" id="email" placeholder="이메일" class="SignupForm form-control"/>
			<button type="submit" class="btn btn-primary SignupForm">
				<span class="glyphicon glyphicon-pencil"></span> 회원가입
			</button><br/>
			<button type="reset" class="btn btn-danger SignupForm">
				<span class="glyphicon glyphicon-remove"></span> 취소
			</button><br/>
		</form>		
	</div>
</body>
</html>
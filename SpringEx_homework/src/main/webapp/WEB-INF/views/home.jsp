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
		<c:choose>
			<c:when test="${empty id}">
				<form action="users/signin.do" method="post" class="form-group"style="margin:0 auto;width:500px;vertical-align:middle; ">
				<h3>SIMPLE HOMEPAGE</h3>
					<input type="text" name="id" placeholder="아이디" class="mainSigninForm form-control"/><br/>
					<input type="password" name="pwd" class="mainSigninForm form-control" placeholder="비밀번호"/><br/>
					<button type="submit" class="btn btn-primary mainSigninForm">
						<span class="glyphicon glyphicon-ok"></span> 로그인
					</button><br/>
					<a href="users/signupform.do" class="btn btn-success mainSigninForm">
						<span class="glyphicon glyphicon-pencil"></span> 회원가입
					</a><br/>
				</form>				
			</c:when>
			<c:otherwise>
				<div style="margin:0 auto;width:500px;vertical-align:middle;">
					<h3>SIMPLE HOMEPAGE</h3>
					<a href="users/private/info.do?id=${id}" class="btn btn-warning mainSigninForm" style="margin-top:150px;">
						<span class="glyphicon glyphicon-user"></span> ${id }님
					</a><br/>
					<a href="users/signout.do?id=${id}" class="btn btn-danger mainSigninForm">
						<span class="glyphicon glyphicon-remove"></span> 로그아웃
					</a><br/>								
				</div>		
			</c:otherwise>		
		</c:choose>
		<div style="margin:0 auto;width:500px;vertical-align:middle;">
			<a href="board/list.do" class="btn btn-default mainSigninForm">
				<span class="glyphicon glyphicon-list-alt"></span> 게시판
			</a><br/>
		</div>
	</div>
</body>
</html>
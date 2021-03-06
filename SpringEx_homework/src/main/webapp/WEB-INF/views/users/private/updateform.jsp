<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지입니다.</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.js"></script>
<style>
	.updateForm{width:100%;margin-top:10px;}
</style>
</head>
<body>
	<div class="container">
		<form action="update.do" method="post" class="form-group" id="updateForm" 
			style="margin:0 auto;width:500px;vertical-align:middle; ">
			<h3>회원가입</h3>
			<div class="form-group">		
				<input type="hidden" name="id"  class="updateForm form-control" value="${dto.id }"/>
				<label class="control-label" for="id">아이디</label>
				<input type="text" id="id" value="${dto.id }" class="updateForm form-control" disabled="disabled"/><br/>	
			</div>
			<div class="form-group">
				<label class="control-label" for="pwd">비밀번호</label>
				<input type="password" name="pwd" id="pwd" class="updateForm form-control" value="${dto.pwd }"/><br/>
			</div>
			<div class="form-group">
				<label class="control-label" for="check_pwd">비밀번호 확인</label>
				<input type="password" name="check_pwd" id="check_pwd" class="updateForm form-control" value="${dto.pwd }"/><br/>
			</div>			
			<div class="form-group">
				<label class="control-label" for="email">이메일</label>
				<input type="text" name="email" id="email" class="updateForm form-control" value="${dto.email }"/><br/>
			</div>
			<button type="submit" class="btn btn-primary" id="updateBtn" style="width: 100%">
				<span class="glyphicon glyphicon-pencil"></span> 수정
			</button><br/>
			<button type="reset" class="btn btn-danger updateForm">
				<span class="glyphicon glyphicon-remove"></span> 취소
			</button><br/>
			<a href="${pageContext.request.contextPath }/home.do" class="btn btn-success updateForm">
				<span class="glyphicon glyphicon-home"></span> 홈
			</a>
		</form>		
	</div>
	<script>
		$("#updateForm").on("submit",function(event){
			console.log("1111");
			var firstPwd=$("#pwd").val();
			var secondPwd=$("#check_pwd").val();
			if(firstPwd!=secondPwd){
				alert("비밀번호를 확인 하세요");
				event.preventDefault();//폼전송 막기 				
			}
		})
	</script>	
</body>
</html>
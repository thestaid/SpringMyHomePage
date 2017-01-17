<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.js"></script>
</head>
<style>
	.division{text-align:center}
	.infoForm{width:100%;margin-top:10px;}
</style>
<body>
	<div class="container">
		<div style="margin:0 auto;width:500px;vertical-align:middle;">
			<h3>회원 정보 페이지</h3>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="division">항목</th>
						<th class="division">정보</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th class="division">아이디</th>
						<td class="division">${dto.id }</td>
					</tr>
					<tr>
						<th class="division">이메일</th>
						<td class="division">${dto.email }</td>
					</tr>
					<tr>
						<th class="division">가입일</th>
						<td class="division">${dto.regdate }</td>
					</tr>
				</tbody>
			</table>
			<a class="btn btn-primary infoForm" href="private/updateform.do?id=${dto.id }">
				<span class="glyphicon glyphicon-erase"></span> 회원정보 수정
			</a>
			<a class="btn btn-warning infoForm" href="javascript:userConfirm()">
				<span class="glyphicon glyphicon-trash"></span> 회원 탈퇴
			</a>
			<a class="btn btn-success infoForm" href="${pageContext.request.contextPath }/home.do">
				<span class="glyphicon glyphicon-home"></span> 홈
			</a>			
		</div>
	</div>
	<script>
	//삭제여부를 물어보고 이동시키기 위한 함수
	function userConfirm(){
		var isDelete=confirm("탈퇴하시겠습니까?");
		if(isDelete){
			location.href="private/delete.do?id=${dto.id }";
		}
	}
	</script>
	
</body>
</html>
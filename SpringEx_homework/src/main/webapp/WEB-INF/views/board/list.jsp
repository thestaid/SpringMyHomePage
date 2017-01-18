<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.js"></script>
</head>
<style>
	.division{text-align: center;}
	#boardInsertBtn{
		margin-top:0px;
		float:right;
		padding:4px;
		font-weight:bold;
		width:80px;
	}	
</style>
<body>
	<div class="container">
		<div class="tab" style="margin:0 auto;width:500px;vertical-align:middle; ">
			<h3>게시판</h3>
			<table class="table table-hover" >
				<thead>
					<tr>
						<th class="division"></th>
						<th class="division">제목</th>
						<th class="division">작성자</th>
						<th class="division">등록일</th>
						<th class="division">조회수</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="tmp" items="${list }">
					<tr>
						<td class="division">${tmp.num }</td>
						<td class="division">
							<a href="detail.do?num=${tmp.num}">${tmp.title }</a>
						</td>
						<td class="division">${tmp.writer }</td>
						<td class="division">${tmp.regdate }</td>
						<td class="division">${tmp.viewCount }</td>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
			<%-- 로그인 여부에 따라 글쓰기의 처리가 다름 --%>
			<a href="<c:choose>
					<c:when test="${empty id }">javascript:boardInsertBtn()</c:when>
					<c:otherwise>private/insertform.do</c:otherwise>
					</c:choose>" id="boardInsertBtn" class="btn btn-success" style="margin-top: 10px;">
				<span class="glyphicon glyphicon-pencil" style ="color:white;"></span> 글쓰기
			</a>		
		</div>				
	</div>
</body>
	<script>
		//로그인이 안되어있을경우 경고창 띄운다.
		function boardInsertBtn(){
			alert("로그인 해주세요!");
			location.href="${pageContext.request.contextPath }/home.do";
		};
	</script>
</html>
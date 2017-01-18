<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글입니다.</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.js"></script>
</head>
<style>
	.move-btn{
		width: 65px;
		margin: 0px;	
	}
</style>
<body>
	<div class="container">
		<h3>게시글</h3>
		<div style="margin:0 auto;width:80%;vertical-align:middle; ">
			<a href="list.do" class="pull-right btn btn-default move-btn" style="font-size:12px; padding:5px;margin-top:20px;margin-bottom:5px;">목록</a>
			<table class="table table-bordered" style="margin-top:40px;">
				<tr>
					<td>
						<div class="row">
							<div class="col-xs-4" style="font-weight:bold;">${dto.title }</div>
							<div class="col-xs-4"></div>
							<div class="col-xs-4 pull-right" style="font-size:12px;">${dto.regdate }</div>
						</div>				
					</td>
				</tr>
				<tr>
					<td>
						<div class="row">
							<div class="col-xs-4">글번호 : ${dto.num }</div>
							<div class="col-xs-4"></div>
							<div class="col-xs-4 pull-right">작성자 : ${dto.writer }</div>
						</div>				
					</td>
				</tr>			
				<tr>
					<td><div class="content" style="margin-top:40px;">${dto.content }</div></td>
				</tr>
			</table>
			<c:if test="${id eq dto.writer }">
				<a href="javascript:deleteCheck()" class="btn btn-danger pull-right" style="margin-left:10px">삭제</a>
				<a href="private/updateform.do?num=${dto.num }" class="btn btn-warning pull-right">수정</a>
			</c:if>			
		</div>
	</div>
	<script>
		function deleteCheck(){
			var isDelete = confirm("진짜 삭제할거에요?");
			if(isDelete){
				location.href = "private/delete.do?num=${dto.num}";
			}
		}	
	</script>
</body>
</html>
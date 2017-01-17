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
	.help-block{display:none;}	
</style>
</head>
<body>
	<div class="container">
		<form action="signup.do" method="post" class="form-group" style="margin:0 auto;width:500px;vertical-align:middle; ">
			<h3>회원가입</h3>
			<div class="form-group has-feedback">		
				<label class="control-label" for="id">아이디</label>
				<input type="text" name="id" id="id" placeholder="아이디" class="SignupForm form-control"/><br/>
				<p class="help-block">사용할수 없는 아이디 입니다.</p>
				<span class="glyphicon form-control-feedback"></span>	
			</div>
			<div class="form-group">
				<label class="control-label" for="pwd">비밀번호</label>
				<input type="password" name="pwd" id="pwd" class="SignupForm form-control" placeholder="비밀번호"/><br/>
			</div>
			<div class="form-group">
				<label class="control-label" for="email">이메일</label>
				<input type="text" name="email" id="email" placeholder="이메일" class="SignupForm form-control"/>
			</div>
			<button type="submit" class="btn btn-primary SignupForm" id="submitBtn">
				<span class="glyphicon glyphicon-pencil"></span> 회원가입
			</button><br/>
			<button type="reset" class="btn btn-danger SignupForm">
				<span class="glyphicon glyphicon-remove"></span> 취소
			</button><br/>
			<a href="${pageContext.request.contextPath }/home.do" class="btn btn-success SignupForm">
				<span class="glyphicon glyphicon-home"></span> 홈
			</a>
		</form>		
	</div>
	<script>
		$("#id").on("keyup",function(){
			var signupId=$("#id").val();
			$.ajax({
				url:"checkid.do",
				method:"get",
				data:{signupId:signupId},
				success:function(data){
					console.log(data);
					//한번 초기화해주고 if문으로 아이디가 유효할때 작업한다.
					$("#id").parent()
					.removeClass("has-success has-error");
					if(data.canUse){
						$("#id")
						.parent()//id의 부모에
						.addClass("has-success")//input을 초록색으로 해주고
						.find(".help-block")//helpblock을 찾아서
						.hide()//숨긴다.
						.parent()//그것의 부모에
						.find(".glyphicon")//glyphicon class를 찾아서
						.removeClass("glyphicon-remove")//리무브 글리피콘을 지우고
						.addClass("glyphicon-ok");//ok 클리피콘을 추가한다.
						
						$("#submitBtn").removeAttr("disabled");
					}else{
						$("#id")
						.parent()
						.addClass("has-error")
						.find(".help-block")
						.show()
						.parent()
						.find(".glyphicon")
						.removeClass("glyphicon-ok")
						.addClass("glyphicon-remove");	
						
						$("#submitBtn").attr("disabled", "disabled");
					}					
				}
			});
		});
	</script>
</body>
</html>
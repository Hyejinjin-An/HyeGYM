<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<script type="text/javascript" src="../resource/js/admin/login.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<body>
	<!-- header start -->
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<!-- header end -->
	
	<!-- main Contents start -->
	<% 
		Object object = session.getAttribute("result");
		String result = "";
		if(object != null){
			result = object.toString();
		}		
		if(result.equals("error")){
			out.println("<script>");
		    out.println("alert('에러가 발생했습니다.');");
		    out.println("</script>");
		}
	%>
	<div class="main_container">
		<h1>로그인</h1>
		<br/>
		<div>
		<form action="loginAdmin" onSubmit="return infoValidate()" method="post">
			<table class="login_table">
				<tr>
					<td>
						<span>아이디</span>
						<input type="text" name="id">
					</td>
				</tr>
				<tr>
					<td>
						<span>비밀번호</span>
						<input type="password" name="password">
					</td>
				</tr>
			</table>
			<c:if test="${result == 'fail'}">
				<p style="color:red;">로그인에 실패하였습니다. 다시 시도해주세요.</p>
			</c:if>
			<br/>
			<input type="button" onclick="location.href='main'" value="돌아가기">
			&nbsp;
			<input type="submit" value="로그인">
		</form>
		</div>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
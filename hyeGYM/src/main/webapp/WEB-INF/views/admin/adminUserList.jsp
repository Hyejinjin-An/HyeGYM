<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<!-- header start -->
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<!-- header end -->
	
	<!-- main Contents start -->
	<div class="main_container">
		<h1>회원 정보</h1>
		
	    <table border="1" class="user_table" >
	        <tr>
	        	<th>no</th>
	            <th>아이디</th>
	            <th>이름</th>
	            <th>성별</th>
	            <th>생년월일</th>
	            <th>이메일</th>
	        </tr>
	        <c:forEach var="userlist" items="${userList}">
	            <tr>
	            	<td>${userlist.index}</td>
	                <td>${userlist.id}</td>
	                <td>${userlist.name}</td>
	                <td>
	                	<c:choose>
		                	<c:when test='${userlist.gender eq "m"}'>남자</c:when>
		                	<c:otherwise>여자</c:otherwise>
	                	</c:choose>
	                </td>
	                <td>${userlist.birth}</td>
	                <td>${userlist.email}</td>
	            </tr>
	        </c:forEach>
	
	    </table>
	    <br/>
		<button onclick="location.href='main'">main</button>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
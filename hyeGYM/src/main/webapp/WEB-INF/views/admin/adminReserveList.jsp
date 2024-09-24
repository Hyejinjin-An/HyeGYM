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
		<h1>PT 예약 현황</h1>
		<br/>
		<table border="1" class="user_table" >
	        <tr>
	        	<th>no</th>
	            <th>아이디</th>
	            <th>이름</th>
	            <th>이메일</th>
	            <th>선생님</th>
	            <th>희망날짜</th>
	            <th>희망시간</th>
	        </tr>
	        <c:forEach var="userlist" items="${userList}" varStatus="idx">
	            <tr>
	            	<td><c:out value="${idx.count}"/></td>
	                <td>${userlist.id}</td>
	                <td>${userlist.name}</td>
	                <td>${userlist.email}</td>
	                <td>${userlist.teacher}</td>
	                <td>${userlist.date}</td>
	                <td>${userlist.time}</td>
	            </tr>
	        </c:forEach>
	
	    </table>
	    <br/>
	    <br/>
		<button onclick="location.href='main'">main</button>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
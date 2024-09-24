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
		<h1>공지사항 상세내용</h1>
		<br/>
		<div>
			<table class="noticeinfo_table" border="1">
	        <tr>
	        	<th>글번호</th>
	        	<td colspan="2">${info.no}</td>
	            <th>등록일</th>
                <td>${date}</td>
	        </tr>
	        <tr>
	        	<th>제목</th>
	        	<td colspan="2">${info.title}</td>
 		        <th>작성자</th>
	        	<td>${info.id}</td>
	        </tr>
	        <tr>
	        	<th>내용</th>
	        	<td colspan="4">${info.contents}</td>
	        </tr>
<!-- 	        <tr>
	        	<th>첨부파일</th>
	        	<td colspan="4"><input type="file"></td>
	        </tr> -->
	    </table>
			<br/>
		</div>
		<br/>
		<button class="list" onclick="location.href='adminNotice'">목록</button>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
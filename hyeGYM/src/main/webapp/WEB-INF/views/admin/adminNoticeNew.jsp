<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<script type="text/javascript" src="../resource/js/admin/adminNoticeNew.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<body>
	<!-- header start -->
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<!-- header end -->
	
	<!-- main Contents start -->
	<div class="main_container">
		<h1>공지사항 글 작성</h1>
		<br/>
		<div>
			<table class="adminNoticeinfo_table" border="1">
	        <tr>
	        	<th>제목</th>
	        	<td colspan="2"><input type="text" class="noticeTitle"/></td>
 		        <th>작성자</th>
	        	<td class="noticeId"><c:out value="${userinfo.id}" default="admin" /></td>
	        </tr>
	        <tr>
	        	<th>내용</th>
	        	<td colspan="4"><textarea class="noticeContents"></textarea></td>
	        </tr>
	    </table>
			<br/>
		</div>
		<br/>
		<button class="list" onclick="location.href='adminNotice'">목록</button>
		&nbsp;
		<button class="list" onclick="javascript:noticeNew()">등록</button>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
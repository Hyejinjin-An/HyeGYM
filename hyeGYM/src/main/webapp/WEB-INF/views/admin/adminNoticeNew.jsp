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
		<h1>お知らせ作成</h1>
		<br/>
		<div>
			<table class="adminNoticeinfo_table" border="1">
	        <tr>
	        	<th>タイトル</th>
	        	<td colspan="2"><input type="text" class="noticeTitle"/></td>
 		        <th>登録者</th>
	        	<td class="noticeId"><c:out value="${userinfo.id}" default="admin" /></td>
	        </tr>
	        <tr>
	        	<th>内容</th>
	        	<td colspan="4"><textarea class="noticeContents"></textarea></td>
	        </tr>
	    </table>
			<br/>
		</div>
		<br/>
		<button class="list" onclick="location.href='adminNotice'">リストに戻る</button>
		&nbsp;
		<button class="list" onclick="javascript:noticeNew()">登録する</button>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
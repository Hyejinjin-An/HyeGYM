<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<script type="text/javascript" src="../resource/js/user/notice.js"></script>
<body>
	<!-- header start -->
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<!-- header end -->
	
	<!-- main Contents start -->
	<div class="main_container">
		<h1>お知らせ</h1>
		<br/>
		<div>
			<table class="notice_table" border="1">
	        <tr>
	        	<th>no</th>
	            <th colspan="2">タイトル</th>
	            <th>登録者</th>
	            <th>登録日</th>
	        </tr>
	        <c:forEach var="contents" items="${contents}">
	            <tr>
	            	<td>${contents.no}</td>
	                <td colspan="2"><a href="/user/noticeinfo?no=${contents.no}">${contents.title}</a></td>
	                <td>${contents.id}</td>
	                <td>${contents.createAtStr}</td>
	            </tr>
	        </c:forEach>
	    </table>
   	    <div class="paging_box">
			<ul class="pagination">
			<c:if test="${paging.prev}">
				<li class="page-item">
					<a class="page-link" href="#" onClick="fn_prev('${paging.page}', '${paging.range}', '${paging.rangeSize}')">Prev</a>
				</li>
			</c:if>
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="idx">
				<li class="page-item <c:out value="${paging.page == idx ? 'active' : ''}"/> ">
					<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${paging.range}', '${paging.rangeSize}')"> ${idx} </a>
				</li>
			</c:forEach>
			<c:if test="${paging.next}">
				<li class="page-item">
					<a class="page-link" href="#" onClick="fn_next('${paging.range}', '${paging.range}', '${paging.rangeSize}')">Next</a>
				</li>
			</c:if>
			</ul>
	    </div>
		<br/>
		</div>
		<button onclick="location.href='main'">メインへ</button>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
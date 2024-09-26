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
		<h1>PT 予約情報</h1>
		<br/>
		<table border="1" class="user_table" >
	        <tr>
	        	<th>no</th>
	            <th>ID</th>
	            <th>名前</th>
	            <th>メール</th>
	            <th>先生</th>
	            <th>希望日付</th>
	            <th>希望時間</th>
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
	    <br/>
		<button onclick="location.href='main'">メインへ</button>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
	
	<script type="text/javascript">
		//이전 버튼 이벤트
		function fn_prev(page, range, rangeSize) {
			var page = ((range - 2) * rangeSize) + 1;
			var range = range - 1;
	
			var url = "/admin/adminReserveList";
			url = url + "?page=" + page;
			url = url + "&range=" + range;
			location.href = url;
		}
	
		//페이지 번호 클릭	
		function fn_pagination(page, range, rangeSize) {
			var url = "/admin/adminReserveList";
			url = url + "?page=" + page;
			url = url + "&range=" + range;
			location.href = url;
		}
	
		//다음 버튼 이벤트
		function fn_next(page, range, rangeSize) {
			var page = parseInt((range * rangeSize)) + 1; 
			var range = parseInt(range) + 1; 
			var url = "/admin/adminReserveList"; 
			url = url + "?page=" + page; 
			url = url + "&range=" + range; 
			location.href = url;
		}
	</script>
</body>
</html>
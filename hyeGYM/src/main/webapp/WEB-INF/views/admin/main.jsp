<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="contents">
			<h1>아!!! admin main 입니다</h1>
			<p>어서오세요</p>
			<div class="contents_menu">
				<div class="contents_menu_button">
					<div class="contents_menu_button index">
						<button onclick="location.href='adminNotice'">공지사항</button>
						<button onclick="location.href='adminUserList'">고객정보</button>
						<button onclick="location.href='adminReserveList'">예약관리</button>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HyeGYM</title>
</head>
<body>
	<!-- header start -->
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<!-- header end -->
	
	<!-- main Contents start -->
	<div class="main_container">
		<div class="contents">
			<h1>ようこそ！HyeGYMへ</h1>
			<p>管理者ページ</p>
			<div class="contents_menu">
				<div class="contents_menu_button">
					<div class="contents_menu_button index">
						<button onclick="location.href='adminNotice'">お知らせ</button>
						<button onclick="location.href='adminUserList'">お客さんリスト</button>
						<button onclick="location.href='adminReserveList'">予約管理</button>
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
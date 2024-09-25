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
		<h1>予約完了</h1>
		<div class="image_container">
			<table class="reserved_table">
				<tr>
					<td>
						<span>ID</span>
						<span><b>${reserveUserInfo.id}</b></span>
					</td>
				</tr>
				<tr>
					<td>
						<span>名前</span>
						<span>${reserveUserInfo.name}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>メール</span>
						<span>${reserveUserInfo.email}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>先生</span>
						<span>${reserveUserInfo.teacher}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>希望日付</span>
						<span><b>${reserveUserInfo.date}</b></span>
					</td>
				</tr>
				<tr>
					<td>
						<span>希望時間</span>
						<span><b>${reserveUserInfo.time}</b></span>
					</td>
				</tr>
			</table>
		</div>
		<br/>
		<button onclick="location.href='main'">メインへ</button>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
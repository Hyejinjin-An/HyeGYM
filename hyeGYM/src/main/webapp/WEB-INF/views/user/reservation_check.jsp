<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<script type="text/javascript" src="../resource/js/user/reservation_check.js"></script>
<body>
	<!-- header start -->
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<!-- header end -->
	
	<!-- main Contents start -->
	<div class="main_container">
		<h1>予約情報</h1>
		<div class="image_container">
			<table class="reserved_table">
				<tr>
					<td>
						<span>ID</span>
						<span id="id"><b>${reserveUserInfo.id}</b></span>
					</td>
				</tr>
				<tr>
					<td>
						<span>名前</span>
						<span id="name">${reserveUserInfo.name}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>メール</span>
						<span id="email">${reserveUserInfo.email}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>先生</span>
						<span id="teacher">${reserveUserInfo.teacher}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>希望日付</span>
						<span id="date"><b>${reserveUserInfo.date}</b></span>
					</td>
				</tr>
				<tr>
					<td>
						<span>希望時間</span>
						<span id="time"><b>${reserveUserInfo.time}</b></span>
					</td>
				</tr>
			</table>
		</div>
		<br/>
		<button onclick="location.href='main'">メインへ</button>
		&nbsp;
		<button onclick="javascript:submitDeleteReservation()">予約キャンセル</button>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
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
		<h1>예약 정보</h1>
		<div class="image_container">
			<table class="reserved_table">
				<tr>
					<td>
						<span>아이디</span>
						<span><b>${reserveUserInfo.id}</b></span>
					</td>
				</tr>
				<tr>
					<td>
						<span>이름</span>
						<span>${reserveUserInfo.name}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>이메일</span>
						<span>${reserveUserInfo.email}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>선생님</span>
						<span>${reserveUserInfo.teacher}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>희망날짜</span>
						<span><b>${reserveUserInfo.date}</b></span>
					</td>
				</tr>
				<tr>
					<td>
						<span>희망시간</span>
						<span><b>${reserveUserInfo.time}</b></span>
					</td>
				</tr>
			</table>
		</div>
		<br/>
		<button onclick="location.href='main'">main</button>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
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
		<h1>PT 予約</h1>
		<div class="image_container">
			<div class="image_div">
				<div class="images">
					<img alt="freepik_teacher1" src="../resource/static/images/teacher1.jpg">
				</div>
				<p>1st teacher</p>
				<button onclick="location.href='reservationinfo?t=1'">予約する</button>
			</div>
			<div class="image_div">
				<div class="images">
					<img alt="freepik_teacher2" src="../resource/static/images/teacher2.jpg">
				</div>
				<p>2nd teacher</p>
				<button onclick="location.href='reservationinfo?t=2'">予約する</button>
			</div>
			<div class="image_div">
				<div class="images">
					<img alt="freepik_teacher3" src="../resource/static/images/teacher3.jpg">
				</div>
				<p>3rd teacher</p>
				<button onclick="location.href='reservationinfo?t=3'">予約する</button>
			</div>
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
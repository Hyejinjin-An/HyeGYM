<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css"/>
</head>
<body>
	<!-- header start -->
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<!-- header end -->
	
	<script type="text/javascript" src="../resource/js/user/reservationinfo.js"></script>
	
	<!-- main Contents start -->
	<div class="main_container">
		<h1>PT 예약 상세정보</h1>
		<div class="reserve_container">
			<table class="reserve_table">
				<tr>
					<td>
						<span>아이디</span>
						<span id="id"><b>${userinfo.id}</b></span>
					</td>
				</tr>
				<tr>
					<td>
						<span>이름</span>
						<span id="name">${userinfo.name}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>이메일</span>
						<span id="email">${userinfo.email}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>선생님</span>
						<c:choose>
							<c:when test="${t eq '1'}"><span id="t">teacher1</span></c:when>
							<c:when test="${t eq '2'}"><span id="t">teacher2</span></c:when>
							<c:when test="${t eq '3'}"><span id="t">teacher3</span></c:when>
							<c:otherwise><span id="t">NOT SELECT</span></c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>
						<span>희망날짜</span>
						<input type="text" id="reserveDate">
					</td>
				</tr>
				<tr>
					<td>
						<span>희망시간</span>
						<span class="reserveTimeTable">
							<select class="reserveTime">
								<option selected>select</option>
								<option>09:00-10:00</option>
								<option>10:00-11:00</option>
								<option>11:00-12:00</option>
								<option>12:00-13:00</option>
								<option>13:00-14:00</option>
								<option>14:00-15:00</option>
								<option>15:00-16:00</option>
								<option>16:00-17:00</option>
								<option>17:00-18:00</option>
								<option>18:00-19:00</option>
								<option>19:00-20:00</option>
							</select>
						</span>
					</td>
				</tr>
			</table>
		</div>
		<br/>
		<div class="reserve_button_div">
			<button onclick="location.href='main'">메인화면으로</button>
			&nbsp;
			<button onclick="javascript:submitReserve()">예약하기</button>
		</div>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
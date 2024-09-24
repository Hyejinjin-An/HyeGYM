<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<script type="text/javascript" src="../resource/js/user/join.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<body>
	<!-- header start -->
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<!-- header end -->
	
	<!-- main Contents start -->
	<div class="main_container">
		<h1>회원가입</h1>
		<br/>
		<div>
			<table class="join_table">
				<tr>
					<td>
						<span>아이디</span>
						<input type="text" name="id">
					</td>
				</tr>
				<tr>
					<td>
						<span>비밀번호</span>
						<input type="password" name="password">
					</td>
				</tr>
				<tr>
					<td>
						<span>이름</span>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>
						<span>생년월일</span>
						<input type="number" name="birth" placeholder="YYYYMMDD">
					</td>
				</tr>
				<tr>
					<td>
						<span>성별</span>
						<div>
							<input type="radio" name="gender" value="f" checked>여자
							<input type="radio" name="gender" value="m">남자
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<span>이메일</span>
						<input type="text" name="email" placeholder="example@gmail.com">
					</td>
				</tr>
			</table>
			<br/>
			<input type="button" onclick="location.href='main'" value="돌아가기">
			&nbsp;
			<input type="button" onclick="javascript:join()" value="회원가입">
		</div>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
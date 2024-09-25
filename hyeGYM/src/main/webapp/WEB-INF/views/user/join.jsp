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
		<h1>会員加入</h1>
		<br/>
		<div>
			<table class="join_table">
				<tr>
					<td>
						<span>ID</span>
						<input type="text" name="id">
					</td>
				</tr>
				<tr>
					<td>
						<span>パスワード</span>
						<input type="password" name="password">
					</td>
				</tr>
				<tr>
					<td>
						<span>名前</span>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>
						<span>生年月日</span>
						<input type="number" name="birth" placeholder="YYYYMMDD">
					</td>
				</tr>
				<tr>
					<td>
						<span>性別</span>
						<div>
							<input type="radio" name="gender" value="f" checked>女
							<input type="radio" name="gender" value="m">男
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<span>メール</span>
						<input type="text" name="email" placeholder="example@gmail.com">
					</td>
				</tr>
			</table>
			<br/>
			<input type="button" onclick="location.href='main'" value="戻る">
			&nbsp;
			<input type="button" onclick="javascript:join()" value="加入する">
		</div>
	</div>
	<!-- main Contents end -->
	
	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
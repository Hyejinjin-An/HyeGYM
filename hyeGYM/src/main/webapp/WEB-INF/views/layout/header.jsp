<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../resource/css/style.css">	
</head>
<script type="text/javascript" src="../resource/js/layout/header.js"></script>
<body>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<div class="header">
		
		<div class="nav_home">
			<span class="mainpage">
				<a href="main" >メイン</a>
			</span>
		</div>
		<div class="nav_menu">
			<div class="menu">
<!-- 				<ul>
					<li class="notice"><a href="notice">공지사항</a></li>
					<li class="reservation"><a href="reservation">PT예약</a></li>
					<li class="workoutinfo"><a href="workoutinfo">운동정보</a></li>
				</ul> -->
			</div>
			<div class="nav_login">
				<ul>
					<c:choose>
						<c:when test="${userinfo.id ne null}">
							<li class="user_id"><b>${userinfo.id}</b>&nbsp;様</li>
							<li class="logout"><input type="button" onclick="javascript:logout()" value="ログアウト"></li>
						</c:when>
						<c:when test="${userinfo.id ne null} %>">
							<li class="user_id"><b>${user.id}</b>&nbsp;様</li>
							<li class="logout"><input type="button" onclick="javascript:logout()" value="ログアウト"></li>
						</c:when>
						<c:otherwise>
							<li class="join"><input type="button" onclick="location.href='join'" value="会員加入"></li>
							<li class="login"><input type="button" onclick="location.href='login'" value="ログイン"></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
		
	</div>
	
	<script type="text/javascript"> 
		function logout() {	
			$.ajax({
				type:"POST", 
				url:"/user/logout",
				dataType:"Text", 
				success: function(result) { //controller에서 return받은 message부분임
					if(result == "success"){
						alert("ログアウトしました。")
						location.assign("/user/main")
					}else{
						alert("ログアウト失敗しました。");
					}
				},
			    error: function(error) {
			    	alert("error! " + error.status + " / text : " + error.statusText);
				}
			});
		}
	</script>
</body>
</html>
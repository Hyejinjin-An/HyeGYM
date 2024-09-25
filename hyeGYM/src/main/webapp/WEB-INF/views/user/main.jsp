<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<p>いらっしゃいませ！</p>			
			<div class="contents_menu">
				<div class="contents_menu_button">
					<div class="contents_menu_button index">
						<button value="notice" onclick="location.href='notice'">お知らせ</button>
						<button value="reserve" onclick="javascript:checkUserinfo(this)">PT予約</button>
						<button value="check" onclick="javascript:checkUserinfo(this)">予約情報確認</button>
					</div>
				</div>
			</div>
			
		</div>
		
	</div>
	<!-- main Contents end -->

	<!-- footer start -->
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	<!-- footer end -->
	<script type="text/javascript"> 
		function checkUserinfo(val){
		    var info = '<%=session.getAttribute("userinfo")%>';
		    var value = $(val).val();
			
			if(info == 'null' || info == 'undefined' || info == "" || info == null) {
				alert("ログインが必要です。");
				location = "/user/login";
			}else{
				if(value == 'check'){
					checkReserveinfo(info);
				}else{
					$.ajax({
						type:"POST", //http메서드를 쓰면됨
						url:"/user/selectReserveUser", //데이터를 전송하여 저장시키는 url
						data:JSON.stringify(info),
						contentType: "application/json; charset=utf-8",
						dataType:"Text", //리턴타입, 성공여부를 text로 추출해줌
						success: function(data) { //controller에서 return받은 message부분임
							if(data == "success"){
								alert("すでに予約済みです。 予約情報をご確認ください。");
							}else{
								location = "/user/reservation";
							}
						},
					    error: function(error) {
					    	alert("error! " + error.status + " / text : " + error.statusText);
						}
					});
				}
			}
		}
		
		function checkReserveinfo(info) {
			
			console.log(JSON.stringify(info));
			
			$.ajax({
				type:"POST", //http메서드를 쓰면됨
				url:"/user/selectReserveUser", //데이터를 전송하여 저장시키는 url
				data:JSON.stringify(info),
				contentType: "application/json; charset=utf-8",
				dataType:"Text", //리턴타입, 성공여부를 text로 추출해줌
				success: function(data) { //controller에서 return받은 message부분임
					if(data == "success"){
						location = "/user/reserveCheck";
					}else{
						alert("予約情報がありません。");
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
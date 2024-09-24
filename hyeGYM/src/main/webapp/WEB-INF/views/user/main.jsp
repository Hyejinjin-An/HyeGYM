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
			<h1>아!!! user main 입니다</h1>
			<p>어서오세요</p>			
			<div class="contents_menu">
				<div class="contents_menu_button">
					<div class="contents_menu_button index">
						<button value="notice" onclick="location.href='notice'">공지사항</button>
						<button value="reserve" onclick="javascript:checkUserinfo(this)">PT 예약하기</button>
						<button value="check" onclick="javascript:checkUserinfo(this)">예약 확인하기</button>
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
				alert("로그인이 필요합니다");
				location = "/user/login";
			}else{
				if(value == 'check'){
					checkReserveinfo(info);
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
						alert("예약 내역이 없습니다.");
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
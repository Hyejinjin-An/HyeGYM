/**
 *  PT 예약 상세 페이지
 */

$(document).ready(function(){
	
	// datepicker 공통옵션
	$("#reserveDate").datepicker({
		dateFormat : 'yy-mm-dd',
		showButtonPanel : true,
		closeText : '닫기',
		minDate : "0D",
		maxDate : "+7D"
	});
	
	// 초기값을 오늘 날짜로 설정
   $("#reserveDate").datepicker('setDate', 'today');
	
});

function submitReserve() {	
	var param = {	
		id : $("#id").text(),
		name : $("#name").text(),
		email : $("#email").text(),
		teacher : $("#t").text(),
		date : $("#reserveDate").val(),
		time : $(".reserveTime").val()
	}
	
	if(validate(param)){	
		if(confirm("예약하시겠습니까?")){
			$.ajax({
				type:"POST", //http메서드를 쓰면됨
				url:"/user/reserveUser", //데이터를 전송하여 저장시키는 url
				data:JSON.stringify(param), //화면에 입력한 데이터 위에 변수 선언한거
				contentType: "application/json; charset=utf-8",
				dataType:"Text", //리턴타입, 성공여부를 text로 추출해줌
				success: function(data) { //controller에서 return받은 message부분임
					if(data == "success"){
						alert("예약되었습니다.")
						sessionInsertData(param);
						location = "/user/reserveSuccess";
					}else{
						alert("예약 실패하였습니다.");
					}
				},
			    error: function(error) {
			    	alert("error! " + error.status + " / text : " + error.statusText);
				}
			});
		}
	}
}

function sessionInsertData(param){
	sessionStorage.setItem("reserveUserInfo", param);
}

function validate() {
	var res = true;
	var dateRes = true;
	var timeRes = true;
	var date = $("#reserveDate").val();
	var time = $(".reserveTime").val();
	
	if(date == null || date == "") dateRes = false;
	if(time == 'select' || time == "") timeRes = false;
	
	if(!dateRes) {
		alert("날짜를 선택해주세요.");
		$("#dateTime").focus();	// 자동 포커스
	}
	
	if(!timeRes) {
		alert("시간을 선택해주세요.");
	}
	
	if(!dateRes || !timeRes) res = false;
	return res;
}
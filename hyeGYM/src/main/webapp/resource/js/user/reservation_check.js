/**
 *  PT 예약 정보 페이지
 */

function submitDeleteReservation() {	
	var param = {	
		id : $("#id").text(),
		name : $("#name").text(),
		email : $("#email").text(),
		teacher : $("#teacher").text(),
		date : $("#reserveDate").text(),
		time : $("#reserveTime").text()
	}
	
	console.log(param);
		
	if(confirm("예약 취소 하시겠습니까?")){
		$.ajax({
			type:"POST", //http메서드를 쓰면됨
			url:"/user/deleteReservation", //데이터를 전송하여 저장시키는 url
			data:JSON.stringify(param), //화면에 입력한 데이터 위에 변수 선언한거
			contentType: "application/json; charset=utf-8",
			dataType:"Text", //리턴타입, 성공여부를 text로 추출해줌
			success: function(data) { //controller에서 return받은 message부분임
				if(data == 1){
					alert("예약 취소 되었습니다.")
					location = "/user/main";
				}else{
					alert("예약 취소에 실패하였습니다.");
				}
			},
		    error: function(error) {
		    	alert("error! " + error.status + " / text : " + error.statusText);
			}
		});
	}
}
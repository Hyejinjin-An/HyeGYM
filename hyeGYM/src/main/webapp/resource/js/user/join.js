/**
 *  회원가입 페이지
 */


function join() {
	
	var birthDay = $("input[name=birth]").val();
 	var years = birthDay.substr(0,4);
	var month = birthDay.substr(4,2);
	var day = birthDay.substr(6,2);
			
	var param = {	
		id : $("input[name=id]").val(),
		password : $("input[name=password]").val(),
		name : $("input[name=name]").val(),
		birth : years + "." + month + "." + day,
		gender : $("input[name=gender]:checked").val(),
		email : $("input[name=email]").val()
	}
	
	if(infoValidate(param)){	
		//console.log(param);
		
		$.ajax({
			type:"POST", //http메서드를 쓰면됨
			url:"/user/joinUser", //데이터를 전송하여 저장시키는 url
			data:JSON.stringify(param), //화면에 입력한 데이터 위에 변수 선언한거
			contentType: "application/json; charset=utf-8",
			dataType:"Text", //리턴타입, 성공여부를 text로 추출해줌
			success: function(data) { //controller에서 return받은 message부분임
				if(data == "1"){
					location = "/user/joinSuccess?id=" + param.id; //저장이 완료된 이후 이동하는 url
				}else{
					alert("회원가입이 실패하였습니다.");
				}
			},
		    error: function(error) { //시스템에러
		    	alert("error! " + error.status + "text : " + error.statusText);
			}
		});

	}else{
		alert("회원가입에 필요한 모든 정보를 입력해주세요.");
	}
}

function infoValidate(param) {
	var res = true;
	
	if(param.id == null || param.id == "") res = false;
	if(param.password == null || param.password == "") res = false;
	if(param.name == null || param.name == "") res = false;
	if(param.email == null || param.email == "") res = false;
	
		return res;
}
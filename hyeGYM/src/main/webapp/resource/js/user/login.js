/**
 *  로그인 페이지
 */


/*function login() {
			
	var param = {	
		id : $("input[name=id]").val(),
		password : $("input[name=password]").val()
	}
	
	if(infoValidate(param)){	
		$.ajax({
			type:"POST", //http메서드를 쓰면됨
			url:"/user/loginUser", //데이터를 전송하여 저장시키는 url
			data:JSON.stringify(param), //화면에 입력한 데이터 위에 변수 선언한거
			contentType: "application/json; charset=utf-8",
			dataType:"Text", //리턴타입, 성공여부를 text로 추출해줌
			success: function(data) { //controller에서 return받은 message부분임
				if(data.id != ""){
					confirm("로그인 성공하였습니다!")
					// location = "/user/main?id=" + param.id; //저장이 완료된 이후 이동하는 url
				}else{
					alert("로그인 실패하였습니다.");
				}
			},
		    error: function(error) {
		    	alert("error! " + error.status + " / text : " + error.statusText);
			}
		});
	}else{
		alert("아이디와 비밀번호를 입력해주세요.");
	}
}*/

function infoValidate() {
	var res = true;
	var param = {	
		id : $("input[name=id]").val(),
		password : $("input[name=password]").val()
	}
	
	if(param.id == null || param.id == "") res = false;
	if(param.password == null || param.password == "") res = false;
	
	if(!res) alert("로그인에 필요한 정보를 정확히 입력해주세요.");
	
	return res;
}
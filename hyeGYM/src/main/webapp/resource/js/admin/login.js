/**
 *  로그인 페이지
 */


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
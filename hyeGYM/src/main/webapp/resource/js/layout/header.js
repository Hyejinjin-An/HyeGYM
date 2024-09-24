/**
 *  헤더 
 */


/*function logout() {	
	$.ajax({
		type:"POST", 
		url:"/user/logout",
		dataType:"Text", 
		success: function(result) { //controller에서 return받은 message부분임
			if(result == "success"){
				alert("로그하웃 하였습니다.")
				document.location.reload();
			}else{
				alert("로그하웃 실패하였습니다.");
			}
		},
	    error: function(error) {
	    	alert("error! " + error.status + " / text : " + error.statusText);
		}
	});
}*/
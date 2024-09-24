/**
 * 공지사항 글 작성 페이지
 */

function noticeNew() {
	const createDate = new Date();
	var param = {
		id : $(".noticeId").text(),
		title : $(".noticeTitle").val(),
		contents : $(".noticeContents").val(),
		createAt : createDate,
		updateAt : ""
	}
	
	console.log(param);
	
	$.ajax({
		type:"POST", //http메서드를 쓰면됨
		url:"/admin/insertNotice", //데이터를 전송하여 저장시키는 url
		data:JSON.stringify(param), //화면에 입력한 데이터 위에 변수 선언한거
		contentType: "application/json; charset=utf-8",
		dataType:"Text", //리턴타입, 성공여부를 text로 추출해줌
		success: function(data) { //controller에서 return받은 message부분임
			if(data == "1"){
				alert("정상적으로 등록되었습니다.");
				location = "/admin/adminNotice";
			}else{
				alert("공지사항 등록 실패하였습니다.");
			}
		},
	    error: function(error) { //시스템에러
	    	alert("error! " + error.status + " text : " + error.responseText);
		}
	});
}
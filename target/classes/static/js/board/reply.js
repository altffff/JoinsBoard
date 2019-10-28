$(document).ready(function(){
	var bno = Number(window.location.pathname.split("/")[2]);
	var resultArray = [];
	var html = '';

	$.ajax({
		async : false,
		url : "/reply/" + bno,
		type : "GET",
		success : function(result){
			renewTable(result, bno);
		}	
	});
});


//댓글 테이블 새로고침
function renewTable(result, bno){
	var html = '';
	length = result.length;

	for(var i = 0; i < length; i++){
		html += '<tr>'
				+ '<td><input type="hidden" id="id'+result[i].rno+'" value="'+result[i].id+'"></td>'
				+ '<td><input class="form-control" type="text" id="'+ result[i].rno +'" value="' + result[i].reply + '" rows="40" readonly></td>'
				+ '<td align="center">' +result[i].replier + '</td>'
			    + "<td>"
				+ "<div class='btn-group'>"
				+ "<button value="+result[i].rno+ " class='btn btn-xs btn-danger delete'>삭제</button>"
				+ "</div>"
				+ "</td>"	
				+ "</tr>";		
	}
	
	if(length != 0)
		$("#replyTable").html(html);
	else
		$("#replyTable").html("<tr><td>댓글이 없습니다.</td></tr>");

	
	// 삭제 버튼 클릭시 이벤트 처리
	$(".delete").click(function(){
		var rno = $(this).val();	//댓글고유번호

		console.log(rno);
		var data = {
			"bno" : bno,
			"rno" : rno,
		};

		$.ajax({
			async : false,
			url : "/delete",
			type : "POST",
			data : data,
			success : function(result){
				renewTable(result,bno);
			},
			complete : function () {location.reload(); }

		})

	});

	// 새 댓글 쓰기 버튼 클릭
	$('#newReplyReg').click(function(){
		action='create';
		type = 'POST'
		bno = Number(window.location.pathname.split("/")[2]);
		url = '/reply';

		alert("댓글을 등록합니다");
		//정보담아서
		var data = {
			"bno" : bno,
			"reply" : $("#newreply").val(),
			"replier" : $("#newreplier").val(),
			"rPassword" : $("#newreplypass").val()
		};
		//등록으로 전달
		if($("#newreply").val()!='' &&  $("#newreplypass").val()!=''){
			$.ajax({
				url : url,
				type : type,
				data : data,
				success : function(data) { renewTable(result,bno); },
				complete : function (data) {renewTable(result,bno); location.reload(); }
			})
		}else alert("댓글 내용과 패스워드는 공백을 허용하지 않습니다")
	});
}
var action = '';
var url = '';
var type = '';
var bno = 0;

$(document).ready(function(){

	// 새 글 쓰기 버튼 클릭
	$("#createBtn").click(function(){
		action='create';
		type = 'POST'
		$("#modal-title").text("새 글 작성");
		$("#myModal").modal();
	});

	// 수정버튼 클릭
	$("button[name='modify']").click(function(){
		action='modify';
		type = 'PUT';
		bno = this.value;

		// content 담기
		var row = $(this).parent().parent().parent();
		var tr = row.children();
		var title = tr.eq(1).text();
		var content = tr.eq(3).text();
        var writer = '';

		$("#myModal").modal();
		$("#modal-title").text("수정 페이지");
        $("#title").val(title);
        $("#content").val(content);
		$("#writer").val(writer);

	});

	//delModal 의 delSubmit 버튼 클릭
	$("#delSubmit").click(function () {
		action='delete'
		url = '/board';
		bno = this.value;
		//alert( $("#writer").val());

		//var writer =  $("input=writer").val();
		var writer =  $('input#writer')[1].value;
		var realwriter = $("#realwriter").val();

		console.log(writer);

		if( writer==realwriter) {
			$.ajax({
				url: '/board/' + bno,
				type: 'DELETE',
				data: data,
				success: function (data) {
					$("#delModal").modal('toggle');
				},
				complete: function (data) {
					location.reload();
				}
			});
		}else {
			alert("입력한비번: "+writer+"진짜비번: "+realwriter);
		}

	})

	// Modal의 Submit 버튼 클릭
	$("#modalSubmit").click(function(){

		if(action == 'create'){
			bno = 0;
			url = '/board';
		}else if(action == 'modify'){
			url = '/board';
		}

		var data = {
			"bno" : bno,
			"writer" : $("#writer").val(),
			"title" : $("#title").val(),
			"content" : $("#content").val()
		};

		$.ajax({
			url : url,
			type : type,
			data : data,
			success : function(data) { $("#myModal").modal('toggle'); },
			complete : function (data) {location.reload(); }

		})
	});

	// 삭제하기 버튼 클릭
	$("button[name='delete']").click(function(){
		bno = this.value;

		// content 담기
		var row = $(this).parent().parent().parent();
		var tr = row.children();
		var writer = tr.eq(5).text();

		//alert(writer);
		$("#realwriter").val(writer);
		$("#delModal").modal();
	})


});

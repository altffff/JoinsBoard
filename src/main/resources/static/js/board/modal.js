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
       // bno = this.value;
		url = '/board'+bno;
		var writer =  $('input#writer')[1].value;
		var realwriter = $("#realwriter").val();
		var delbno = $("#realbno").val();


		if( writer==realwriter) {
            $.ajax({
                async : false,
                url : "/board/" + delbno,
                type : "DELETE",

                success : function() { $("#myModal").modal('toggle'); },
                complete : function () {location.reload(); }
            });
		}else {
			alert("패스워드가 틀렸습니다");
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

		if($("#title").val()!='' &&  $("#writer").val()!=''){
			$.ajax({
				url : url,
				type : type,
				data : data,
				success : function(data) { $("#myModal").modal('toggle'); },
				complete : function (data) {location.reload(); }

			})
		}else alert("제목과 패스워드는 공백을 허용하지 않습니다")
	});

	// 삭제하기 버튼 클릭
	$("button[name='delete']").click(function(){
		bno = this.value;

		// content 담기
		var row = $(this).parent().parent().parent();
		var tr = row.children();
		var writer = tr.eq(5).text();
		console.log(bno);

		//alert(writer);
		$("#realwriter").val(writer);
		$("#realbno").val(bno);
		$("#delModal").modal();
	})


});

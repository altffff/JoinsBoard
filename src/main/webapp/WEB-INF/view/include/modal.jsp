<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 id="modal-title" class="modal-title"></h4>
			</div>
			<div class="modal-body">
				<table class="table">
					<tr>
						<td>글제목</td>
						<td><input class="form-control" id="title" type="text"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea class="form-control" id="content" rows="10" ></textarea></td>
					</tr>
					<tr>
						<td>사용자</td>
						<td><input class="form-control" id="writer" type="text"></td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<button id="modalSubmit" type="button" class="btn btn-success">Submit</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
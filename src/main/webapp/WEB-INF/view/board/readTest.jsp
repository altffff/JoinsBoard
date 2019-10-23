<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<title>Test Read Data</title>
</head>
<body>
	<div class="container">
		<h2>Board</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="col-md-1">bno</th>
					<th class="col-md-7">content</th>
					<th class="col-md-2">writer</th>
					<th class="col-md-2">수정 / 삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${tbl_board.bno}</td>
						<td><a href="#">${tbl_board.content}</a></td>
						<td>${tbl_board.writer}</td>
						<td>
							<div class="btn-group">
								<button class="btn btn-xs btn-warning">수정</button>
								<button class="btn btn-xs btn-danger">삭제</button>														
							</div>						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button>새 글 쓰기</button>
	</div>
</body>
</html>
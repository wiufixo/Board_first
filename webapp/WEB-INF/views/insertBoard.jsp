<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<%@ include file="/WEB-INF/include/include_header.jspf" %>
</head>
<body>
	<form id="frm" action="insertBoard" method="post" enctype="multipart/form-data">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*">
			</colgroup>
			<caption>게시글작성</caption>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td><input type="text" name="title" class="wdp_90"></td>
				</tr>
				<tr>
					<th scope="row">내용</th>
					<td><textarea rows="20" cols="100" id="content" name="content"></textarea></td>
				</tr>
			</tbody>
		</table>
		<br>
		<a href="#" id="list" class="btn">목록으로</a>
		<a href="#" id="write" class="btn">작성</a>
	</form>
	<%@ include file="/WEB-INF/include/include_body.jspf" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#list").on("click", function(e){
				e.preventDefault();
				fn_listBoard();
			})
			$("write").on("click", function(e){
				e.preventDefault();
				fn_insertBoard();
			})
		});
		
		function fn_listBoard(){
			var comSubmit = new Comsubmit();
			comSubmit.setUrl("<c:url value='/listBoard'/>");
			comSubmit.submit();
		}
		function fn_writeBoard(){
			var comSubmit = new Comsubmit("frm");
			comSubmit.setUrl("<c:url value='/insertBoard'/>");
			comSubmit.submit();
		}
	</script>
	제목: <input type="text" name="title">
	내용: <textarea rows="10" cols="50"></textarea>
	파일: <input type="file" name="uploadFile">
</body>
</html>
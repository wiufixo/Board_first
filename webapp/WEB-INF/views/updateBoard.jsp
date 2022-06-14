<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateBoard" method="post" enctype="multipart/form-data">
		제목: <input type="text" name="title" value="${b.title }">
		내용: <textarea rows="10" cols="50">${b.content }</textarea>
		파일: <input type="file" name="uploadFile">
	</form>
</body>
</html>
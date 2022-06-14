<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/include/include_header.jspf" %>
</head>
<body>
	<h2>게시판 목록</h2>
	<table style="border: 1px solid #ccc" class="board_list">
		<colgroup>
			<col width="10%">
			<col width="*">
			<col width="15%">
			<col width="20%">
		</colgroup>
		<thead>
			<tr>
				<th scope="col">글제목</th>
				<th scope="col">닉네임</th>
				<th scope="col">작성일</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${f:length(list) > 0 }">
					<c:forEach var="b" items="${list }">
					<tr>
						<td>${b.boardNo }</td>
						<td><a href="/detailBoard?no=${b.boardNo }">${b.title }</a></td>
						<td>${b.nickName }</td>
						<td>${b.created }</td>
						<td>${b.hit }</td>
					</tr>
					</c:forEach>
				</c:when>		
				<c:otherwise>
					<tr>
						<td colspan="4">등록된 게시글이 없습니다.</td>
					</tr>
				</c:otherwise>		
			</c:choose>
		</tbody>
	</table>
	<a href="#" id="write" class="btn">글쓰기</a>
</body>
<%@ include file="/WEB-INF/include/include_body.jspf" %>
<script type="text/javascript">
    $(document).ready(function(){
        $("#write").on("click",function(e){
            e.preventDefault();
            fn_insertBoard();
        })
    })
     
    function fn_insertBoard(){
        var comSubmit = new ComSubmit();
        comSubmit.setUrl("<c:url value='/sample/insertBoard'/>");
        comSubmit.submit();
    }
</script>
</html>
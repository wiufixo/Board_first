<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<%@ include file="/WEB-INF/include/include_header.jspf" %>
</head>
<body>
    <table class="board_view">
        <caption>상세보기</caption>
        <colgroup>
            <col width="15%">
            <col width="35%">
            <col width="15%">
            <col width="*">
        </colgroup>
        <tbody>
            <tr>
                <th>제목</th>
                <td>${b.title}</td>
                <th>조회수</th>
                <td>${b.hit }</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${b.nickName }</td>
                <th>작성시간</th>
                <td>${b.created }</td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    ${b.content }
                </td>
            </tr>
        </tbody>
    </table>
    <a href="#" id="list" class="btn">목록으로</a>
    <a href="/updateBoard?no=${b.boardNo }" id="update" class="btn">수정하기</a>
    
   <%@ include file="/WEB-INF/include/include_body.jspf" %>
     
    <script type="text/javascript">
        $(document).ready(function(){
            $("#list").on("click",function(e){
                e.preventDefault();
                fn_listBoard();
            })
        })
         
        function fn_listBoard(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/listBoard'/>");
            comSubmit.submit();
        }
    </script> 
</body>
</html>
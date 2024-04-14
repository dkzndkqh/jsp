<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.Data, java.util.ArrayList" %>
<jsp:useBean id="boardList" class="java.util.ArrayList" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
<center>
<h2>단순 게시판</h2>
<hr>
<br>
<a href="board_form.jsp">게시글 작성</a>
<br><br>
<table border="1">
<tr>
	<th>번호</th><th>제목</th><th>내용</th><th>작성자</th><th>작성날짜</th>
</tr>
<%
for(Data d : (ArrayList<Data>)boardList) {
%>
<tr>
	<td><a href="page_control.jsp?action=edit&no=<%= d.getNo() %>"><%= d.getNo() %></a></td>
	<td><%= d.getTitle() %></td>
	<td><%= d.getContent() %></td>
	<td><%= d.getWriter() %></td>
	<td><%= d.getDate() %></td>
</tr>
<%
}
%>
</table>
</center>
</body>
</html>
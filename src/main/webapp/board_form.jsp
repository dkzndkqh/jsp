<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성 페이지</title>
</head>
<body>
<center>
<h2>게시글 작성 페이지</h2>
<hr>
<form method="post" name="form1" action="page_control.jsp">
<input type="hidden" name="action" value="insert">
<table border="1">
<tr>
	<td>제목</td>
	<td><input type="text" name="title"></td>
</tr>
<tr>
	<td>본문</td>
	<td><input type="text" name="content"></td>
</tr>
<tr>
	<td>작성자</td>
	<td><input type="text" name="writer"></td>
</tr>
<tr align="center">
	<td colspan="2">
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</td>
</tr>
</table>
</form>

</center>
</body>
</html>
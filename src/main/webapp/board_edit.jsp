<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="oneData" class="board.Data" scope="request"></jsp:useBean>
<!DOCTYPE html>


<script type="text/javascript">
	function delcheck() {
		result = confirm("삭제 할꺼냥?");
		
		if(result == true) {
			document.form1.action.value="delete";
			document.form1.submit();
			
		}
		else
			return;
	}
</script>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
</head>
<body>
<form method="post" name="form1" action="page_control.jsp">
<input type="hidden" name="action" value="update">
<table border="1">
<tr>
	<td>번호</td>
	<td><input type="text" name="no" value="<%= oneData.getNo() %>"></td>
</tr>
<tr>
	<td>제목</td>
	<td><input type="text" name="title" value="<%= oneData.getTitle() %>"></td>
</tr>
<tr>
	<td>본문</td>
	<td><input type="text" name="content" value="<%= oneData.getContent() %>"></td>
</tr>
<tr>
	<td>작성자</td>
	<td><input type="text" name="writer" value="<%= oneData.getWriter() %>"></td>
</tr>
<tr align="center">
	<td colspan="2">
		<input type="submit" value="등록">
		<input type="reset" value="취소">
		<input type="button" value="삭제" onClick="delcheck()">
	</td>
</tr>
</table>
</form>
</body>
</html>
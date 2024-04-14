<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.*, java.util.ArrayList" errorPage="error_page.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="man" class="board.Manager"></jsp:useBean>
<jsp:useBean id="data" class="board.Data"></jsp:useBean>
<jsp:setProperty property="*" name="data"/>
<%
String action = request.getParameter("action");

if(action.equals("list")){
	ArrayList<Data> list = man.getDBList();
	request.setAttribute("boardList", list);
	pageContext.forward("board_list.jsp");
	
} else if(action.equals("insert")){
	if(man.insertDB(data)){
		response.sendRedirect("page_control.jsp?action=list");
	} else {
		throw new Exception("DB 입력 오류!");
	}
} else if(action.equals("edit")){
	int iNum = Integer.parseInt(request.getParameter("no"));
	Data d = man.getRecord(iNum);
	request.setAttribute("oneData", d);
	pageContext.forward("board_edit.jsp");
	
} else if(action.equals("update")){
	if(man.updateRecord(data)){
		response.sendRedirect("page_control.jsp?action=list");
	} else {
		throw new Exception("DB 업데이트 실패!");
	}
} else if(action.equals("delete")){
	if(man.deleteRecord(data.getNo())) {
		response.sendRedirect("page_control.jsp?action=list");
	} else {
		throw new Exception("DB 삭제 실패!");
	}
	
} else {
	
}



%>

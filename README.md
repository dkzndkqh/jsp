MVC 패턴의 게시판 JSP

Model -> Data.java , Manager.java 

View -> board_edit.jsp, board_form.jsp, board_list.jsp, error_page.jsp 

Controller -> page.control.jsp, index.jsp 


Data.java -> 데이터베이스에 저장된 값을 읽어오거나 설정하기 DO 객체 클래스

Manager.java -> SQL관련 객체와 데이터베이스 연결, CRUD 메소드를 가진 클래스

board_edit.jsp -> 게시글 수정 페이지

board.form.jsp -> 게시글 작성 페이지

board_list.jsp -> 게시판 목록 페이지

error_page.jsp -> 오류 발생시 나오는 페이지

page.control.jsp -> 사용자의 요청에 따라 어느 페이지로 가게 할지 지정해줌 


package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Manager {
	// sql 관련 객체 선언
	private Connection conn = null; // 연결에 사용할 객체
	private PreparedStatement pstmt = null; // sql 문장을 만들기 위한 객체
	
	
	
	
	// 필요 문자열 선언
	private String jdbc_driver = "com.mysql.jdbc.Driver"; // 드라이버 로딩시 필요한 문장을 미리 정의
	private String jdbc_url = "jdbc:mysql://localhost:3306/my_board?serverTimezone=UTC&characterEncoding=UTF-8"; // 드라이버로 연결할 DBMS의 위치 정보를 미리 정의

	private boolean connect() { // DB에 연결 작업 수행(드라이버 로딩 포함)
		boolean isOk = false;

		try {
			//1. 드라이버 로딩
			Class.forName(jdbc_driver);
			//2. 연결
			conn = DriverManager.getConnection(jdbc_url, "root", "1234");
			isOk = true;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return isOk;
	}
	
	private void disconnect() { // DB 연결 종료 처리 수행
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean insertDB(Data _data) {
		
		Date date = new Date();
		SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String currentdate = mFormat.format(date);
				
		boolean isOk = false;

		if(connect()) {
			String sql = "insert into board(title, content, writer, date) values(?,?,?,?)";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, _data.getTitle());
				pstmt.setString(2, _data.getContent());
				pstmt.setString(3, _data.getWriter());
				pstmt.setString(4, currentdate);
				pstmt.executeUpdate();
				isOk = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				disconnect();	
			}	
		}		
		
		return isOk;
	}
	
	public ArrayList getDBList(){		
		ArrayList<Data> list = new ArrayList<Data>();
		
		if(connect()) {
			String sql = "select * from board";
			
			try {
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Data d = new Data();
					d.setNo(rs.getInt(1));
					d.setTitle(rs.getString(2));
					d.setContent(rs.getString(3));
					d.setWriter(rs.getString(4));
					d.setDate(rs.getString(5));
					list.add(d);
				}
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				disconnect();	
			}			
		}		
		
		return list;
	}
	
	public Data getRecord(int iNum) {
		Data data = null;
		
		if(connect()) {
			String sql = "select * from board where no = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, iNum);
				ResultSet rs = pstmt.executeQuery();
				
				rs.next();
				data = new Data();
				data.setNo(rs.getInt(1));
				data.setTitle(rs.getString(2));
				data.setContent(rs.getString(3));
				data.setWriter(rs.getString(4));
				
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		
		return data;
	}
	
	public boolean deleteRecord(int iNum) {
		boolean isOk = false;
		
		if(connect()) {
			String sql = "delete from board where no=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, iNum);
				pstmt.executeUpdate();
				isOk = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		
		return isOk;
	}
	
	public boolean updateRecord(Data _data) {
		boolean isOk = false;
		
		if(connect()) {
			String sql = "update board set title=?, content=?, writer=? where no=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, _data.getTitle());
				pstmt.setString(2, _data.getContent());
				pstmt.setString(3, _data.getWriter());
				pstmt.setInt(4, _data.getNo());
				pstmt.executeUpdate();
				isOk = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				disconnect();
			}			
		}
		
		return isOk;
	}

}






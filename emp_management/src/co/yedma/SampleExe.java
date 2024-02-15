package co.yedma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SampleExe {
	
	static void insertEmp(Connection conn) throws SQLException{
		String sql = "INSERT INTO employee ( emp_no,\r\n"
				+ "                       emp_name,\r\n"
				+ "                       email,\r\n"
				+ "                       phone,\r\n"
				+ "                       salary,\r\n"
				+ "                       department)\r\n"
				+ "VALUES (?,\r\n"
				+ "        ?,\r\n"
				+ "        ?,\r\n"
				+ "        ?,\r\n"
				+ "        ?,\r\n"
				+ "        ?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, 777);
		psmt.setString(2, "박과장");
		psmt.setString(3, "park@email.com");
		psmt.setString(4, "234-4567");
		psmt.setString(5, "456");
		psmt.setString(6, "인사");
		
		int r = psmt.executeUpdate(); //insert, update, delete
		System.out.println("처리된 건수:" + r);
		if(r>0) {
			conn.commit();//커밋처리.
			System.out.println("정상적 입력");
		}else {
			conn.rollback();//롤백처리
		}
	}
	
	public static void main(String[] args) {
		
		
		String dept = "인사"; //select * from employee where department = '인사'
		int page = 2;
		EmpDAO edao = new EmpDAO();
		List<Employee> list = edao.getList(dept, page);
		System.out.println("사원번호    이름     전화번호   부서");
		System.out.println("===============================");
		for(Employee emp : list) {
			System.out.println(emp.getEmpNo() + "  " + emp.getEmpName() + "   " + emp.getPhone() + "   " + emp.getDepartment());
		}
		System.out.println("===============================");
		
	}
}

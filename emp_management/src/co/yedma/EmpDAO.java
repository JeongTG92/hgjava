package co.yedma;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

import oracle.jdbc.proxy.annotation.GetDelegate;

//Datebase 처리기능.
public class EmpDAO {
	// 필드.
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

//	void disconn() {
//		try {
//			if(conn != null) {
//			   conn.close();
//			}
//			if(psmt != null) {
//			   psmt.close();
//			}
//			if(rs != null) {
//			   rs.close();
//			}
//           catch (SQLException e) {
//					e.printStackTrace();
//           }finally {
//   			disconn();
//   		}
//		
//
//	}

	// 입력
	public boolean insertEmp(Employee emp) {
		conn = DAO.getConn();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		sql = "INSERT INTO employee ( emp_no,\r\n" + "                          emp_name,\r\n"
				+ "                          email,\r\n" + "                          phone,\r\n"
				+ "                          salary,\r\n" + "                          hire_date,\r\n"
				+ "                          department)\r\n" + "VALUES (?,\r\n" + "        ?,\r\n" + "        ?,\r\n"
				+ "        ?,\r\n" + "        ?,\r\n" + "        ?,\r\n" + "        ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmpNo());
			psmt.setString(2, emp.getEmpName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getPhone());
			psmt.setInt(5, emp.getSalary());
			psmt.setString(6, sdf.format(emp.getHireDate()));
			psmt.setString(7, emp.getDepartment());

			int r = psmt.executeUpdate(); // 데이터 반영
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} /*finally {
			disconn();
		}*/
		return false;
	}

	// 목록
	public List<Employee> getList(String dept, int page) {
		// "인사" vs ""
		conn = DAO.getConn(); // connection 객체생성
		List<Employee> list = new ArrayList<Employee>();
		sql = "SELECT emp_no,\r\n" + "        emp_name,\r\n" + "        email,\r\n" + "        phone,\r\n"
				+ "        hire_date,\r\n" + "        salary,\r\n" + "       department\r\n" + "FROM(\r\n"
				+ "     SELECT rownum rn, a.*\r\n" + "     FROM(SELECT *\r\n" + "          FROM employee\r\n"
				+ "          WHERE department = nvl(?, department) \r\n" + "          ORDER BY emp_no) a ) b\r\n"
				+ "WHERE b.rn > (? -1) * 5  and b.rn <= (?) * 5";
		try {
			psmt = conn.prepareStatement(sql);
			// if(!dept.equals("")) {
			psmt.setString(1, dept);
			psmt.setInt(2, page);
			psmt.setInt(3, page);
			// }
			rs = psmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDepartment(rs.getString("department"));
				list.add(emp); // DB -> collection
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}  /*finally {
		disconn();
	}*/

		return list;
	}

	// 수정
	public boolean updateEmp(Employee emp) {
		System.out.println(emp);
		conn = DAO.getConn();
		sql = "update employee "// 공백 표시 잘할것
				+ "set department = ? ";
		if (!emp.getPhone().equals("")) {
			sql += ", phone = ?";

		}
		sql += " where emp_no = ?";
		int p = 1;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(p++, emp.getDepartment());
			if (!emp.getPhone().equals("")) {
				psmt.setString(p++, emp.getPhone());
			}
			psmt.setInt(p++, emp.getEmpNo());
			int r = psmt.executeUpdate();// 처리된 건수 반환
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  /*finally {
		disconn();
	}*/
		return false;

	}

	public boolean deleteEmp(int eno) {
		conn = DAO.getConn();
		sql = "delete from employee where emp_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eno);

			int r = psmt.executeUpdate();// 처리된 건수 반환
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  /*finally {
		disconn();
	}*/
		return false;

	}

	// 부서별 인원
	public int getTotalCnt(String dept) {
		conn = DAO.getConn();
		sql = "select count(*) from employee " + "where department = nvl(?,department)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dept);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}  /*finally {
		disconn();
	}*/
		return -1;
	}
}
